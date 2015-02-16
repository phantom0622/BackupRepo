

import com.example.beginnersmartdots.R;

import android.support.v7.app.ActionBarActivity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
public class MenuActivity extends ActionBarActivity {
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	    
	        super.onCreate(savedInstanceState);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	        		              WindowManager.LayoutParams.FLAG_FULLSCREEN);
	       
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.menupage);
	        

 
	        
	        
	        
	    }

}
