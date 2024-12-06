package edu.aau.projects.volunteerforsudan.screens.VolunteerHomeScreen.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentVolunteerHomeBinding;
import edu.aau.projects.volunteerforsudan.models.ServiceRequest;
import edu.aau.projects.volunteerforsudan.temporary.DataGenerator;
import edu.aau.projects.volunteerforsudan.uiadapters.VolRequestAdapter;

public class VolunteerHomeFragment extends Fragment {
    private static final String ARG_VOLUNTEER = "volunteer";
    String volunteer = "";
    List<ServiceRequest> requests;
    VolRequestAdapter adapter;
    FragmentVolunteerHomeBinding bin;

    public VolunteerHomeFragment() {
        // Required empty public constructor
    }
    public static VolunteerHomeFragment newInstance(String vol_name) {
        VolunteerHomeFragment fragment = new VolunteerHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_VOLUNTEER, vol_name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            volunteer = getArguments().getString(ARG_VOLUNTEER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentVolunteerHomeBinding.inflate(inflater);

        requests = DataGenerator.getServicesByVolunteer(volunteer);
        adapter = new VolRequestAdapter(getContext(), requests);

        bin.vhomeRvRequest.setAdapter(adapter);
        bin.vhomeRvRequest.setLayoutManager(new LinearLayoutManager(getContext()));
        bin.vhomeRvRequest.setHasFixedSize(true);

        return bin.getRoot();
    }
}