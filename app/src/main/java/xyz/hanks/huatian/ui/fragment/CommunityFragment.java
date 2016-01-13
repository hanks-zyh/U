package xyz.hanks.huatian.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.adapter.CommunityAdapter;
import xyz.hanks.huatian.bean.CommunityItem;
import xyz.hanks.huatian.net.NetManager;
import xyz.hanks.huatian.ui.activity.TopicActivity;
import xyz.hanks.huatian.util.A;

public class CommunityFragment extends BaseFragment {
    private ListView listview;
    private List<CommunityItem> list;
    private CommunityAdapter adapter;
    private GridView gridview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);
        init(v);
        return v;
    }

    private void init(View view) {
        // listview = (ListView) view.findViewById(R.id.listview);
        gridview = (GridView) view.findViewById(R.id.gridview);
        list = NetManager.getCommunityList();
        adapter = new CommunityAdapter(context, list);
        // listview.setAdapter(adapter);
        // listview.setOnItemClickListener(new OnItemClickListener() {
        // @Override
        // public void onItemClick(AdapterView<?> parent, View view, int
        // position, long id) {
        // goCommunityActivity(position);
        // }
        // });
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goCommunityActivity(position);
            }
        });
    }

    /**
     * 进去item的页面
     *
     * @param position
     * @version 1.0
     * @author zyh
     */
    private void goCommunityActivity(int position) {
        Intent intent = new Intent(context, TopicActivity.class);
        intent.putExtra("item", list.get(position));
        A.goOtherActivity(context, intent);
    }
}
