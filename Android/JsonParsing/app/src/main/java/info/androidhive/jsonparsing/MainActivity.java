package info.androidhive.jsonparsing;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private static final String DEBUG_TAG = "JsonParsing";
    private static final String LINK = "http://api.androidhive.info/contacts/";
    private TextView txtDisplay, txtDisplay2;
    String[] contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = (TextView) findViewById(R.id.txtDisplay);
        txtDisplay2 = (TextView) findViewById(R.id.txtDisplay2);

    }

    public void myClickHandler(View view) {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()) {
            // fetching data as there is a conn. available
            Toast.makeText(getBaseContext(),"Please wait, connecting to server.", Toast.LENGTH_LONG).show();
            new DownloadWebPageTask().execute(LINK);
        } else {
            // no network connection available
            txtDisplay.setText("No network connection available.");
            Log.i("Error", "No network connection!");
        }
    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;
            Integer result = 0;
            try {
                /* forming th java.net.URL object */
                URL url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                 /* optional request header */
                urlConnection.setRequestProperty("Content-Type", "application/json");

                /* optional request header */
                urlConnection.setRequestProperty("Accept", "application/json");

                /* for Get request */
                urlConnection.setRequestMethod("GET");
                int statusCode = urlConnection.getResponseCode();

                /* 200 represents HTTP OK */
                if (statusCode ==  200) {
//                    Toast.makeText(getBaseContext(),"HTTP Response: 200 OK.", Toast.LENGTH_LONG).show();
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    String response = convertInputStreamToString(inputStream);
                    parseResult(response);
                    result = 1; // Successful
                }else{
                    result = 0; //"Failed to fetch data!";
                }
            } catch (IOException e) {
                Log.d(DEBUG_TAG, e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }
        @Override
        protected void onPostExecute(Integer result) {
            /* Download complete. Lets update UI */
            if(result == 1){
                Toast.makeText(getBaseContext(),"Done.", Toast.LENGTH_LONG).show();
                txtDisplay.setText(contacts[0]);
                txtDisplay2.setText(contacts[1]);

            }else{
                Log.e(DEBUG_TAG, "Failed to fetch data!");
                Toast.makeText(getBaseContext(),"Fetch failed!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null){
            result += line;
        }

            /* Close Stream */
        if(null!=inputStream){
            inputStream.close();
        }
        return result;
    }

    private void parseResult(String result) {
        try{
            JSONObject response = new JSONObject(result);
            JSONArray contact = response.optJSONArray("contacts");
            contacts = new String[contact.length()];

            for(int i=0; i< contact.length();i++ ){
                JSONObject contactCard = contact.optJSONObject(i);
                String title = contactCard.optString("name");
                contacts[i] = title;
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
