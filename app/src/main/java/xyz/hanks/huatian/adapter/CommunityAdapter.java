package xyz.hanks.huatian.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.bean.CommunityItem;

public class CommunityAdapter extends BasicAdapter<CommunityItem> {

    String[] colors = new String[]{"#F57B6F", "#F1BF53", "#5CBBCC", "#739E53", "#704B0D", "#F4C3C3"};

    public CommunityAdapter(Context context, List<CommunityItem> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_community, null);
        }

        TextView tv_logo = ViewHolder.get(convertView, R.id.tv_logo);
        GradientDrawable bgShape = (GradientDrawable) tv_logo.getBackground();
        bgShape.setColor(Color.parseColor(colors[position % colors.length]));
        TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);
        TextView tv_description = ViewHolder.get(convertView, R.id.tv_description);

        CommunityItem item = list.get(position);
        try {
            tv_logo.setText(item.getTitle().substring(0, 2));
        } catch (Exception e) {
            tv_logo.setText(item.getTitle().substring(0, 1));
            e.printStackTrace();
        }
        tv_title.setText(item.getTitle());
        tv_description.setText("话题" + item.getTopicCount() + "    参与人数" + item.getPeople());

        return convertView;
    }

}
