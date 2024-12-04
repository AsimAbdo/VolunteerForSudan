package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.ActivityRequestBinding;
import edu.aau.projects.volunteerforsudan.models.ServiceRequest;

public class RequestActivity extends AppCompatActivity {
    ActivityRequestBinding bin;
    private final static String REQ_KEY = "request";
    ServiceRequest request;
    public static Intent makeIntent(Context context, ServiceRequest request){
        return new Intent(context, RequestActivity.class).putExtra(REQ_KEY, request);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        bin = ActivityRequestBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        setSupportActionBar(bin.reqToolbar);

        request = (ServiceRequest) getIntent().getSerializableExtra(REQ_KEY);
        putRequestDatainFields(request);

        bin.reqBtnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(DonateActivity.makeIntent(getBaseContext(), request));
            }
        });
    }

    private void putRequestDatainFields(ServiceRequest request){
        setTitle(request.getType());
        bin.requestTvVolunteer.setText("Volunteer : " + request.getVolunteer());
        bin.requestTvDesc.setText("Description : " + request.getDescription());
        bin.requestTvLoc.setText(request.getLocation());
        bin.requestTvDate.setText(request.getDate());
        bin.requestTvAmount.setText(request.getAmount() + "/1000");
        boolean found = false;
        if (request.getHelpers() > 1){
            found = true;
            bin.requestTvVolunteerNumber.setText(request.getHelpers() + "/10");
        }
        helperData(found);

    }

    private void helperData(boolean found){
        if (found){
            bin.reqBtnJoin.setVisibility(View.VISIBLE);
            bin.requestTvVolunteerNumber.setVisibility(View.VISIBLE);
        }
        else {
            bin.reqBtnJoin.setVisibility(View.GONE);
            bin.requestTvVolunteerNumber.setVisibility(View.GONE);
        }
    }
}