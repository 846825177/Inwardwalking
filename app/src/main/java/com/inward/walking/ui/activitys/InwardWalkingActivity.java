package com.inward.walking.ui.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.inward.walking.R;
import com.inward.walking.adapter.FPAdapter;
import com.inward.walking.ui.BaseActivity;
import com.inward.walking.ui.fragments.GrabaSingleFragment;
import com.inward.walking.ui.fragments.HomePageFragment;
import com.inward.walking.ui.fragments.OrderFragment;
import com.inward.walking.ui.fragments.PersonalFragment;
import com.inward.walking.ui.fragments.RouteFragment;

import java.util.ArrayList;

public class InwardWalkingActivity extends BaseActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private ArrayList<Fragment> mData = new ArrayList<>();
    private FPAdapter adapter;
    private RadioButton mRadio_home;
    private RadioButton mRadio_route;
    private RadioButton mRadio_GrabaSingle;
    private RadioButton mRadio_order;
    private RadioButton mRadio_persional;
    private RadioGroup mRadioGroup;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inward_walking);
        initView();
        initData();
    }

    private void initData() {
        mData.add(new HomePageFragment());
        mData.add(new RouteFragment());
        mData.add(new GrabaSingleFragment());
        mData.add(new OrderFragment());
        mData.add(new PersonalFragment());
        adapter.notifyDataSetChanged();
        mTitle.setText("首页");

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        adapter = new FPAdapter(getSupportFragmentManager(), mData);
        mViewPager.setAdapter(adapter);
        mRadio_home = (RadioButton) findViewById(R.id.mRadio_home);
        mRadio_home.setOnClickListener(this);
        mRadio_route = (RadioButton) findViewById(R.id.mRadio_route);
        mRadio_route.setOnClickListener(this);
        mRadio_GrabaSingle = (RadioButton) findViewById(R.id.mRadio_GrabaSingle);
        mRadio_GrabaSingle.setOnClickListener(this);
        mRadio_order = (RadioButton) findViewById(R.id.mRadio_order);
        mRadio_order.setOnClickListener(this);
        mRadio_persional = (RadioButton) findViewById(R.id.mRadio_persional);
        mRadio_persional.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadio_home.setChecked(true);
                        mTitle.setText("首页");
                        break;
                    case 1:
                        mRadio_route.setChecked(true);
                        mTitle.setText("路线");

                        break;
                    case 2:
                        mRadio_GrabaSingle.setChecked(true);
                        mTitle.setText("抢单");

                        break;
                    case 3:
                        mRadio_order.setChecked(true);
                        mTitle.setText("订单");

                        break;
                    case 4:
                        mRadio_persional.setChecked(true);
                        mTitle.setText("我的");

                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTitle = (TextView) findViewById(R.id.mTitle);
        mTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mRadio_home:
                mViewPager.setCurrentItem(0);
                mTitle.setText("首页");

                break;
            case R.id.mRadio_route:
                mViewPager.setCurrentItem(1);
                mTitle.setText("路线");

                break;
            case R.id.mRadio_GrabaSingle:
                mViewPager.setCurrentItem(2);
                mTitle.setText("抢单");

                break;
            case R.id.mRadio_order:
                mViewPager.setCurrentItem(3);
                mTitle.setText("订单");

                break;
            case R.id.mRadio_persional:
                mViewPager.setCurrentItem(4);
                mTitle.setText("我的");
                break;
        }
    }
}
