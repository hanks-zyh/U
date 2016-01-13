package xyz.hanks.huatian.ui.page;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.adapter.ActivityAdapter;
import xyz.hanks.huatian.bean.ActivityItem;
import xyz.hanks.huatian.net.NetManager;

/**
 * 首页里的"活动页面"
 *
 * @author zyh
 * @version 1.0
 */
public class ActivityPage extends BasePage {

    private ListView listview;
    private List<ActivityItem> list;
    private ActivityAdapter adapter;

    public ActivityPage(Context context) {
        super(context);
    }

    @Override
    public View onCreateView() {
        return View.inflate(context, R.layout.page_activity, null);
    }

    @Override
    public void initData(View view) {
        listview = (ListView) view.findViewById(R.id.listview);
        list = NetManager.getActivityList();
        adapter = new ActivityAdapter(context, list);
        listview.setAdapter(adapter);
    }

}
