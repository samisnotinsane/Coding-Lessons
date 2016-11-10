package com.sameen.searchinterface;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SearchViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
        MenuItem mSearchMenuItem = menu.findItem(R.id.search);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(mSearchMenuItem);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(
                new ComponentName(getApplicationContext(), SearchResultsActivity.class)));
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));


        return true;
    }
}
