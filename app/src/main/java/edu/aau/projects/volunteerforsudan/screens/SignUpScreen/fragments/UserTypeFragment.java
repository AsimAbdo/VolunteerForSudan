package edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.aau.projects.volunteerforsudan.databinding.FragmentUserTypeBinding;

public class UserTypeFragment extends Fragment {
    FragmentUserTypeBinding bin;
    OnUserClickListener listener;

    public UserTypeFragment() {
        // Required empty public constructor
    }


    public static UserTypeFragment newInstance() {
        return new UserTypeFragment();
    }

    // override to take the context and cast it to listener to send the feedback to Activity
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnUserClickListener)
            listener = (OnUserClickListener) context;
        else
            throw new RuntimeException("You need to implement OnClickListener in SignUpActivity");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentUserTypeBinding.inflate(inflater);
        bin.usertypeIvUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(0);
            }
        });

        bin.usertypeIvVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(1);
            }
        });
        return bin.getRoot();
    }

    // this interface is used to trigger the Activity with the user choice
    public interface OnUserClickListener {

        void onUserClick(int choice); // value will be 0 for regular user, 1 for volunteer
    }
}