package com.sameen.eventhandling;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout setup
        RelativeLayout sameensLayout = new RelativeLayout(this);
        sameensLayout.setBackgroundColor(Color.CYAN);

        // Button (will be centred)
        Button redButton = new Button(this);
        redButton.setText(R.string.main_btn);
        redButton.setBackgroundColor(Color.RED);

        // App title
        TextView appTitle = new TextView(this);
        appTitle.setText(R.string.app_title);
        appTitle.setTextSize(26f);

        // Set IDs for widgets
        redButton.setId(1);
        appTitle.setId(2);

        // Defining container for widgets
        RelativeLayout.LayoutParams redButtonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams appTitleDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // Button should be centred
        redButtonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        redButtonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        // Textview should be near top and horiz. centred
        appTitleDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        appTitleDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        appTitleDetails.setMargins(0,0,0,250);

        sameensLayout.addView(redButton, redButtonDetails);
        sameensLayout.addView(appTitle, appTitleDetails);

        setContentView(sameensLayout);
    }
}
