package edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentAccountBinding;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

public class AccountFragment extends Fragment {
    FragmentAccountBinding bin;
    OnNextClickListener listener;

    public AccountFragment() {
        // Required empty public constructor
    }


    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
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
        bin = FragmentAccountBinding.inflate(inflater);
        bin.btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!UiUtils.verifyFields(bin.etEmail, bin.etPhoneNumber,
                        bin.etPassword, bin.etPasswordconfirm)){
                    UiUtils.makeToast(R.string.emptyFields, getActivity());
                    return;
                }
                if (!bin.etPassword.getText().toString().equals(bin.etPasswordconfirm.getText().toString())){
                    UiUtils.makeToast(R.string.doesnt_match, getActivity());
                    return;
                }
                String email = bin.etEmail.getText().toString();
                String phone_number = bin.etPhoneNumber.getText().toString();
                String password = bin.etPassword.getText().toString();
                UiUtils.makeToast(email + phone_number + password, getActivity());

                listener.onNextClick(2);
            }
        });
        return bin.getRoot();
    }
}