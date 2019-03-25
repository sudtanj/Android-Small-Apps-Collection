package com.example.user.lab61_12273_sudonot;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by User on 30/09/2017.
 */

public class Fragment2 extends Fragment {

    EditText text;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view=inflater.inflate(R.layout.fragment2,container, false);
        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        text=(EditText) getActivity().findViewById(R.id.editText);
        Button submit = (Button) getActivity().findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
                android.app.FragmentManager manager = getFragmentManager();
                Fragment1 fragmentA = (Fragment1) manager.findFragmentById(R.id.fragment1);
                Fragment2 fragmentB= (Fragment2) manager.findFragmentById(R.id.fragment2);
                //Bundle bundle=fragmentA.getArguments();
                //bundle.putString("params", "test");
                fragmentA.setText(text.getText().toString());
                manager.beginTransaction().show(fragmentA).commit();
                manager.beginTransaction().hide(fragmentB).commit();
            }
        });
    }

}