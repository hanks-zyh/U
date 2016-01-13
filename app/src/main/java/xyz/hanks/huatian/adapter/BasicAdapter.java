package xyz.hanks.huatian.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;

import xyz.hanks.huatian.R;

public abstract class BasicAdapter<E> extends BaseAdapter {

    protected Context context;
    protected List<E> list;

    protected ImageLoader loader;
    protected DisplayImageOptions option_pic, option_photo;

    public BasicAdapter(Context context, List<E> list) {
        this.context = context;
        this.list = list;
        loader = ImageLoader.getInstance();
        option_pic = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.pic_loading)
                .showImageForEmptyUri(R.drawable.pic_loading).showImageOnFail(R.drawable.pic_loading)
                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(600)).build();
        option_photo = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.home_dynamic_male)
                .showImageForEmptyUri(R.drawable.home_dynamic_male)
                .showImageOnFail(R.drawable.home_dynamic_male).cacheInMemory(true).cacheOnDisk(true)
                .considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    ;

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

}
