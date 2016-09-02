package com.yu.test.tiku.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/2.
 */
public class MenuListViewItem implements Serializable{
    public int pic;
    public String title;

    public MenuListViewItem() {
    }

    public MenuListViewItem(int pic, String title) {
        this.pic = pic;
        this.title = title;
    }

    @Override
    public String toString() {
        return "MenuListViewItem{" +
                "pic=" + pic +
                ", title='" + title + '\'' +
                '}';
    }
}
