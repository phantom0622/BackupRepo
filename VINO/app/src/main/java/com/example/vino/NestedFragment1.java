package com.example.vino;

import android.app.Activity;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by peter on 2015/5/10.
 */
public class NestedFragment1 extends Fragment {

    private ListView list ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("aa", "onCreateView");
        View rootView = inflater.inflate(R.layout.activity_nested1, container, false);


        ListView listView=(ListView) rootView.findViewById(R.id.listView2);
        String[] testArryStrings = new String[]{"update..", "update..", "update..", "update..", "update..", "update..", "update..", "update.."};
        ArrayAdapter aa= new ArrayAdapter(getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                testArryStrings);
        listView.setAdapter(aa);

        if(MainActivity.ts!=null){
            for(int i = 0 ; i < 8 ; i++){
                //String s=MainActivity.daystimes[i]+" "+String.valueOf(MainActivity.dayssteps[i]);
                testArryStrings[i]=String.valueOf(MainActivity.daystimes[i]+" "+MainActivity.dayssteps[i]);
            }
        }


        return rootView;
    }

    public void onStart() {
        super.onStart();
        Log.d("aa", "onStart");



    }


}
