package com.sameen.listviewdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.myListView);

        final ArrayList<String> myFriends = new ArrayList<>();
        myFriends.add("Sam");
        myFriends.add("Fahad");
        myFriends.add("Hamzah");
        myFriends.add("Mahadi");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        myListView.setAdapter(arrayAdapter); // displays arraylist names in listview

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.i("Person tapped: ", myFriends.get(position));
            }
        });

    }
}
