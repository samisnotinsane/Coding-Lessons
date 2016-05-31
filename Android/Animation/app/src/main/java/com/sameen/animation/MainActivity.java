package com.sameen.animation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        ImageView reese = (ImageView) findViewById(R.id.imgReese);
//        reese.animate().alpha(0f).setDuration(2000); // make transparent for 2s
//        reese.animate().translationXBy(1000f).setDuration(2000);
        reese.animate().rotation(180f).setDuration(2000);

        ImageView finch = (ImageView) findViewById(R.id.imgFinch);
        finch.animate().alpha(0.5f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ImageView reese = (ImageView) findViewById(R.id.imgReese);
        reese.setTranslationX(-1000f);
        */

    }
}
