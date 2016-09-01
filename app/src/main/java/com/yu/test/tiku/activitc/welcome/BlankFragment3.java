package com.yu.test.tiku.activitc.welcome;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yu.test.tiku.R;
import com.yu.test.tiku.activitc.login.LoginActivity;


public class BlankFragment3 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank_fragment3,null);
        view.findViewById(R.id.fragment_3_start).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),LoginActivity.class);
               startActivity(intent);
               getActivity().finish();
           }
       });
        return view;
    }

}
