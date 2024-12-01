package edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.aau.projects.volunteerforsudan.databinding.FragmentIdCheckBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IdCheckFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IdCheckFragment extends Fragment {
    FragmentIdCheckBinding bin;
    OnNextClickListener listener;

    public IdCheckFragment() {
        // Required empty public constructor
    }

    public static IdCheckFragment newInstance() {
        return new IdCheckFragment();
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNextClickListener)
            listener = (OnNextClickListener) context;
        else
            throw new RuntimeException("You have to implement OnclickListener in SignUpActivity");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentIdCheckBinding.inflate(inflater);

        bin.btnCapture.setOnClickListener(null);

        bin.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNextClick(3);
            }
        });
        return bin.getRoot();
    }
}