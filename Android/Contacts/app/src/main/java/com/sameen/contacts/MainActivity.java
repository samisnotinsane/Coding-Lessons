package com.sameen.contacts;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/* Author: Sameen
 * Data source: androidhive.info
 * Date: July 7 2016
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Contacts";
    private static final String WEB_URL = "http://api.androidhive.info/contacts/";
    private TextView txtId, txtName, txtEmail, txtSex;

    // holds downloaded data
    private String[] iDs, names, emails, sexes;
    // pointer for arrays
    private int iDsPointer, namesPointer, emailsPointer, sexesPointer;

    // current fields
    private int id;
    private String name;
    private String email;
    private String sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise
        txtId = (TextView) findViewById(R.id.txtId);
        txtName = (TextView) findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtSex = (TextView) findViewById(R.id.txtSex);

        iDsPointer = 0;
        namesPointer = 0;
        emailsPointer = 0;
        sexesPointer= 0;
    }

    public void onClickNextBtn(View view) throws Exception {
        Log.d(TAG, "Next button tapped.");

        // move pointers forward
        iDsPointer++;
        namesPointer++;
        emailsPointer++;
        sexesPointer++;



        // check if all items were downloaded; retrieve from cache if it weren't
        if(iDs[5] == null) {

            // data not yet downloaded
            ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isConnected()) {
                // fetching data as there is a conn. available
                Toast.makeText(getBaseContext(),"Fetching...", Toast.LENGTH_SHORT).show();
//                new DataDownloadThread().execute(WEB_URL);
            } else {
                // no network connection available
                Toast.makeText(getBaseContext(),"No network connection!", Toast.LENGTH_LONG).show();
                Log.i("Error", "No network connection!");
            }
        } else {

            // data already downloaded
            if (iDsPointer < iDs.length - 1) {
                id = Integer.parseInt(iDs[iDsPointer]);
                name = names[namesPointer];
                email = emails[emailsPointer];
                sex = sexes[sexesPointer];
            } else {
                resetAllPointers();
            }

        }


    }

    public void onClickPrevBtn(View view) throws Exception {
        Log.d(TAG, "Previous button tapped.");
    }

    public void resetAllPointers() {
        iDsPointer = 0;
        namesPointer = 0;
        emailsPointer = 0;
        sexesPointer = 0;
    }

//    private class DataDownloadThread extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... urls) {
//            // params comes from the execute() call: params[0] is the url.
//            try {
////                return downloadUrl(urls[0]); // contains downloaded content
//            } catch (IOException e) {
//                return "Unable to retrieve web page. URL may be invalid.";
//            }
//        }
//    }

}


