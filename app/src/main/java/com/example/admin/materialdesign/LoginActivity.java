package com.example.admin.materialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("上海容易网");
        toolbar.setSubtitle("这里是子标题");
        toolbar.setLogo(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
        setSupportActionBar(toolbar);
    }

}

