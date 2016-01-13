package xyz.hanks.huatian.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import xyz.hanks.huatian.R;


/**
 * 主界面底部的按钮切换布局
 *
 * @author zyh
 * @version 1.0
 */
public class BottomLayout extends LinearLayout implements OnClickListener {

    private Context context;
    private View rl_home, rl_encounter, rl_community, rl_message, rl_user;
    private Button btn_home, btn_encounter, btn_community, btn_message, btn_user;
    private OnItemClickListener listener;
    private int currentPosition = 0;
    private TextView tv_unread_message;// 消息界面未读消息的个数
    private TextView tv_unread_home;// 首页界面未读消息的个数
    public BottomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    public BottomLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public BottomLayout(Context context) {
        this(context, null, 0);
    }

    /**
     * 初始化
     *
     * @param context
     * @version 1.0
     * @author zyh
     */
    private void init(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_bottom, this);
        rl_home = findViewById(R.id.rl_home);
        rl_encounter = findViewById(R.id.rl_encounter);
        rl_community = findViewById(R.id.rl_community);
        rl_message = findViewById(R.id.rl_message);
        rl_user = findViewById(R.id.rl_user);

        btn_home = (Button) findViewById(R.id.btn_home);
        btn_encounter = (Button) findViewById(R.id.btn_encounter);
        btn_community = (Button) findViewById(R.id.btn_community);
        btn_message = (Button) findViewById(R.id.btn_message);
        btn_user = (Button) findViewById(R.id.btn_user);

        tv_unread_message = (TextView) findViewById(R.id.tv_unread_message);
        tv_unread_home = (TextView) findViewById(R.id.tv_unread_home);
        changeButtonStatus(0);// 默认是位置0
        setListener();
    }

    /**
     * 显示未读消息
     *
     * @param unRead
     * @version 1.0
     * @author zyh
     */
    public void showMessageNumber(String unRead) {
        tv_unread_message.setText(unRead);
        tv_unread_message.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏未读消息
     *
     * @param unRead
     * @version 1.0
     * @author zyh
     */
    public void hideMessageNumber(String unRead) {
        tv_unread_message.setVisibility(View.GONE);
    }

    /**
     * 显示未读消息
     *
     * @param unRead
     * @version 1.0
     * @author zyh
     */
    public void showHomeNumber(String unRead) {
        tv_unread_home.setText(unRead);
        tv_unread_home.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏未读消息
     *
     * @param unRead
     * @version 1.0
     * @author zyh
     */
    public void hideHomeNumber(String unRead) {
        tv_unread_home.setVisibility(View.GONE);
    }

    /**
     * 为按钮设计按下监听
     *
     * @version 1.0
     * @author zyh
     */
    private void setListener() {
        rl_home.setOnClickListener(this);
        rl_encounter.setOnClickListener(this);
        rl_community.setOnClickListener(this);
        rl_message.setOnClickListener(this);
        rl_user.setOnClickListener(this);
    }

    /**
     * 提供给外部设置点击Item的接口
     *
     * @param listener
     * @version 1.0
     * @author zyh
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener == null) {
            return;
        }
        currentPosition = 0;
        switch (v.getId()) {
            case R.id.rl_home:
                listener.onItemClick(btn_home, 0);
                currentPosition = 0;
                break;
            case R.id.rl_encounter:
                listener.onItemClick(btn_encounter, 1);
                currentPosition = 1;
                break;
            case R.id.rl_community:
                listener.onItemClick(btn_community, 2);
                currentPosition = 2;
                break;
            case R.id.rl_message:
                listener.onItemClick(btn_message, 3);
                currentPosition = 3;
                break;
            case R.id.rl_user:
                listener.onItemClick(btn_user, 4);
                currentPosition = 4;
                break;
        }
        changeButtonStatus(currentPosition);
    }

    /**
     * 根据当前位置改变按钮选中状态
     *
     * @param position
     * @version 1.0
     * @author zyh
     */
    private void changeButtonStatus(int position) {
        btn_home.setSelected(position == 0);
        btn_encounter.setSelected(position == 1);
        btn_community.setSelected(position == 2);
        btn_message.setSelected(position == 3);
        btn_user.setSelected(position == 4);
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
}
