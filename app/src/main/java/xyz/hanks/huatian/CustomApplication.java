package xyz.hanks.huatian;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

public class CustomApplication extends Application {

    private static CustomApplication instance;

    public static CustomApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initImageLoader(getApplicationContext());
    }

    private void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "dahai/Cache");// 获取到缓存的目录地址
        // 创建配置ImageLoader(所有的选项都是可选的,只使用那些你真的想定制)，这个可以设定在APPLACATION里面，设置为全局的配置参数
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(720, 1280)
                        // max width, max height，即保存的每个缓存文件的最大长宽
                        // 线程池内加载的数量
                .threadPoolSize(3).threadPriority(Thread.NORM_PRIORITY - 2)
                .memoryCache(new WeakMemoryCache()).denyCacheImageMultipleSizesInMemory()
                        // 将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO).diskCache(new UnlimitedDiskCache(cacheDir))// 自定义缓存路径
                        // .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);// 全局初始化此配置
    }
}
