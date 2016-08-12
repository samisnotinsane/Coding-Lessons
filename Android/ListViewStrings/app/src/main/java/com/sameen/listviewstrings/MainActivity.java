package com.sameen.listviewstrings;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*
 * Source: http://www.tutorialspoint.com/android/android_list_view.htm
 * Date: 11/08/16
 */

public class MainActivity extends Activity implements SearchView.OnQueryTextListener {

    private List<String> mobileList = new ArrayList<>();
    private SearchView mSearchView;
    private TextView mStatusView;
//    private Menu menu;
    String[] mobileArray = {"Android","iPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Mac OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        populatemobileList();
        mStatusView = (TextView) findViewById(R.id.status_text);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
//            doMySearch(query);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = ((TextView)view).getText().toString() + " Selected";
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        mSearchView = (SearchView) searchItem.getActionView();
//        setupSearchView(searchItem);

        return true;
    }

    // adds Strings to the ArrayList - hardcoded at this point
    protected void populatemobileList() {
        mobileList.add("Android");
        mobileList.add("iPhone");
        mobileList.add("WindowsMobile");
        mobileList.add("Blackberry");
        mobileList.add("WebOS");
        mobileList.add("Ubuntu");
        mobileList.add("Windows7");
        mobileList.add("Mac OS X");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
