package xyz.hanks.huatian.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * 关于SD卡的操作类
 *
 * @author Administrator
 */
public class SD {

    /**
     * 判断SD卡是否可用
     *
     * @return
     */
    public static boolean sdCardIsAvail() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 返回app的目录路径
     *
     * @return
     */
    public static String getProjectDir(Context context) {
        String dir = null;
        if (sdCardIsAvail()) {
            dir = Environment.getExternalStorageDirectory().getPath() + File.separatorChar + "night";
        } else {
            dir = context.getFilesDir().getAbsolutePath() + File.separatorChar + "night";
        }
        File f = new File(dir);
        if (!f.exists()) {
            f.mkdirs();
        }
        return dir;
    }

    /**
     * 返回app的图片目录路径
     *
     * @return
     */
    public static String getProjectImageDir(Context context) {
        return getProjectDir(context) + File.separatorChar + "images";
    }

}
