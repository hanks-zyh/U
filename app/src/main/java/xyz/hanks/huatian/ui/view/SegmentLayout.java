package xyz.hanks.huatian.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import xyz.hanks.huatian.R;


/**
 * 仿IOS的Segment布局
 *
 * @author zyh
 * @version 1.0
 */
public class SegmentLayout extends LinearLayout {

    private TextView tv_left;
    private TextView tv_right;
    private OnSegmentCheckedListener listener;

    public SegmentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public SegmentLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SegmentLayout(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_segment, this, true);
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_right = (TextView) findViewById(R.id.tv_right);

        tv_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setLeftChecked();
                listener.onLeftChecked();
            }
        });
        tv_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setRightChecked();
                listener.onRightChecked();
            }
        });
        setLeftChecked();
        // listener.onLeftChecked();
    }

    public void setLeftChecked() {
        tv_left.setTextColor(Color.WHITE);
        tv_left.setBackgroundResource(R.drawable.collection_tab_left_press);
        setRightUnCheck();
    }

    public void setLeftUnCheck() {
        tv_left.setTextColor(Color.parseColor("#E09A9C"));
        tv_left.setBackgroundDrawable(null);
    }

    public void setRightChecked() {
        tv_right.setTextColor(Color.WHITE);
        tv_right.setBackgroundResource(R.drawable.collection_tab_right_press);
        setLeftUnCheck();
    }

    public void setRightUnCheck() {
        tv_right.setTextColor(Color.parseColor("#E09A9C"));
        tv_right.setBackgroundDrawable(null);
    }

    public void setOnSegmentCheckedListener(OnSegmentCheckedListener listener) {
        this.listener = listener;
    }

    public interface OnSegmentCheckedListener {
        public void onLeftChecked();

        public void onRightChecked();
    }

}
