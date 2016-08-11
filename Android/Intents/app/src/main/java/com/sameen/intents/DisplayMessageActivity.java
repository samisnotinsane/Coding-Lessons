package com.sameen.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent getIntent = getIntent(); // grabs intent which started this activity
        String message = getIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView txtMsgBucket = (TextView) findViewById(R.id.txtMsgBucket);
        txtMsgBucket.setText(message);


    }
}
