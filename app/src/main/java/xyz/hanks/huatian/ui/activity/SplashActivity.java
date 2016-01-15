package xyz.hanks.huatian.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import xyz.hanks.huatian.R;


/**
 * 应用的启动界面
 *
 * @author zyh
 * @version 1.0
 * @date 2015年2月4日 上午10:44:59
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // 检查网络
        checkNetwork();
        // 检查目录
        checkProjectDir();
        // 检查更新
        checkUpdate();
        // 检查新的启动图片
        checkNewPicture();
        // 去主界面
        goHome();

    }

    /**
     * 检查网络
     */
    private void checkNetwork() {
    }

    /**
     * 检查app的目录文件夹
     */
    private void checkProjectDir() {
    }

    /**
     * 检查更新
     */
    private void checkUpdate() {

    }

    /**
     * 检查新的启动图片
     *
     * @version 1.0
     * @author zyh
     * @date 2015年2月4日 上午10:44:33
     */
    private void checkNewPicture() {
    }


    /**
     * 去主界面
     */
    private void goHome() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();

            }
        }, 1000);
    }
}
