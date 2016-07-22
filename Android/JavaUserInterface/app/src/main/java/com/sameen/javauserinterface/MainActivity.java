package com.sameen.javauserinterface;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout setup
        RelativeLayout sameensLayout = new RelativeLayout(this);
        sameensLayout.setBackgroundColor(Color.GREEN);

        // Button
        Button yellowButton = new Button(this);
        yellowButton.setText("Login");
        yellowButton.setBackgroundColor(Color.RED);

        // Username input field
        EditText editText = new EditText(this);

        // Adding IDs to widget for referencing later
        yellowButton.setId(1);

        // container will match the size of the button inside it
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams editTextDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // position editText just above the button
        editTextDetails.addRule(RelativeLayout.ABOVE, yellowButton.getId()); // 2nd param is...
        // ...the widget relative to which the new widget is positioned
        editTextDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);

        // add some padding between the two widgets
        editTextDetails.setMargins(0,0,0,50);

        // spawn button in centre of screen - i.e. set position
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        // Add button to layout
        sameensLayout.addView(yellowButton, buttonDetails); // 2nd param states position details
        sameensLayout.addView(editText, editTextDetails); // adds field and positioning details

        // Set "root node" as the content of the activity
        setContentView(sameensLayout);

    }
}
