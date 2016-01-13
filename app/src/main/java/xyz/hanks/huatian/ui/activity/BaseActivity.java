package xyz.hanks.huatian.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import xyz.hanks.huatian.R;


public class BaseActivity extends FragmentActivity {

    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    /**
     * 点击 title里的返回
     *
     * @param v
     * @version 1.0
     * @author zyh
     */
    public void back(View v) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_left_enter, R.anim.activity_right_exit);
    }
}
