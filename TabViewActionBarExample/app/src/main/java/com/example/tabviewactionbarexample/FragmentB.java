package com.example.tabviewactionbarexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by peter on 2015/5/3.
 */
public class FragmentB extends android.support.v4.app.Fragment {
    public FragmentB(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragmentb_layout, container, false);

    }
}
