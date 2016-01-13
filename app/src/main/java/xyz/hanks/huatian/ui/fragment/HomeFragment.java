package xyz.hanks.huatian.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.ui.activity.CreateActivityActivity;
import xyz.hanks.huatian.ui.activity.FilterActivity;
import xyz.hanks.huatian.ui.page.ActivityPage;
import xyz.hanks.huatian.ui.page.BasePage;
import xyz.hanks.huatian.ui.page.DynamicPage;
import xyz.hanks.huatian.ui.view.SegmentLayout;
import xyz.hanks.huatian.util.A;

public class HomeFragment extends BaseFragment {

    private ViewPager viewpager;
    private MyPagerAdapter adapter;
    private List<BasePage> pages = new ArrayList<BasePage>();
    private SegmentLayout segment_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        // 点击筛选按钮
        v.findViewById(R.id.tv_title_left).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goFilterActivity();
            }
        });
        // 点击发起按钮
        v.findViewById(R.id.tv_title_right).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goCreateActivity();
            }
        });

        pages.add(new DynamicPage(context));
        pages.add(new ActivityPage(context));

        viewpager = (ViewPager) v.findViewById(R.id.viewpager);
        adapter = new MyPagerAdapter();
        viewpager.setAdapter(adapter);

        segment_layout = (SegmentLayout) v.findViewById(R.id.segment_layout);
        segment_layout.setOnSegmentCheckedListener(new SegmentLayout.OnSegmentCheckedListener() {
            @Override
            public void onRightChecked() {
                viewpager.setCurrentItem(1);
            }

            @Override
            public void onLeftChecked() {
                viewpager.setCurrentItem(0);
            }
        });

        viewpager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    segment_layout.setLeftChecked();
                } else {
                    segment_layout.setRightChecked();
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /**
     * 转到发起活动界面
     *
     * @version 1.0
     * @author zyh
     */
    protected void goCreateActivity() {
        A.goOtherActivity(context, CreateActivityActivity.class);
    }

    /**
     * 转到筛选界面
     *
     * @version 1.0
     * @author zyh
     */
    private void goFilterActivity() {
        A.goOtherActivity(context, FilterActivity.class);
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = pages.get(position).getRootView();
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(pages.get(position).getRootView());
        }
    }

}
