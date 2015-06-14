package com.example.vino;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by peter on 2015/5/17.
 */
public class LoginActivity extends ActionBarActivity {

    Button btn_login;
    Boolean result_Flag = false;

    InputStream is = null;

    String ip = "http://104.236.21.75:3101/user/";
    String line = null;
    String result = null;
    List<String> list;

    boolean connection = false;

    TextView register;
    TextView forget;
    ProgressBar probar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login=(Button)findViewById(R.id.Loginbutton);
        register=(TextView)findViewById(R.id.textView2);
        forget=(TextView)findViewById(R.id.textView7);
        probar=(ProgressBar)findViewById(R.id.progressBar);

        register.setMovementMethod(LinkMovementMethod.getInstance());
        forget.setMovementMethod(LinkMovementMethod.getInstance());

        btn_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username =((EditText)findViewById(R.id.userName)).getText().toString();
                String password =((EditText)findViewById(R.id.password)).getText().toString();

                if(username.length()<1 && password.length()<1){
                    // out of range
                    Toast.makeText(getBaseContext(), "please enter something", Toast.LENGTH_LONG).show();
                }else {
                    ip=ip+username+"/"+password;
                    probar.setVisibility(View.VISIBLE);
                    new DownloadWebpageTask().execute(ip);
                    Toast.makeText(getBaseContext(), ip, Toast.LENGTH_LONG).show();
                    result_Flag = true;
                }



                if(result_Flag) {
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, SelectDeviceActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getBaseContext(), "Account Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

/*    private void connectDatabase() {


        try {

            URL url = new URL(ip);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(3000);
            con.setConnectTimeout(3500);
            con.setRequestMethod("GET");
            con.setDoInput(true);

            // Connect
            con.connect();
            connection = true;

        }
        catch(Exception e) {
            connection = false;
        }

        if(connection == true) {
            // call webservice activity and get list value
          //  webserviceCall();
        }
        else {

            Toast.makeText(getBaseContext(), "Connection Failed", Toast.LENGTH_SHORT).show();
        }

        result_Flag=true;
    }
*/
 /*   private void webserviceCall() {
        // TODO Auto-generated method stub

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(ip);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        }
        catch (Exception e) {
            Log.e("Webservice 1", e.toString());
        }
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();

            while((line = reader.readLine()) != null) {

                sb.append(line + "\n");
            }

            is.close();
            result = sb.toString();
        }
        catch (Exception e) {
            Log.e("Webservice 2", e.toString());
        }
        try {

            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;

            list = new ArrayList<String>();

            for(int i=0; i<ja.length(); i++) {

                jo = ja.getJSONObject(i);
                list.add(jo.getString("uname"));
            }
        }catch (Exception e) {
            Log.e("Webservice 3", e.toString());
        }
    }
*/

    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {


            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);

            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            probar.setVisibility(View.GONE);

        }
    }

    private String downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
           // Log.d(DEBUG_TAG, "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);

            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }



    // Reads an InputStream and converts it to a String.
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
