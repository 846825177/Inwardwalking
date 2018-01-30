package com.inward.walking.ui.fragments.grabSingleFrameLayouts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inward.walking.R;
import com.inward.walking.adapter.grabaSingleAdapter.GrabaSingleRecyclerViewAdapter;

/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/1/28.
 * 游客订单
 */

public class TravelFragment extends Fragment {

    private RecyclerView mTravelRecyclertView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grab_travel, container, false);
        mTravelRecyclertView = view.findViewById(R.id.mTravelRecyclertView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        GrabaSingleRecyclerViewAdapter grabaSingleListViewAdapter = new GrabaSingleRecyclerViewAdapter(getContext());
        mTravelRecyclertView.setLayoutManager(linearLayoutManager);
        mTravelRecyclertView.setAdapter(grabaSingleListViewAdapter);
        grabaSingleListViewAdapter.setmOnItemClickListener(new GrabaSingleRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
                Toast.makeText(getContext(), "劫".toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}