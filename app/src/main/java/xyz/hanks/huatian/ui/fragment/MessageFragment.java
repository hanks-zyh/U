package xyz.hanks.huatian.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.adapter.MessageAdapter;
import xyz.hanks.huatian.bean.MessageItem;
import xyz.hanks.huatian.config.ConfigIntent;
import xyz.hanks.huatian.net.NetManager;
import xyz.hanks.huatian.ui.activity.ChatActivity;
import xyz.hanks.huatian.util.A;

public class MessageFragment extends BaseFragment {
    private ListView listview;
    private List<MessageItem> list;
    private MessageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        init(v);
        return v;
    }

    private void init(View view) {
        listview = (ListView) view.findViewById(R.id.listview);
        list = NetManager.getMessageList();
        adapter = new MessageAdapter(context, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnMessageClickListener());
    }

    /**
     * 点击消息,
     *
     * @author zyh
     * @version 1.0
     */
    class OnMessageClickListener implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MessageItem item = list.get(position);
            if (item.getType() == MessageItem.TYPE_MESSAGE) { // 聊天
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra(ConfigIntent.EXTRA_USER_FROM, item.getUserFrom());
                A.goOtherActivity(context, intent);
            } else if (item.getType() == MessageItem.TYPE_FOLLOW) { // 有人关注

            } else if (item.getType() == MessageItem.TYPE_PRAISE) { // 有人赞了

            } else if (item.getType() == MessageItem.TYPE_VISITOR) {// 有人访问

            }
        }
    }
}
