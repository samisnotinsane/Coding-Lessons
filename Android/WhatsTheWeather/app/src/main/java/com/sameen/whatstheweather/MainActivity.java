package com.sameen.whatstheweather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "whatstheweather";
    private static final String URL_HOST = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static String urlQuery = ""; // location name goes here
    private static final String URL_KEY = "&APPID=a43378de536df52e71117b7e388dd0c9";
//    private static final String API_LINK_FULL = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=a43378de536df52e71117b7e388dd0c9";
    private TextView txtCityName;
    private TextView lblReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise resources
        txtCityName = (TextView) findViewById(R.id.txtCityName);
        lblReport = (TextView) findViewById(R.id.lblReport);

        // wait for user to enter city name and tap GET.
    }

    // Called upon tapping GET button
    public void getBtnHandler(View view) {
        // get input from user
        try {
            urlQuery = (String) txtCityName.getText();
            Log.d(DEBUG_TAG, "User entered city: "+urlQuery);
        } catch (Exception e) {
            Log.e(DEBUG_TAG, "No city was entered by user.", e);
        }
        // check network connection and initiate web transaction
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // form API query string
            String apiFullString = URL_HOST + urlQuery + URL_KEY;
            new DownloadThread().execute(apiFullString); // only initiate download if there's an active conn.

        } else {
            lblReport.setText("No network connection available.");
        }
    }

    public class DownloadThread extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            // download web content as string
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();


            } catch (MalformedURLException e) {
                Log.e(DEBUG_TAG, "A MalformedURLException occurred in doInBackground.", e);
            } catch (IOException e) {
                Log.e(DEBUG_TAG, "An IOException occurred in doInBackground.", e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // parse string as JSON

        }
    }


}
