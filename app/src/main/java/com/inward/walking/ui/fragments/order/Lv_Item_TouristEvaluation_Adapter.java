package com.inward.walking.ui.fragments.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inward.walking.R;
import com.inward.walking.ui.activitys.OrderdetailsActivity;

import java.util.ArrayList;

/**
 * 认真的人到最后都是难过 2018/1/28.
 */

public class Lv_Item_TouristEvaluation_Adapter extends BaseAdapter {
    private ArrayList<TouristEvaluationBean> touristEvaluationBean;
    private Context context;

    public Lv_Item_TouristEvaluation_Adapter(ArrayList<TouristEvaluationBean> touristEvaluationBean, OrderdetailsActivity main2Activity) {
        this.touristEvaluationBean = touristEvaluationBean;
        this.context = main2Activity;
    }

    @Override
    public int getCount() {
        return touristEvaluationBean.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    ViewHolder viewHolder;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_item_pingjia_youke, null);

            viewHolder.iv_youke_touxiang = (ImageView) convertView.findViewById(R.id.iv_youke_touxiang);
            viewHolder.tv_youke_name_one = (TextView) convertView.findViewById(R.id.tv_youke_name_one);
            viewHolder.tv_youke_name_end = (TextView) convertView.findViewById(R.id.tv_youke_name_end);
            viewHolder.tv_time_chuxing = (TextView) convertView.findViewById(R.id.tv_time_chuxing);
            viewHolder.tv_youke_pingjia_content = (TextView) convertView.findViewById(R.id.tv_youke_pingjia_content);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(touristEvaluationBean.get(position).getIamge_url()).bitmapTransform(new CircleBitmapTransformation(context)).into(viewHolder.iv_youke_touxiang);
        viewHolder.tv_time_chuxing.setText(touristEvaluationBean.get(position).getTime());
        viewHolder.tv_youke_name_one.setText(touristEvaluationBean.get(position).getName().substring(0,1));
        String name = touristEvaluationBean.get(position).getName();
        int length = name.length();
        viewHolder.tv_youke_name_end.setText(name.substring(length-1));
        viewHolder.tv_youke_pingjia_content.setText(touristEvaluationBean.get(position).getContent());
        return convertView;
    }

    class ViewHolder {

        public ImageView iv_youke_touxiang;
        public TextView tv_youke_name_one;
        public TextView tv_youke_name_end;
        public TextView tv_time_chuxing;
        public TextView tv_youke_pingjia_content;
    }
}
