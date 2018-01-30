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
import com.inward.walking.adapter.grabaSingleAdapter.GrabaSingleRobbedRecyclerViewAdapter;

/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/1/28.
 * 已抢订单
 */

public class RobbedFragment extends Fragment {

    private RecyclerView mRobbedRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grab_robbed, container, false);
        mRobbedRecyclerView = view.findViewById(R.id.mRobbedRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRobbedRecyclerView.setLayoutManager(linearLayoutManager);
        GrabaSingleRobbedRecyclerViewAdapter grabaSingleRobbedRecyclerViewAdapter = new GrabaSingleRobbedRecyclerViewAdapter(getContext());
        mRobbedRecyclerView.setAdapter(grabaSingleRobbedRecyclerViewAdapter);
        grabaSingleRobbedRecyclerViewAdapter.setmOnItemClickListener(new GrabaSingleRobbedRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
                Toast.makeText(getContext(), "已抢".toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
