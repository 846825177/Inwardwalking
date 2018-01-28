package com.inward.walking.ui.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.inward.walking.R;
import com.inward.walking.adapter.FPAdapter;
import com.inward.walking.tools.Tools;
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
            switch (position){
                case 0:
                    mRadio_home.setChecked(true);
                    break;
                case 1:
                    mRadio_route.setChecked(true);
                    break;
                case 2:
                    mRadio_GrabaSingle.setChecked(true);
                    break;
                case 3:
                    mRadio_order.setChecked(true);
                    break;
                case 4:
                    mRadio_persional.setChecked(true);
                        break;

            }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
                switch (view.getId()){
                    case R.id.mRadio_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.mRadio_route:
                        mViewPager.setCurrentItem(1);

                        break;
                    case R.id.mRadio_GrabaSingle:
                        mViewPager.setCurrentItem(2);

                        break;
                    case R.id.mRadio_order:
                        mViewPager.setCurrentItem(3);

                        break;
                    case R.id.mRadio_persional:
                        mViewPager.setCurrentItem(4);
                        break;
                }
    }
}
