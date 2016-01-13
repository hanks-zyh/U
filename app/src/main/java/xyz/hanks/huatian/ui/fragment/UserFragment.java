package xyz.hanks.huatian.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import xyz.hanks.huatian.R;
import xyz.hanks.huatian.bean.User;
import xyz.hanks.huatian.net.NetManager;
import xyz.hanks.huatian.ui.view.CircularImageView;
import xyz.hanks.huatian.ui.view.SelectPictureActivity;
import xyz.hanks.huatian.util.A;


public class UserFragment extends BaseFragment implements OnClickListener {
    private TextView tv_description;
    private CircularImageView iv_avatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        iv_avatar = (CircularImageView) v.findViewById(R.id.iv_avatar);
        tv_description = (TextView) v.findViewById(R.id.tv_description);
        v.findViewById(R.id.btn_select_picture).setOnClickListener(this);

        User currentUser = NetManager.getUserInfoById(1234);
        loader.displayImage(currentUser.getAvatar(), iv_avatar, option_photo);
        tv_description.setText(currentUser.getDescription());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select_picture:
                A.goOtherActivity(context, SelectPictureActivity.class);
                break;
        }
    }
}
