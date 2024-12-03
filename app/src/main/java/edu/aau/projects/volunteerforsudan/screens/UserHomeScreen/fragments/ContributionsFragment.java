package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.aau.projects.volunteerforsudan.databinding.FragmentContributionsBinding;
import edu.aau.projects.volunteerforsudan.uiadapters.ContributionAdapter;

public class ContributionsFragment extends Fragment {
    FragmentContributionsBinding bin;
    ContributionAdapter adapter;
    public ContributionsFragment() {
        // Required empty public constructor
    }

    public static ContributionsFragment newInstance() {
        return new ContributionsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentContributionsBinding.inflate(inflater);

        adapter = new ContributionAdapter();
        bin.contRv.setAdapter(adapter);
        bin.contRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        bin.contRv.setHasFixedSize(true);
        return bin.getRoot();
    }
}