package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.aau.projects.volunteerforsudan.R;

public class UploadRequestFragment extends Fragment {

    public UploadRequestFragment() {
        // Required empty public constructor
    }


    public static UploadRequestFragment newInstance(String param1, String param2) {
        UploadRequestFragment fragment = new UploadRequestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload_request, container, false);
    }
}