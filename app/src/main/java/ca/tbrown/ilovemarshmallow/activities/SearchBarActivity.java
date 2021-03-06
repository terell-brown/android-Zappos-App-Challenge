package ca.tbrown.ilovemarshmallow.activities;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import ca.tbrown.ilovemarshmallow.Constants;
import ca.tbrown.ilovemarshmallow.R;


public class SearchBarActivity extends BaseActivity {
    // A parent activity for other activities using a searchbar (ie. Results and Product Details Activity)

    // UI
    public SearchView searchbox;
    public Toolbar toolbar;
    public String searchQuery;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_results, menu);
        setupSearchBox(menu);
        return true;
    }

    public void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setupSearchBox(Menu menu) {
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        searchbox = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchbox.setSearchableInfo(searchableInfo);
        searchbox.setIconifiedByDefault(false);
        searchbox.setQuery(searchQuery, false);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                break;
            case android.R.id.home:
                Intent intent = NavUtils.getParentActivityIntent(this);
                intent.putExtra(Constants.QUERY, searchQuery);
                intent.putExtra(Constants.IS_BACK_NAV,true);
                NavUtils.navigateUpTo(this,intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
