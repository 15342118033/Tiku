package com.yu.test.tiku.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置引导页的样式
 */
public class Myguideadapter extends FragmentStatePagerAdapter{

    /*LayoutInflater inflater = null;*/
    List<Fragment> list = new ArrayList<Fragment>();

    public Myguideadapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        /*if (position == 0){
            return new BlankFragment1();
        }else if (position == 1){
            return new BlankFragment2();
        }else if (position == 2){
            return new BlankFragment3();
        }else {
            return null;
        }*/
        return list.get(position);

    }

    @Override
    public int getCount() {
        return list.size();
    }
}
