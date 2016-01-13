package xyz.hanks.huatian.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.bean.EncounterItem;
import xyz.hanks.huatian.service.LocationManager;

public class EncounterAdapter extends BasicAdapter<EncounterItem> {
    PopupWindow popupWindow;

    public EncounterAdapter(final Context context, List<EncounterItem> list) {
        super(context, list);
        View v = View.inflate(context, R.layout.popup_encounter, null);
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
            convertView = View.inflate(context, R.layout.list_item_encounter, null);
        }

        ImageView iv_avatar = ViewHolder.get(convertView, R.id.iv_avatar);
        TextView tv_nick = ViewHolder.get(convertView, R.id.tv_nick);
        TextView tv_age = ViewHolder.get(convertView, R.id.tv_age);
        TextView tv_height = ViewHolder.get(convertView, R.id.tv_height);
        TextView tv_album = ViewHolder.get(convertView, R.id.tv_album);
        TextView tv_location = ViewHolder.get(convertView, R.id.tv_location);
        TextView tv_education = ViewHolder.get(convertView, R.id.tv_education);
        TextView tv_money = ViewHolder.get(convertView, R.id.tv_money);
        TextView tv_content = ViewHolder.get(convertView, R.id.tv_content);

        //
        // // 模拟赞状态
        // Button btn_zan = ViewHolder.get(convertView, R.id.btn_zan);
        // btn_zan.setSelected(position % 3 == 0);
        // btn_zan.setTextColor(position % 3 == 0 ? Color.RED : Color.GRAY);
        // btn_zan.setOnClickListener(new OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // T.show(context, "赞一下");
        // }
        // });
        //
        final EncounterItem item = list.get(position);
        loader.displayImage(item.getUser().getAvatar(), iv_avatar, option_photo);
        tv_content.setText(item.getContent());
        tv_nick.setText(item.getUser().getNick());
        tv_age.setText(item.getUser().getAge() + "岁");
        tv_height.setText(item.getUser().getHeight() + "cm");
        tv_album.setText(item.getUser().getAlbum().size() + "");
        tv_education.setText(item.getUser().getEducation());
        tv_money.setText(item.getUser().getMoney());
        tv_location.setText(LocationManager.calcDistance(item.getUser().getLongitude(), item.getUser()
                .getLatitude()));

        // 点击事件处理
        // 不喜欢
        // Button btn_unlike = ViewHolder.get(convertView, R.id.btn_unlike);
        // btn_unlike.setOnClickListener(new OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // OnUnlikeClick(item);
        // }
        // });
        // // 打招呼
        // Button btn_sayhi = ViewHolder.get(convertView, R.id.btn_sayhi);
        // btn_sayhi.setOnClickListener(new OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // OnSayhiClick(item);
        // }
        // });
        // 收藏
        Button btn_collect = ViewHolder.get(convertView, R.id.btn_collect);
        btn_collect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                OnCollectClick(item);
            }
        });

        // 时间下拉
        TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);
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
        return convertView;
    }

    /**
     * 打招呼
     *
     * @param item
     * @version 1.0
     * @author zyh
     */
    private void OnSayhiClick(EncounterItem item) {

    }

    /**
     * 不喜欢
     *
     * @param item
     * @version 1.0
     * @author zyh
     */
    private void OnUnlikeClick(EncounterItem item) {

    }

    /**
     * 收藏
     *
     * @param item
     * @version 1.0
     * @author zyh
     */
    private void OnCollectClick(EncounterItem item) {

    }
}
