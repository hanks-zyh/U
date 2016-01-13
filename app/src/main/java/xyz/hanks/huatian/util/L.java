package xyz.hanks.huatian.util;

import android.util.Log;

/**
 * 日志工具类 <li>修正fromHere方法打印位置
 */
public class L {
    private static final String TAG = "WifiLog";
    public static boolean isDebug = true; // 是否需要打印bug，可以在application的onCreate函数里面初始化

    public static String fromHere() {
        String ret = "";
        if (isDebug) {
            StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
            StringBuffer toStringBuffer = new StringBuffer("[").append(traceElement.getFileName())
                    .append(" | ").append(traceElement.getMethodName()).append(" | ")
                    .append(traceElement.getLineNumber()).append("]");
            ret = toStringBuffer.toString();
        }
        return ret;
    }

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, "*********" + msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, "*********" + msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, "*********" + msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, "*********" + msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "*********" + msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "*********" + msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "*********" + msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, "*********" + msg);
    }
}