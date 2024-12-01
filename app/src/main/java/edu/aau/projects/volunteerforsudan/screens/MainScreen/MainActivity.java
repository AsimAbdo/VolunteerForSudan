package edu.aau.projects.volunteerforsudan.screens.MainScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.aau.projects.volunteerforsudan.databinding.ActivityMainBinding;
import edu.aau.projects.volunteerforsudan.screens.BaseActivity;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.SignUpActivity;

public class MainActivity extends BaseActivity {
    ActivityMainBinding bin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    // set up the views settings it will be used in onCreate method
    private void init(){
        bin = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        setSupportActionBar(bin.mainToolbar);

        bin.mainTvCreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SignUpActivity.class));
            }
        });
    }
}