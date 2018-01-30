package com.inward.walking.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.inward.walking.R;
import com.inward.walking.ui.fragments.grabSingleFrameLayouts.RobbedFragment;
import com.inward.walking.ui.fragments.grabSingleFrameLayouts.TouristFragment;
import com.inward.walking.ui.fragments.grabSingleFrameLayouts.TravelFragment;

/**
 * Created by 84682 on 2018/1/27.
 * 抢单
 */

public class GrabaSingleFragment extends Fragment implements View.OnClickListener {

    private FrameLayout mFrameLayout;
    private TravelFragment travelFragment;
    private RobbedFragment robbedFragment;
    private TouristFragment touristFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton mBtnTourist;
    private RadioButton mBtnTravel;
    private RadioButton mBtnRobbed;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grab_a_single, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
         fragmentManager = getActivity().getSupportFragmentManager();
        //开启Fragment事物
        fragmentTransaction = fragmentManager.beginTransaction();
        touristFragment = new TouristFragment();
        fragmentTransaction.add(R.id.mFrameLayout, touristFragment);
        fragmentTransaction.commit();

    }


    private void initView(View view) {
        mFrameLayout = view.findViewById(R.id.mFrameLayout);
        mBtnTourist =  view.findViewById(R.id.mBtnTourist);
        mBtnTourist.setOnClickListener(this);
        mBtnTravel =  view.findViewById(R.id.mBtnTravel);
        mBtnTravel.setOnClickListener(this);
        mBtnRobbed =  view.findViewById(R.id.mBtnRobbed);
        mBtnRobbed.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAll(fragmentTransaction);
        switch (v.getId()) {
            //旅行社
            case R.id.mBtnTourist:
                if (touristFragment == null) {
                    touristFragment = new TouristFragment();
                    fragmentTransaction.add(R.id.mFrameLayout, touristFragment);
                } else {
                    Toast.makeText(getActivity(), "www", Toast.LENGTH_SHORT).show();
                    fragmentTransaction.show(touristFragment);
                }
                break;
            //游客
            case R.id.mBtnTravel:
                if (travelFragment == null) {
                    travelFragment = new TravelFragment();
                    fragmentTransaction.add(R.id.mFrameLayout, travelFragment);
                } else {
                    fragmentTransaction.show(travelFragment);
                }
                break;
            //已抢
            case R.id.mBtnRobbed:
                if (robbedFragment == null) {
                    robbedFragment = new RobbedFragment();
                    fragmentTransaction.add(R.id.mFrameLayout, robbedFragment);
                } else {
                    fragmentTransaction.show( robbedFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
    private void hideAll(FragmentTransaction transaction) {
        if (travelFragment != null) transaction.hide(travelFragment);

        if (touristFragment != null) transaction.hide(touristFragment);
        if (robbedFragment != null) transaction.hide(robbedFragment);

    }
}
