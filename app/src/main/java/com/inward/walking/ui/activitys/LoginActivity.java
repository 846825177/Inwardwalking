package com.inward.walking.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.inward.walking.R;
import com.inward.walking.tools.Tools;
import com.inward.walking.ui.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mLogin;
    private Button mRegister;
    private TextView find_pdw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Tools.setAlpha(getWindow(), this);
    }

    private void initView() {
        mLogin = (Button) findViewById(R.id.mLogin);
        mRegister = (Button) findViewById(R.id.mRegister);
        find_pdw = (TextView) findViewById(R.id.find_pdw);
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        find_pdw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mLogin:
                startActivity(new Intent(this,InwardWalkingActivity.class));

                break;
            case R.id.mRegister:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.find_pdw:
                startActivity(new Intent(this,FindPwdActivity.class));
                break;
        }
    }
}
