package com.yu.test.tiku.activitc.sideslip;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yu.test.tiku.R;

/**
 * 我的成就
 */
public class BlankFragment_mine extends Fragment {


    public BlankFragment_mine() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment_mine, container, false);
    }

}
