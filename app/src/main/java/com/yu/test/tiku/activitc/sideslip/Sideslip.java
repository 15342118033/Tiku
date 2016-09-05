package com.yu.test.tiku.activitc.sideslip;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.yu.test.tiku.R;
import com.yu.test.tiku.adapter.MyAdapter;
import com.yu.test.tiku.adapter.Myguideadapter;
import com.yu.test.tiku.pojo.MenuListViewItem;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/*侧滑页和主页，*/

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
    @ViewInject(value = R.id.sp_lv_left)
    private ListView sp_lv_left;
    @ViewInject(value =R.id.sp_vp_right)
    private ListView sp_vp_right;
    @ViewInject(value = R.id.sp_tv_set)
    private TextView sp_tv_set;
    @ViewInject(value = R.id.sp_tv_exit)
    private TextView sp_tv_exit;
    @ViewInject(value = R.id.sp_tl_custom)
    private Toolbar sp_tl_custom;
    @ViewInject(value = R.id.dra_lv_mian)
    LinearLayout mLlyMain;

    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayList<MenuListViewItem> items = new ArrayList<MenuListViewItem>();

    private ArrayAdapter arrayAdapter;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private BlankFragment_type fl;
    private BlankFragment_check cz;
    private BlankFragment_mine cj;
    private BlankFragment_collection sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
//        new TpyeFragment();


        /*设置toolbar的标题*/
        sp_tl_custom.setTitle("");
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
/*关联MyAdapter，实现图片和文字的显示*/
        sp_lv_left.setAdapter(new MyAdapter(this,items));
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment_type());
        fragments.add(new BlankFragment_check());
        fragments.add(new BlankFragment_mine());
        fragments.add(new BlankFragment_collection());

        /*给菜单栏的每条标题添加监听，0分类练习，1题目查找，2我的成就，3我的收藏*/
        sp_lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*fragment之间的替换，需要用到fragment的事务处理
                * add(),remove(),replace()*/
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (position){
                    case 0:{
                        /*设置toolbar的标题*/
                        sp_tl_custom.setTitle("分类练习");
//                        sp_vp_right.setAdapter((ListAdapter) myguideadapter);
                        if(fl == null){
                            fl = new BlankFragment_type();
                            transaction.replace(R.id.sp_vp_right,fl);
                        }

                    }
                    break;
                    case 1:{
                        /*设置toolbar的标题*/
                        sp_tl_custom.setTitle("题目查找");
                        if(cz == null){
                            cz = new BlankFragment_check();
                            transaction.replace(R.id.sp_vp_right,cz);
                        }
                    }
                    break;
                    case 2:{
                        /*设置toolbar的标题*/
                        sp_tl_custom.setTitle("我的成就");
                        if(cj == null){
                            cj = new BlankFragment_mine();
                            transaction.replace(R.id.sp_vp_right,cj);
                        }
                    }
                    break;
                    case 3:{
                        /*设置toolbar的标题*/
                        sp_tl_custom.setTitle("我的收藏");
                        if(sc == null){
                            sc = new BlankFragment_collection();
                            transaction.replace(R.id.sp_vp_right,sc);
                        }
                    }
                    break;
                    default:break;

                }
                transaction.commit();
            }
        });
    }
}
