package xyz.hanks.huatian.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.ui.fragment.CommunityFragment;
import xyz.hanks.huatian.ui.fragment.EncounterFragment;
import xyz.hanks.huatian.ui.fragment.HomeFragment;
import xyz.hanks.huatian.ui.fragment.MessageFragment;
import xyz.hanks.huatian.ui.fragment.UserFragment;
import xyz.hanks.huatian.ui.view.BottomLayout;
import xyz.hanks.huatian.util.L;


public class MainActivity extends BaseActivity {

    private BottomLayout main_bottom;
    private HomeFragment homeFragment;
    private EncounterFragment encounterFragment;
    private CommunityFragment communityFragment;
    private MessageFragment messageFragment;
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initFragments();
        initView();
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        encounterFragment = new EncounterFragment();
        communityFragment = new CommunityFragment();
        messageFragment = new MessageFragment();
        userFragment = new UserFragment();
    }

    private void initView() {
        // 底部按钮
        main_bottom = (BottomLayout) findViewById(R.id.main_bottom);
        main_bottom.setOnItemClickListener(new BottomLayout.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switchMainContent(position);
            }
        });

        // 模拟新消息
        new Handler().postDelayed(new Runnable() {
            public void run() {
                main_bottom.showMessageNumber("12");
            }
        }, 10000);
        switchMainContent(0);// 默认在首页
    }

    /**
     * 切换主界面
     *
     * @param position
     * @version 1.0
     * @author zyh
     */
    protected void switchMainContent(int position) {
        L.i("" + position);
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = homeFragment;
                break;
            case 1:
                fragment = encounterFragment;
                break;
            case 2:
                fragment = communityFragment;
                break;
            case 3:
                fragment = messageFragment;
                break;
            case 4:
                fragment = userFragment;
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

}
