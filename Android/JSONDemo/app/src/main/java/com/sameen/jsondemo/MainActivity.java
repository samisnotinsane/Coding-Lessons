package com.sameen.jsondemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "JSON_Demo";
    private static final String LINK = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=a43378de536df52e71117b7e388dd0c9";
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView) findViewById(R.id.myTextView);

//        DownloadTask task = new DownloadTask();
//        task.execute(LINK);
    }

    // Event handler for 'Download' button
    public void myClickHandler(View view) {

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            new DownloadTask().execute(LINK); // only initiate download if there's an active
                                              // conn.

        } else {
            myTextView.setText("No network connection available.");
        }
    }

    // initiated by 'Download' button handler: myClickHandler
    public class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                // open a file stream from the URL
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch(Exception e) {
                Log.e("JSONDemo:", "Error!", e);
                return "FAIL";
            }
        }
        // called after doInBackground is completed
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {

                Log.i("Website content:", result);

                JSONObject jsonObject = new JSONObject(result);
                String weatherInfo = jsonObject.getString("weather");
                Log.i("Weather content:", weatherInfo);
                JSONArray jsonArray = new JSONArray(weatherInfo);
                String main = "Current weather conditions: ";
                for(int i=0; i<jsonArray.length(); i++) {
                    JSONObject jsonPart = jsonArray.getJSONObject(i);
                     main += jsonPart.getString("main") + " ";
                    Log.i(DEBUG_TAG, main);
//                    Log.i(DEBUG_TAG, jsonPart.getString("description"));

                }

                myTextView.setText(main);
            } catch (JSONException e) {
                Log.e(DEBUG_TAG, "JSON Error!", e);
            }
        }
    }


}
