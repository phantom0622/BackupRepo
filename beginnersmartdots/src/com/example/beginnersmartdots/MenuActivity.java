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
	  	          // 呼叫「startActivity」，參數為一個建立好的Intent物件
	  	          // 這行敘述執行以後，如果沒有任何錯誤，就會啟動指定的元件
	  	          startActivity(intent);
	  	          MenuActivity.this.finish();
	            }
	        });

	        
	        
	        
	    }

}
