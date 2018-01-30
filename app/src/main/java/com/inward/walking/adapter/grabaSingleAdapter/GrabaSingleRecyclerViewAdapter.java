package com.inward.walking.adapter.grabaSingleAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inward.walking.R;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/1/28.
 */

public class GrabaSingleRecyclerViewAdapter extends RecyclerView.Adapter<GrabaSingleRecyclerViewAdapter.ViewHoler> {
    private Context context;
    public GrabaSingleRecyclerViewAdapter(Context context) {
        this.context=context;
    }

    public interface OnItemClickListener {
        void onItemClick();
    }

    private OnItemClickListener mOnItemClickListener;

    public OnItemClickListener getmOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grab_recyclerview_item, parent, false);
        ViewHoler viewHoler= new ViewHoler(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        private AutoRelativeLayout mGrabaView;
        private  AutoRelativeLayout mGrabRelative;

        public ViewHoler(View itemView) {
            super(itemView);
            mGrabaView = itemView.findViewById(R.id.mGrabaView);
            mGrabRelative = itemView.findViewById(R.id.mGrabRelative);
            mGrabRelative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick();
                    }
                }
            });
        }
    }
}
