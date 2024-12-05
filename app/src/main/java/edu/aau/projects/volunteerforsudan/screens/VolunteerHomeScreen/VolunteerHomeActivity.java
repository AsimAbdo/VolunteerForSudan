package edu.aau.projects.volunteerforsudan.screens.VolunteerHomeScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.ActivityVolunteerHomeBinding;
import edu.aau.projects.volunteerforsudan.screens.BaseActivity;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments.ContributionsFragment;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments.HomeFragment;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments.UploadRequestFragment;
import edu.aau.projects.volunteerforsudan.screens.VolunteerHomeScreen.fragments.RequestFragment;
import edu.aau.projects.volunteerforsudan.screens.VolunteerHomeScreen.fragments.VolunteerHomeFragment;

public class VolunteerHomeActivity extends BaseActivity implements NavigationBarView.OnItemSelectedListener {
    ActivityVolunteerHomeBinding bin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        bin = ActivityVolunteerHomeBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        setSupportActionBar(bin.vhomeToolbar);

        bin.vhomeBnv.setOnItemSelectedListener(this);
        pushFragment(this, VolunteerHomeFragment.newInstance("Asim"), bin.vhomeContainer.getId(), false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.vhome_menu_home)
            pushFragment(this, VolunteerHomeFragment.newInstance("Asim"), bin.vhomeContainer.getId(), false);
        else if (item.getItemId() == R.id.vhome_menu_cont)
            pushFragment(this, new HomeFragment(), bin.vhomeContainer.getId(), false);
        else
            pushFragment(this, new RequestFragment(), bin.vhomeContainer.getId(), false);
        return true;
    }
}