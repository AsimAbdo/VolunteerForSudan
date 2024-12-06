package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import java.util.List;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentHomeBinding;
import edu.aau.projects.volunteerforsudan.models.ServiceRequest;
import edu.aau.projects.volunteerforsudan.screens.LogFragment;
import edu.aau.projects.volunteerforsudan.temporary.DataGenerator;
import edu.aau.projects.volunteerforsudan.uiadapters.ServiceAdapter;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

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

        return new HomeFragment();
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

        adapter = new ServiceAdapter(getContext(), requests);
        bin.userHomeRv.setAdapter(adapter);
        bin.userHomeRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        bin.userHomeRv.setHasFixedSize(true);

        bin.svVol.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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

        bin.ivFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bin.lnFilters.getVisibility() == View.VISIBLE)
                    bin.lnFilters.setVisibility(View.GONE);
                else
                    bin.lnFilters.setVisibility(View.VISIBLE);

            }
        });
        return bin.getRoot();
    }

    private void updateData(String query){
        user_search = query;
        requests = DataGenerator.getServicesByVolunteer(user_search);
        adapter.setServices(requests);
    }
}