package xyz.hanks.huatian.ui.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import xyz.hanks.huatian.R;

public class BaseFragment extends Fragment {

    protected Context context;
    protected ImageLoader loader;
    protected DisplayImageOptions option_pic;
    protected DisplayImageOptions option_photo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        loader = ImageLoader.getInstance();
        option_pic = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.pic_loading)
                .showImageForEmptyUri(R.drawable.pic_loading).showImageOnFail(R.drawable.pic_loading)
                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(1000)).build();
        option_photo = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.home_dynamic_male)
                .showImageForEmptyUri(R.drawable.home_dynamic_male)
                .showImageOnFail(R.drawable.home_dynamic_male).cacheInMemory(true).cacheOnDisk(true)
                .considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
    }
}
