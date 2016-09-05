package com.yu.test.tiku.activitc.welcome;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yu.test.tiku.R;
import com.yu.test.tiku.activitc.login.LoginActivity;
import com.yu.test.tiku.adapter.Myguideadapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
@ContentView(value = R.layout.activity_guide)
public class GuideActivity extends AppCompatActivity {
    @ViewInject(value = R.id.guide_viewpager)
    private ViewPager viewPager;

    @ViewInject(value = R.id.lv_iv_01)
    private ImageView lv_iv_01;
    @ViewInject(value = R.id.lv_iv_02)
    private ImageView lv_iv_02;
    @ViewInject(value = R.id.lv_iv_03)
    private ImageView lv_iv_03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        /*把三个页面放入集合，拖动切换显示*/
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new BlankFragment1());
        list.add(new BlankFragment2());
        list.add(new BlankFragment3());
        Myguideadapter myguideadapter = new Myguideadapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(myguideadapter);
        /*给viewPager设置监听，实现图片中的小点变化*/
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /*设置引导页下面那三个小圆点和图片滑动时的动画效果*/
            @Override
            public void onPageSelected(int position) {
                lv_iv_01.setImageResource(R.mipmap.page_indicator_focused);
                lv_iv_02.setImageResource(R.mipmap.page_indicator_focused);
                lv_iv_03.setImageResource(R.mipmap.page_indicator_focused);
                switch (position){
                    case 0:{
                        lv_iv_01.setImageResource(R.mipmap.page_indicator_unfocused);
                    }
                    break; case 1:{
                        lv_iv_02.setImageResource(R.mipmap.page_indicator_unfocused);
                    }
                    break; case 2:{
                        lv_iv_03.setImageResource(R.mipmap.page_indicator_unfocused);
                    }
                    break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
   /*  @Event(value = {R.id.fragment_3_start},type = View.OnClickListener.class)
   private void setTv_wordClick(View view){
        switch (view.getId()){
            case R.id.fragment_3_start:{
                Intent intent = new Intent(GuideActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
            break;
        }


    }
*/



}
