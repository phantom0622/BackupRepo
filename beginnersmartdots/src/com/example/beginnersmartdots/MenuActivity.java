package com.example.beginnersmartdots;

import com.example.beginnersmartdots.R;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends ActionBarActivity {
	  @Override
	    public void onCreate(Bundle savedInstanceState) {    
	        super.onCreate(savedInstanceState);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	        		              WindowManager.LayoutParams.FLAG_FULLSCREEN);	       
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.menupage);
	        
	        Button button = (Button) findViewById(R.id.imageButton1);	        
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Do something in response to button click
	            	Intent intent = new Intent( MenuActivity.this, GameView.class);
	  	          // �I�s�ustartActivity�v�A�ѼƬ��@�ӫإߦn��Intent����
	  	          // �o��ԭz����H��A�p�G�S��������~�A�N�|�Ұʫ��w������
	  	          startActivity(intent);
	  	          MenuActivity.this.finish();
	            }
	        });

	        
	        
	        
	    }

}
