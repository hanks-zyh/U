package xyz.hanks.huatian.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.adapter.TopicAdapter;
import xyz.hanks.huatian.bean.CommunityItem;
import xyz.hanks.huatian.bean.TopicItem;
import xyz.hanks.huatian.net.NetManager;

public class TopicActivity extends BaseActivity {

    private ListView listview;
    private CommunityItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        init();
    }

    private void init() {
        item = (CommunityItem) getIntent().getSerializableExtra("item");
        TextView tv_title_left = (TextView) findViewById(R.id.tv_title_left);
        tv_title_left.setText(item.getTitle());
        initListView();
        initHeadView();
    }

    private void initListView() {
        listview = (ListView) findViewById(R.id.listview);
    }

    private void initHeadView() {

        View headView = View.inflate(context, R.layout.head_topic, null);
        TextView tv_logo = (TextView) headView.findViewById(R.id.tv_logo);
        TextView tv_title = (TextView) headView.findViewById(R.id.tv_title);
        TextView tv_description = (TextView) headView.findViewById(R.id.tv_description);
        tv_logo.setText(item.getTitle().substring(0, 1));

        // 设置颜色
        String topicCount = item.getTopicCount() + "";
        String people = item.getPeople() + "";
        Spannable spannable = new SpannableString("话题数:" + topicCount + "参与者" + people);
        // 设置0-2的字符颜色
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 4, 4 + topicCount.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 7 + topicCount.length(), spannable.length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        tv_title.setText(spannable);
        tv_description.setText(item.getDescription());

        listview.addHeaderView(headView);

        // 这里模拟传过来的id
        List<TopicItem> list = NetManager.getTopicListById(0);
        TopicAdapter adapter = new TopicAdapter(context, list);
        listview.setAdapter(adapter);
    }
}
