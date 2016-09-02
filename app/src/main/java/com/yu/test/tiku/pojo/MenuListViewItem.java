package com.yu.test.tiku.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/2.
 */
public class MenuListViewItem {
    public int pic;
    public String title;

    public MenuListViewItem() {
    }

    public MenuListViewItem(int pic, String title) {
        this.pic = pic;
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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
