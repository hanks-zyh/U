package xyz.hanks.huatian.ui.page;

import android.content.Context;
import android.view.View;

/**
 * 自定义的视图的基类 </p> 需要生命周期的话需要在Activity或fragment的生命周期中调用
 *
 * @author zyh
 * @version 1.0
 */
public abstract class BasePage {

    public Context context;
    private View view;

    public BasePage(Context context) {
        this.context = context;
        view = onCreateView();
        initData(view);
    }

    public abstract View onCreateView();

    public abstract void initData(View view);

    /**
     * 返回根视图
     *
     * @return
     * @version 1.0
     * @author zyh
     */
    public View getRootView() {
        return view;
    }

    public void onCreate() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }
}
