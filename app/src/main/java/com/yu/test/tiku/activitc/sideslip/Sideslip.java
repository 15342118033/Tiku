package com.yu.test.tiku.activitc.sideslip;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yu.test.tiku.R;
import com.yu.test.tiku.adapter.MyAdapter;
import com.yu.test.tiku.pojo.MenuListViewItem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

@ContentView(value = R.layout.activity_sideslip)
public class Sideslip extends AppCompatActivity {
    @ViewInject(value = R.id.dl_left)
    private DrawerLayout dl_left;
    @ViewInject(value = R.id.sp_lv_rl)
    private LinearLayout sp_lv_rl;
    @ViewInject(value = R.id.sp_animll_id)
    private LinearLayout sp_animll_id;
    @ViewInject(value = R.id.sp_usname)
    private TextView sp_usname;
    @ViewInject(value = R.id.sp_uspic)
    private ImageView sp_uspic;
    @ViewInject(value = R.id.sp_lv_001)
    private ListView sp_lv_001;
    @ViewInject(value = R.id.sp_tv_set)
    private TextView sp_tv_set;
    @ViewInject(value = R.id.sp_tv_exit)
    private TextView sp_tv_exit;
    @ViewInject(value = R.id.sp_tl_custom)
    private Toolbar sp_tl_custom;

    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayList<MenuListViewItem> items = new ArrayList<MenuListViewItem>();
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        /*设置toolbar的标题*/
        sp_tl_custom.setTitle("Toolbar");
        /*设置标题颜色*/
        sp_tl_custom.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(sp_tl_custom);
        /*设置返回键可用*/
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*创建返回键，并实现打开/关闭监听*/
        mDrawerToggle = new ActionBarDrawerToggle(this, dl_left,sp_tl_custom, R.string.open, R.string.closed) {


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        mDrawerToggle.syncState();
        dl_left.setDrawerListener(mDrawerToggle);
        /*设置菜单列表*/
        items.add(new MenuListViewItem(R.mipmap.home_nav_icon01,"分类练习"));
        items.add(new MenuListViewItem(R.mipmap.home_nav_icon02,"题目查找"));
        items.add(new MenuListViewItem(R.mipmap.home_nav_icon03,"我的成就"));
        items.add(new MenuListViewItem(R.mipmap.home_nav_icon04,"我的收藏"));
//        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,items);

        sp_lv_001.setAdapter(new MyAdapter(this,items));
    }
}
