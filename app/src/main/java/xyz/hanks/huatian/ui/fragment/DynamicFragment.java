package xyz.hanks.huatian.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.adapter.DynamicAdapter;
import xyz.hanks.huatian.bean.DynamicItem;

/**
 * 使用BasePage
 *
 * @author zyh
 * @version 1.0
 */
@Deprecated
public class DynamicFragment extends BaseFragment {

    private ListView listview;
    private List<DynamicItem> list = new ArrayList<DynamicItem>();
    private DynamicAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page_dynamic, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        listview = (ListView) v.findViewById(R.id.listview);
        adapter = new DynamicAdapter(context, list);
        listview.setAdapter(adapter);
    }

}
