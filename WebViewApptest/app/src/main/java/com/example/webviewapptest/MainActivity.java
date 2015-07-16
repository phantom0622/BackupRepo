package com.example.webviewapptest;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBarActivity;
import android.os.Handler;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("JavascriptInterface")
public class MainActivity extends ActionBarActivity {

    private EditText txt;
    private Button btn;
    private WebView cusBrowser;
    private Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText) findViewById(R.id.txt);
        btn = (Button) findViewById(R.id.btn);

        // 建立一個 WebView
        cusBrowser =(WebView)findViewById(R.id.wv);
        // 開啟 HTML5 Web Storage
        WebSettings web_Set = cusBrowser.getSettings();

        //預設是限制JavaScript，所以如有需要必需先開啟。
        web_Set.setJavaScriptEnabled(true);
        //啟用網頁縮放功能
        web_Set.setSupportZoom(true);
        web_Set.setBuiltInZoomControls(true);
        cusBrowser.addJavascriptInterface(new runJavaScript(), "myjs");

        //預設值會使用Android本常的瀏覽器打開連接，如果想繼續自己的瀏覽器，
        //則可以使用下列的方法：
        cusBrowser.setWebViewClient(new WebViewClient());

        cusBrowser.loadUrl("file:///android_asset/index.html");

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //調用javascript的函數get4Android(str)
                Toast.makeText(MainActivity.this, "APP click... ", Toast.LENGTH_SHORT).show();
                cusBrowser.loadUrl("javascript:get4Android('" + txt.getText().toString() + "')");

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    final class runJavaScript
    {
        //這個Java 物件是綁定在另一個線程裏的，
        public void runOnAndroidJavaScript(final String str)
        {
            h.post(new Runnable()
            {
                @Override
                public void run()
                {
                    //這裏應該特別注意的
                    TextView show = (TextView) findViewById(R.id.show);
                    show.setText("This is a message from javascript:"+str);
                }
            });
        }

        public void btnClick() {
            Toast.makeText(MainActivity.this, "WebView click... ", Toast.LENGTH_SHORT).show();
        }

    }

}
