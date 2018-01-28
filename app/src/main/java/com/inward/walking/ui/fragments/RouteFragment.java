package com.inward.walking.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.inward.walking.R;
import com.inward.walking.adapter.RouteAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * Created by 84682 on 2018/1/27.
 */

public class RouteFragment extends Fragment {
    private ListView mHomeListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mHomeListView = (ListView) view.findViewById(R.id.mHomeListView);
        RouteAdapter routeAdapter = new RouteAdapter(getActivity());
        mHomeListView.setAdapter(routeAdapter);
    }
}
