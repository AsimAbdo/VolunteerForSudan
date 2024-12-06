package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentUploadRequestBinding;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.OnNextClickListener;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

public class UploadRequestFragment extends Fragment {
    FragmentUploadRequestBinding bin;
    OnGetImageClickListener listener;
    public UploadRequestFragment() {
        // Required empty public constructor
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnGetImageClickListener)
            listener = (OnGetImageClickListener) context;
        else
            throw new RuntimeException("You have to implement OnGetImageClickListener in UserHomeActivity");
    }

    public static UploadRequestFragment newInstance() {
        return new UploadRequestFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentUploadRequestBinding.inflate(getLayoutInflater());


        bin.uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UiUtils.verifyFields(bin.uploadEtLocation, bin.uploadEtAmount, bin.uploadEtDescription)){
                    UiUtils.makeToast(R.string.emptyFields, getActivity());
                    return;
                }
                String type = bin.spServiceType.getSelectedItem().toString();
                String description = bin.uploadEtDescription.getText().toString();
                String location = bin.uploadEtLocation.getText().toString();
//                double amount = Double.parseDouble(bin.uploadEtAmount.getText().toString());


            }
        });
        bin.uploadTvGetImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onGetImageClick();
            }
        });
        return bin.getRoot();
    }

    public interface OnGetImageClickListener {
        Uri onGetImageClick();
    }

}