package com.yu.test.tiku.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yu.test.tiku.R;
import com.yu.test.tiku.pojo.Types;

import java.util.List;

/**
 * 关联主页面（侧滑页右面那个页面）和布局
 */

    public class TypeAdapter extends BaseAdapter {

        private final LayoutInflater inflater;
        List<Types> list;
        ViewHolder viewHolder;

        public TypeAdapter(Context context, List<Types> mList) {
            this.list=mList;
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
            if (convertView == null){
                convertView = inflater.inflate(R.layout.item_type, null);
                viewHolder= new ViewHolder();
                viewHolder.typImageView= (ImageView) convertView.findViewById(R.id.item_type_img);
                viewHolder.typtTxtView = (TextView) convertView.findViewById(R.id.item_type_tv);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            Types types = list.get(position);
            viewHolder.typImageView.setImageBitmap(BitmapFactory.decodeFile(types.getIcon()));
            viewHolder.typtTxtView.setText(types.getName());
                return convertView;
        }
    class ViewHolder{
        ImageView typImageView;
        TextView typtTxtView;

    }

    }

