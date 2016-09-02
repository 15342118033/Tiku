package com.yu.test.tiku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yu.test.tiku.R;
import com.yu.test.tiku.pojo.MenuListViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/2.
 */
public class MyAdapter extends BaseAdapter{
    List<MenuListViewItem> list;
    LayoutInflater inflater;
    Context context;
    ViewHolder viewHolder=null;
    public MyAdapter(Context context, List<MenuListViewItem> list){
        this.list = list;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = inflater.inflate(R.layout.menuitem, null);
            viewHolder= new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.nenuitm_iv);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.nemuitm_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        MenuListViewItem item=list.get(position);
        viewHolder.imageView.setImageResource(item.getPic());
        viewHolder.textView.setText(item.getTitle());

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;

    }
}
