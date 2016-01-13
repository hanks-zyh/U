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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.bean.ActivityItem;
import xyz.hanks.huatian.service.LocationManager;
import xyz.hanks.huatian.util.TimeUtil;

public class ActivityAdapter extends BasicAdapter<ActivityItem> {
    PopupWindow popupWindow;

    public ActivityAdapter(final Context context, List<ActivityItem> list) {
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
            convertView = View.inflate(context, R.layout.list_item_activity, null);
        }
        ImageView iv_avatar = ViewHolder.get(convertView, R.id.iv_avatar);
        TextView tv_nick = ViewHolder.get(convertView, R.id.tv_nick);
        TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);
        TextView tv_age = ViewHolder.get(convertView, R.id.tv_age);
        TextView tv_height = ViewHolder.get(convertView, R.id.tv_height);
        TextView tv_album = ViewHolder.get(convertView, R.id.tv_album);
        TextView tv_location = ViewHolder.get(convertView, R.id.tv_location);

        TextView tv_topic = ViewHolder.get(convertView, R.id.tv_topic);
        TextView tv_topic_label = ViewHolder.get(convertView, R.id.tv_topic_label);
        TextView tv_paytype = ViewHolder.get(convertView, R.id.tv_paytype);
        TextView tv_date_time = ViewHolder.get(convertView, R.id.tv_date_time);
        TextView tv_date_location = ViewHolder.get(convertView, R.id.tv_date_location);
        TextView tv_detail = ViewHolder.get(convertView, R.id.tv_detail);

        ActivityItem item = list.get(position);
        loader.displayImage(item.getUser().getAvatar(), iv_avatar, option_photo);
        tv_time.setText(TimeUtil.getDescriptionTimeFromTimestamp(item.getCreateTime()));
        tv_nick.setText(item.getUser().getNick());
        tv_age.setText(item.getUser().getAge() + "岁");
        tv_height.setText(item.getUser().getHeight() + "cm");
        tv_album.setText(item.getUser().getAlbum().size() + "");
        tv_location.setText(LocationManager.calcDistance(item.getUser().getLongitude(), item.getUser()
                .getLatitude()));

        tv_topic.setText(item.getTopic());
        tv_topic_label.setText(item.getTopicType());
        tv_paytype.setText(item.getPayType());
        tv_date_time.setText(item.getTime());
        tv_date_location.setText(item.getLocation());
        tv_detail.setText(item.getDetail());
        // 设置监听
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

}
