package edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentPasswordBinding;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PasswordFragment extends Fragment {
    FragmentPasswordBinding bin;
    OnNextClickListener listener;

    public PasswordFragment() {
        // Required empty public constructor
    }

    public static PasswordFragment newInstance() {
        return new PasswordFragment();
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
        bin = FragmentPasswordBinding.inflate(inflater);
        bin.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!UiUtils.verifyFields(bin.etPassword, bin.etPasswordConfirm)){
                    UiUtils.makeToast(R.string.emptyFields, getActivity());
                    return;
                }
                if (!bin.etPassword.getText().toString().equals(bin.etPasswordConfirm.getText().toString())){
                    UiUtils.makeToast(R.string.doesnt_match, getActivity());
                    return;
                }
                String password = bin.etPassword.getText().toString();
                UiUtils.makeToast(password, getActivity());

                listener.onNextClick(4);
            }
        });
        return bin.getRoot();
    }
}