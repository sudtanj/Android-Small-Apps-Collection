package com.example.user.lab61_12273_sudonot;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 30/09/2017.
 */

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        return inflater.inflate(R.layout.fragment1,container, false);
    }

    public void setText(String text){
        TextView text1=(TextView) getActivity().findViewById(R.id.textView1);
        text1.setText(text);
    }

    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //String mParam1 = getArguments().getString("params");
        //TextView text=(TextView) getActivity().findViewById(R.id.textView1);
        //text.setText(mParam1);
    }

}