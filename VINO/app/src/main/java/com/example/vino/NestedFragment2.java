package com.example.vino;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by peter on 2015/5/10.
 */


public class NestedFragment2 extends Fragment{

    private TextView list1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_nested2, container, false);

        list1 = (TextView) rootView.findViewById(R.id.textView4);

        if(MainActivity.test!=null){
        /*    ts=step.split(",");
            for(String d : ts) {
                after = after + d;
            }
            preset=after;
        */
            list1.setText(MainActivity.test);

        }

        return rootView;
    }
}
