package xyz.hanks.huatian.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.adapter.EncounterAdapter;
import xyz.hanks.huatian.bean.EncounterItem;
import xyz.hanks.huatian.net.NetManager;
import xyz.hanks.huatian.ui.activity.FilterActivity;
import xyz.hanks.huatian.util.A;

public class EncounterFragment extends BaseFragment {
    private ListView listview;
    private List<EncounterItem> list;
    private EncounterAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_encounter, container, false);
        init(v);
        return v;
    }

    private void init(View view) {

        // 点击筛选按钮
        view.findViewById(R.id.tv_title_left).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goFilterActivity();
            }
        });

        listview = (ListView) view.findViewById(R.id.listview);
        list = NetManager.getEncounterList();
        adapter = new EncounterAdapter(context, list);
        listview.setAdapter(adapter);
    }

    /**
     * 转到筛选界面
     *
     * @version 1.0
     * @author zyh
     */
    private void goFilterActivity() {
        A.goOtherActivity(context, FilterActivity.class);
    }

}
