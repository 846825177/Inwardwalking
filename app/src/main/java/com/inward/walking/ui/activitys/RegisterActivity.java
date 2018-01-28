package com.inward.walking.ui.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inward.walking.R;
import com.inward.walking.tools.Tools;
import com.inward.walking.ui.BaseActivity;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Tools.setAlpha(getWindow(), this);

    }
}
