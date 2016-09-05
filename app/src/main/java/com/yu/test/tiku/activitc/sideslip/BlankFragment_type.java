package com.yu.test.tiku.activitc.sideslip;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.yu.test.tiku.R;
import com.yu.test.tiku.adapter.TypeAdapter;
import com.yu.test.tiku.pojo.Types;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类练习页面
 */

public class BlankFragment_type extends Fragment {

    private GridView mTypeGridView;
    private TypeAdapter mAdapter;
    private List<Types> mList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank_fragment_type,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTypeGridView = (GridView) view.findViewById(R.id.fragmenttype_01);
        mAdapter=new TypeAdapter(getActivity(),mList);
        mTypeGridView.setAdapter(mAdapter);
    }



}
