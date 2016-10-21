package com.example.admin.materialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Author:    Diamond_Lin
 * Version    V1.0
 * Date:      16/9/24 下午7:57
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 16/9/24      Diamond_Lin            1.0                    1.0
 * Why & What is modified:
 */
public class LaunchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        //为什么在 style 里面用 textColorPrimary 设置 toolBar 文字颜色，然后使用NavigationView报错
        setToolBar();
        setNavigationView();
        findViewById(R.id.bt_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchActivity.this,LoginActivity.class));
            }
        });
    }

    private void setNavigationView() {
        ((NavigationView) findViewById(R.id.navigation_view)).setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("测试Title");
        toolbar.setSubtitle("测试Subtitle");//无效
        toolbar.setTitleTextColor(Color.WHITE);//无效
        toolbar.setSubtitle("Create By DiamondLin");//无效
//        toolbar.setLogo(R.mipmap.abc_ic_ab_back_mtrl_am_alpha); 有效
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Toast.makeText(LaunchActivity.this,"主页不能返回哦",Toast.LENGTH_SHORT).show();
            }
        });


        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        final CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_layout);
        final View igm = findViewById(R.id.iv);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -igm.getHeight() / 5) {
                    collapsing.setTitle("移动后Title");
                    collapsing.setCollapsedTitleTextColor(Color.WHITE);
                } else {
                    collapsing.setTitle(" ");
                }
            }
        });

        //以下代码无效  干掉 setSupportActionBar(toolbar);就有效了
        toolbar.inflateMenu(R.menu.menu_login);
        //action menu操作菜单按钮的点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String msg = "";
                switch (item.getItemId()) {
                    case R.id.webview:
                        msg = "博客跳转~";
                        break;
                    case R.id.weibo:
                        msg = "微博跳转~";
                        break;
                    case R.id.action_settings:
                        msg = "设置~";
                        break;
                }
                if (!msg.equals("")) {
                    Toast.makeText(LaunchActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.toolbar:
                startActivity(new Intent(this, ToolbarActivity.class));
                break;
            case R.id.palette:
                startActivity(new Intent(this, PaletteActivity.class));
                break;

        }
        mDrawerLayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.webview:
                msg = "博客跳转";
                break;
            case R.id.weibo:
                msg = "微博跳转";
                break;
            case R.id.action_settings:
                msg = "设置";
                break;
        }
        if (!msg.equals("")) {
            Toast.makeText(LaunchActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
