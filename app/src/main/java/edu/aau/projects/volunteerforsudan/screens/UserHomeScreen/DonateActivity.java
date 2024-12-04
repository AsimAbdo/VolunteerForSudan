package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.ActivityDonateBinding;
import edu.aau.projects.volunteerforsudan.models.ServiceRequest;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

public class DonateActivity extends AppCompatActivity {
    private static final int IMAGE_REQ_CODE = 2;
    private static final String REQ_KEY = "request";
    ActivityDonateBinding bin;
    ServiceRequest request;
    Uri image_data;

    public static Intent makeIntent(Context context, ServiceRequest request){
        return new Intent(context, DonateActivity.class).putExtra(REQ_KEY, request);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        bin = ActivityDonateBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        setSupportActionBar(bin.donateToolbar);

        request = (ServiceRequest) getIntent().getSerializableExtra(REQ_KEY);
        putRequestDataInFields(request);

        bin.donateTvUploadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                startActivityForResult(intent, IMAGE_REQ_CODE);
            }
        });

        bin.donateBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (image_data == null){
                    UiUtils.makeToast(R.string.no_image_selected, getBaseContext());
                    return;
                }
                UiUtils.makeToast("Under development", getBaseContext());
            }
        });

        bin.donateSpBankName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String account_number = "";
                switch (position){
                    case 0:
                        account_number = "1234";
                        break;
                    case 1:
                        account_number = "5678";
                        break;
                    case 2:
                        account_number = "9101";
                        break;
                }
                bin.donateTvAccountNmber.setText(account_number);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void putRequestDataInFields(ServiceRequest request){
        setTitle(request.getType());
        bin.donateTvVolunteer.setText("Volunteer : " + request.getVolunteer());
        bin.donateTvAmount.setText(request.getAmount() + "/1000");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQ_CODE && data != null){
            image_data = data.getData();
        }
    }
}