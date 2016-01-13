package xyz.hanks.huatian.ui.page;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.adapter.DynamicAdapter;
import xyz.hanks.huatian.bean.DynamicItem;
import xyz.hanks.huatian.net.NetManager;

/**
 * 首页里面的"动态"界面
 *
 * @author zyh
 * @version 1.0
 */
public class DynamicPage extends BasePage {

    private ListView listview;
    private List<DynamicItem> list;
    private DynamicAdapter adapter;

    public DynamicPage(Context context) {
        super(context);
    }

    @Override
    public View onCreateView() {
        return View.inflate(context, R.layout.page_dynamic, null);
    }

    @Override
    public void initData(View view) {
        listview = (ListView) view.findViewById(R.id.listview);
        list = NetManager.getDynamicList();
        adapter = new DynamicAdapter(context, list);
        listview.setAdapter(adapter);
    }

}
