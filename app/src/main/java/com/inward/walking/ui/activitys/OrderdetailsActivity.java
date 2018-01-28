package com.inward.walking.ui.activitys;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inward.walking.R;
import com.inward.walking.ui.BaseActivity;
import com.inward.walking.ui.fragments.order.Lv_Item_TouristEvaluation_Adapter;
import com.inward.walking.ui.fragments.order.SystemBarTintManager;
import com.inward.walking.ui.fragments.order.TouristEvaluationBean;

import java.util.ArrayList;

public class OrderdetailsActivity extends BaseActivity {

    private ImageView iv_back;
    private RelativeLayout rl;
    private ImageView iv_iamge_big;
    private TextView tv_content;
    private TextView tv_renminbi_chengren;
    private TextView tv_renminbi_ertong;
    private TextView tv_one_miaoshu;
    private TextView tv_two_mianshu;
    private TextView tv_three_mianshu;
    private TextView tv_four_mianshu;
    private TextView tv_five_mianshu;
    private TextView tv_tuanduichaoguoshiren;
    private TextView tv_lijianyiqianyuan;
    private ImageView iv_gengguoyouhui;
    private TextView tv_riqi_one;
    private TextView tv_renminbi_ripi_one;
    private TextView tv_riqi_two;
    private TextView tv_renminbi_ripi_two;
    private TextView tv_riqi_three;
    private TextView tv_renminbi_ripi_three;
    private TextView tv_riqi_four;
    private TextView tv_renminbi_ripi_four;
    private TextView tv_gengduoriqi;
    private RelativeLayout rl_gengduoriqi;
    private ImageView iv_ditu;
    private ImageView iv_touxiang_one;
    private ImageView iv_touxiang_two;
    private ImageView iv_touxiang_three;
    private ImageView iv_touxiang_four;
    private TextView tv_ren_num;
    private LinearLayout ll_baoming;
    private TextView tv_pingfen_num;
    private ListView lv_pingjia_youke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
        initView();
        yincang();
        ArrayList<TouristEvaluationBean> touristEvaluationBean = new ArrayList<>();
        touristEvaluationBean.add(new TouristEvaluationBean("http://img0.imgtn.bdimg.com/it/u=2723687026,1914356634&fm=27&gp=0.jpg","薛之谦","12","sdfsdfsdfsdfsd"));
        Lv_Item_TouristEvaluation_Adapter lv_item_touristEvaluation_adapter = new Lv_Item_TouristEvaluation_Adapter(touristEvaluationBean,this);
        lv_pingjia_youke.setAdapter(lv_item_touristEvaluation_adapter);
        lv_pingjia_youke.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(OrderdetailsActivity.this,OrderGrabbingServiceActivity.class));
            }
        });

    }

    /**
     * 沉浸式导航栏
     */
    private void yincang() {
        //Android4.4及以上版本才能设置此效果
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Android5.0版本
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            } else {
                //透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                //创建状态栏的管理实例
                SystemBarTintManager tintManager = new SystemBarTintManager(this);
                //激活状态栏设置
                tintManager.setStatusBarTintEnabled(true);
                //设置状态栏颜色
//                tintManager.setTintResource(R.color.color);
                //激活导航栏设置
                tintManager.setNavigationBarTintEnabled(true);
                //设置导航栏颜色
//                tintManager.setNavigationBarTintResource(R.color.color);
            }
        }
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rl = (RelativeLayout) findViewById(R.id.rl);
        iv_iamge_big = (ImageView) findViewById(R.id.iv_iamge_big);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_renminbi_chengren = (TextView) findViewById(R.id.tv_renminbi_chengren);
        tv_renminbi_ertong = (TextView) findViewById(R.id.tv_renminbi_ertong);
        tv_one_miaoshu = (TextView) findViewById(R.id.tv_one_miaoshu);
        tv_two_mianshu = (TextView) findViewById(R.id.tv_two_mianshu);
        tv_three_mianshu = (TextView) findViewById(R.id.tv_three_mianshu);
        tv_four_mianshu = (TextView) findViewById(R.id.tv_four_mianshu);
        tv_five_mianshu = (TextView) findViewById(R.id.tv_five_mianshu);
        tv_tuanduichaoguoshiren = (TextView) findViewById(R.id.tv_tuanduichaoguoshiren);
        tv_lijianyiqianyuan = (TextView) findViewById(R.id.tv_lijianyiqianyuan);
        iv_gengguoyouhui = (ImageView) findViewById(R.id.iv_gengguoyouhui);
        tv_riqi_one = (TextView) findViewById(R.id.tv_riqi_one);
        tv_renminbi_ripi_one = (TextView) findViewById(R.id.tv_renminbi_ripi_one);
        tv_riqi_two = (TextView) findViewById(R.id.tv_riqi_two);
        tv_renminbi_ripi_two = (TextView) findViewById(R.id.tv_renminbi_ripi_two);
        tv_riqi_three = (TextView) findViewById(R.id.tv_riqi_three);
        tv_renminbi_ripi_three = (TextView) findViewById(R.id.tv_renminbi_ripi_three);
        tv_riqi_four = (TextView) findViewById(R.id.tv_riqi_four);
        tv_renminbi_ripi_four = (TextView) findViewById(R.id.tv_renminbi_ripi_four);
        tv_gengduoriqi = (TextView) findViewById(R.id.tv_gengduoriqi);
        rl_gengduoriqi = (RelativeLayout) findViewById(R.id.rl_gengduoriqi);
        iv_ditu = (ImageView) findViewById(R.id.iv_ditu);
        iv_touxiang_one = (ImageView) findViewById(R.id.iv_touxiang_one);
        iv_touxiang_two = (ImageView) findViewById(R.id.iv_touxiang_two);
        iv_touxiang_three = (ImageView) findViewById(R.id.iv_touxiang_three);
        iv_touxiang_four = (ImageView) findViewById(R.id.iv_touxiang_four);
        tv_ren_num = (TextView) findViewById(R.id.tv_ren_num);
        ll_baoming = (LinearLayout) findViewById(R.id.ll_baoming);
        tv_pingfen_num = (TextView) findViewById(R.id.tv_pingfen_num);
        lv_pingjia_youke = (ListView) findViewById(R.id.lv_pingjia_youke);
    }
}
