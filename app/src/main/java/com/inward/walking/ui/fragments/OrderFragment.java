package com.inward.walking.ui.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inward.walking.R;
import com.inward.walking.ui.activitys.OrderdetailsActivity;
import com.inward.walking.ui.fragments.order.SystemBarTintManager;

/**
 * Created by 84682 on 2018/1/27.
 */

public class OrderFragment extends Fragment {
    private ImageView imageView;
    private TextView xiaoxitv_num;
    private RelativeLayout my_qiangdan;
    private RelativeLayout my_yuyue;
    private RelativeLayout my_luxian;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_order, container, false);
        yincang();
        initView(inflate);
        my_qiangdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), OrderdetailsActivity.class));
            }
        });
        return inflate;
    }

    /**
     * 沉浸式导航栏
     */
    private void yincang() {
        //Android4.4及以上版本才能设置此效果
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Android5.0版本
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //透明状态栏
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            } else {
                //透明状态栏
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                //创建状态栏的管理实例
                SystemBarTintManager tintManager = new SystemBarTintManager(getActivity());
                //激活状态栏设置
                tintManager.setStatusBarTintEnabled(true);
//                //设置状态栏颜色
//                tintManager.setTintResource(R.color.color);
                //激活导航栏设置
                tintManager.setNavigationBarTintEnabled(true);
                //设置导航栏颜色
//                tintManager.setNavigationBarTintResource(R.color.color);
            }
        }
    }

    private void initView(View inflate) {
        imageView = (ImageView) inflate.findViewById(R.id.imageView);
        xiaoxitv_num = (TextView) inflate.findViewById(R.id.xiaoxitv_num);
        my_qiangdan = (RelativeLayout) inflate.findViewById(R.id.my_qiangdan);
        my_yuyue = (RelativeLayout) inflate.findViewById(R.id.my_yuyue);
        my_luxian = (RelativeLayout) inflate.findViewById(R.id.my_luxian);
    }
}
