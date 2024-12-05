package edu.aau.projects.volunteerforsudan.screens.VolunteerHomeScreen.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentRequestBinding;
import edu.aau.projects.volunteerforsudan.uiadapters.CheckRequestAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestFragment extends Fragment {
    FragmentRequestBinding bin;
    CheckRequestAdapter adapter;
    public RequestFragment() {
        // Required empty public constructor
    }

    public static RequestFragment newInstance(String param1, String param2) {
        return new RequestFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentRequestBinding.inflate(inflater);

        adapter = new CheckRequestAdapter();

        bin.reqRv.setAdapter(adapter);
        bin.reqRv.setLayoutManager(new LinearLayoutManager(getContext()));
        bin.reqRv.setHasFixedSize(true);

        return bin.getRoot();
    }
}