package edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentLicenseBinding;
import edu.aau.projects.volunteerforsudan.screens.VolunteerHomeScreen.VolunteerHomeActivity;

public class LicenseFragment extends Fragment {
    FragmentLicenseBinding bin;

    public LicenseFragment() {
        // Required empty public constructor
    }

    public static LicenseFragment newInstance(String param1, String param2) {
        return new LicenseFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentLicenseBinding.inflate(inflater);
        bin.licenseCbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                enable_button(isChecked);
            }
        });

        bin.btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VolunteerHomeActivity.class));
            }
        });
        return bin.getRoot();
    }

    private void enable_button(boolean enable){
        bin.btnFinish.setEnabled(enable);
    }
}