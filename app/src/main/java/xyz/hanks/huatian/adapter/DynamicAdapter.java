package xyz.hanks.huatian.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.bean.DynamicItem;
import xyz.hanks.huatian.service.LocationManager;
import xyz.hanks.huatian.ui.activity.PhotoGallery;
import xyz.hanks.huatian.util.A;
import xyz.hanks.huatian.util.TimeUtil;

/**
 * 首页里面的"动态"适配器
 *
 * @author zyh
 * @version 1.0
 */
public class DynamicAdapter extends BasicAdapter<DynamicItem> {

    PopupWindow popupWindow;

    public DynamicAdapter(final Context context, List<DynamicItem> list) {
        super(context, list);
        View v = View.inflate(context, R.layout.popup_dynamic, null);
        popupWindow = new PopupWindow(v, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
                lp.alpha = 1f;
                ((Activity) context).getWindow().setAttributes(lp);
            }
        });
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_dynamic, null);
        }

        ImageView iv_avatar = ViewHolder.get(convertView, R.id.iv_avatar);
        ImageView iv_image = ViewHolder.get(convertView, R.id.iv_image);
        TextView tv_nick = ViewHolder.get(convertView, R.id.tv_nick);
        final TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);
        TextView tv_age = ViewHolder.get(convertView, R.id.tv_age);
        TextView tv_height = ViewHolder.get(convertView, R.id.tv_height);
        TextView tv_album = ViewHolder.get(convertView, R.id.tv_album);
        TextView tv_location = ViewHolder.get(convertView, R.id.tv_location);
        TextView tv_content = ViewHolder.get(convertView, R.id.tv_content);

        final Button btn_zan = ViewHolder.get(convertView, R.id.btn_zan);
        // Button btn_chat = ViewHolder.get(convertView, R.id.btn_chat);

        final DynamicItem item = list.get(position);
        // 模拟赞状态
        updateZanButton(btn_zan, item);
        btn_zan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnimation(btn_zan);
                setItemZan(item);
                updateZanButton(btn_zan, item);
            }
        });
        // // 聊一聊
        // btn_chat.setOnClickListener(new OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // Intent intent = new Intent(context, ChatActivity.class);
        // intent.putExtra(ConfigIntent.EXTRA_USER_FROM, item.getUser());
        // A.goOtherActivity(context, intent);
        // }
        // });

        tv_time.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
                lp.alpha = 0.5f;
                ((Activity) context).getWindow().setAttributes(lp);
                int[] location = new int[2];
                v.getLocationOnScreen(location);
                popupWindow.showAsDropDown(v);
            }
        });
        // 点击查看大图
        iv_image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> album = new ArrayList<String>();
                album.add(item.getImageUrl());
                Intent i = new Intent(context, PhotoGallery.class);
                i.putExtra(PhotoGallery.INTENT_ALBUM, album);
                A.goOtherActivity(context, i);
            }
        });
        loader.displayImage(item.getUser().getAvatar(), iv_avatar, option_photo);
        loader.displayImage(item.getImageUrl(), iv_image, option_pic);
        tv_time.setText(TimeUtil.getDescriptionTimeFromTimestamp(item.getCreateTime()));
        tv_content.setText(item.getContent());
        tv_nick.setText(item.getUser().getNick());
        tv_age.setText(item.getUser().getAge() + "岁");
        tv_height.setText(item.getUser().getHeight() + "cm");
        tv_album.setText(item.getUser().getAlbum().size() + "");
        tv_location.setText(LocationManager.calcDistance(item.getUser().getLongitude(), item.getUser()
                .getLatitude()));
        return convertView;
    }

    /**
     * 修改赞按钮的显示状态
     *
     * @param btn_zan
     * @param item
     * @version 1.0
     * @author zyh
     */
    private void updateZanButton(Button btn_zan, DynamicItem item) {
        btn_zan.setSelected(item.isPraised());
        btn_zan.setText("赞" + item.getZan());
        btn_zan.setTextColor(item.isPraised() ? Color.RED : Color.GRAY);
    }

    protected void setItemZan(DynamicItem item) {
        item.setZan(item.isPraised() ? item.getZan() - 1 : item.getZan() + 1);
        item.setPraised(!item.isPraised());
        // TODO 通知服务器修改
    }

    public void showAnimation(View v) {
        ScaleAnimation sc = new ScaleAnimation(1f, 1.05f, 1f, 1.05f, 0.5f, 0.5f);
        sc.setDuration(100);
        sc.setInterpolator(new OvershootInterpolator());
        v.startAnimation(sc);
    }
}
