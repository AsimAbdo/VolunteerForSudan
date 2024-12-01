package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.ActivityUserHomeBinding;
import edu.aau.projects.volunteerforsudan.screens.BaseActivity;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments.HomeFragment;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

public class UserHomeActivity extends BaseActivity implements NavigationBarView.OnItemSelectedListener {
    ActivityUserHomeBinding bin;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        bin = ActivityUserHomeBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        setSupportActionBar(bin.userToolbar);

        bin.userBottomNavView.setOnItemSelectedListener(this);
        pushFragment(this, new HomeFragment(), bin.userContainer.getId(), false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.home_menu_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                pushFragment(UserHomeActivity.this, HomeFragment.newInstance(query), bin.userContainer.getId(), false);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pushFragment(UserHomeActivity.this, HomeFragment.newInstance(newText), bin.userContainer.getId(), false);
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                pushFragment(UserHomeActivity.this, new HomeFragment(), bin.userContainer.getId(), false);
                return false;
            }
        });
        return true;
    }

}