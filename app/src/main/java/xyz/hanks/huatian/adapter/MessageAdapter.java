package xyz.hanks.huatian.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.bean.MessageItem;

public class MessageAdapter extends BasicAdapter<MessageItem> {

    public MessageAdapter(Context context, List<MessageItem> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_message, null);
        }

        ImageView iv_avatar = ViewHolder.get(convertView, R.id.iv_avatar);
        TextView tv_nick = ViewHolder.get(convertView, R.id.tv_nick);
        TextView tv_content = ViewHolder.get(convertView, R.id.tv_content);

        MessageItem item = list.get(position);

        tv_content.setText(item.getContent());
        switch (item.getType()) {
            case MessageItem.TYPE_MESSAGE:
                setMessageView(item, iv_avatar, tv_nick);
                break;
            case MessageItem.TYPE_PRAISE:
                setPraiseView(item, iv_avatar, tv_nick);
                break;
            case MessageItem.TYPE_VISITOR:
                setVisitorView(item, iv_avatar, tv_nick);
                break;
        }

        return convertView;
    }

    private void setVisitorView(MessageItem item, ImageView iv_avatar, TextView tv_nick) {
        iv_avatar.setImageResource(R.drawable.base_avatar_visitor);
        tv_nick.setText("");
    }

    private void setPraiseView(MessageItem item, ImageView iv_avatar, TextView tv_nick) {
        iv_avatar.setImageResource(R.drawable.base_avatar_praise);
        tv_nick.setText("");
    }

    private void setMessageView(MessageItem item, ImageView iv_avatar, TextView tv_nick) {
        loader.displayImage(item.getUserFrom().getAvatar(), iv_avatar, option_photo);
        tv_nick.setText(item.getUserFrom().getNick());
    }

}
