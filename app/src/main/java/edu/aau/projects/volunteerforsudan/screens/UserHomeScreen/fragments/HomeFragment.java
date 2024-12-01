package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import java.util.List;
import edu.aau.projects.volunteerforsudan.databinding.FragmentHomeBinding;
import edu.aau.projects.volunteerforsudan.models.ServiceRequest;
import edu.aau.projects.volunteerforsudan.screens.LogFragment;
import edu.aau.projects.volunteerforsudan.temporary.DataGenerator;
import edu.aau.projects.volunteerforsudan.uiadapters.ServiceAdapter;

public class HomeFragment extends LogFragment {
    FragmentHomeBinding bin;
    ServiceAdapter adapter;
    List<ServiceRequest> requests;
    public static final String USER_SEARCH_KEY = "search_key";
    private String user_search = "";

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String query) {
        HomeFragment fragment = new HomeFragment();
        Bundle bun = new Bundle();
        bun.putString(USER_SEARCH_KEY, query);
        fragment.setArguments(bun);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bun = getArguments();
        if (bun != null){
            user_search = bun.getString(USER_SEARCH_KEY, "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentHomeBinding.inflate(inflater);

        // set up the recycler view to display data
        requests = DataGenerator.getServicesByVolunteer(user_search);

        adapter = new ServiceAdapter(getActivity(), requests);
        bin.userHomeRv.setAdapter(adapter);
        bin.userHomeRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        bin.userHomeRv.setHasFixedSize(true);

        // set up the spinners
        bin.spServiceFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = parent.getItemAtPosition(position).toString();
                adapter.setServices(DataGenerator.getServicesByType(requests, type));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                adapter.setServices(DataGenerator.getServicesByVolunteer(user_search));
            }
        });
        return bin.getRoot();
    }
}