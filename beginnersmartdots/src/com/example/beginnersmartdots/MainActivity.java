package com.example.beginnersmartdots;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
	
	
	private Handler customHandler = new Handler();
    AnimationDrawable  animDrawable;
    private long startTime = 0L;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		              WindowManager.LayoutParams.FLAG_FULLSCREEN);
       
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
        
 
        imageView.setBackgroundResource(R.drawable.f_animation);  
        animDrawable = (AnimationDrawable) imageView.getBackground(); 
        
    	startTime = SystemClock.uptimeMillis();

		
       	
        
   
        
    }
    
    public void onWindowFocusChanged(boolean hasFocus){
    
    			animDrawable.start();
       
    super.onWindowFocusChanged(hasFocus);
    }
   
    
    @Override  
    public boolean onTouchEvent(MotionEvent event) {
    	 
		
	if(SystemClock.uptimeMillis()-startTime>3000){
	      	Intent intent = new Intent(this, MenuActivity.class);
	          // 呼叫「startActivity」，參數為一個建立好的Intent物件
	          // 這行敘述執行以後，如果沒有任何錯誤，就會啟動指定的元件
	          startActivity(intent);
	          MainActivity.this.finish();
	     }
 
        return super.onTouchEvent(event);
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
