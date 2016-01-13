package xyz.hanks.huatian.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.bean.TopicItem;
import xyz.hanks.huatian.ui.view.CircularImageView;
import xyz.hanks.huatian.util.PixelUtil;
import xyz.hanks.huatian.util.TimeUtil;

public class TopicAdapter extends BasicAdapter<TopicItem> {

    LinearLayout.LayoutParams params;

    public TopicAdapter(Context context, List<TopicItem> list) {
        super(context, list);
        params = new LinearLayout.LayoutParams(PixelUtil.dp2px(70), PixelUtil.dp2px(70));
        params.setMargins(5, 5, 5, 5);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_topic, null);
        }

        TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);
        TextView tv_content = ViewHolder.get(convertView, R.id.tv_content);
        LinearLayout layout_images = ViewHolder.get(convertView, R.id.layout_images);
        TextView tv_nick = ViewHolder.get(convertView, R.id.tv_nick);
        CircularImageView iv_avatar = ViewHolder.get(convertView, R.id.iv_avatar);
        TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);

        TopicItem item = list.get(position);
        loader.displayImage(item.getUser().getAvatar(), iv_avatar, option_photo);
        tv_title.setText(item.getTitle());
        tv_content.setText(item.getContent());
        tv_nick.setText(item.getUser().getNick() + "  发布");
        tv_time.setText(item.getCommentCount() + " | "
                + TimeUtil.getDescriptionTimeFromTimestamp(item.getCreateAt()));
        ArrayList<String> images = item.getImages();
        layout_images.removeAllViews();
        if (images != null && images.size() > 0) {
            for (String url : images) {
                ImageView iv = new ImageView(context);
                iv.setLayoutParams(params);
                iv.setScaleType(ScaleType.CENTER_CROP);
                loader.displayImage(url, iv, option_pic);
                layout_images.addView(iv);
            }
            layout_images.setVisibility(0);
        }
        return convertView;
    }
}
