package edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.FragmentPersonalInfoBinding;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

public class PersonalInfoFragment extends Fragment {
    FragmentPersonalInfoBinding bin;
    OnNextClickListener listener;// to trigger SignUpActivity
    int user_type = -1; // 0 for Regular user 1 for Volunteer

    public PersonalInfoFragment() {
        // Required empty public constructor
    }


    public static PersonalInfoFragment newInstance(int user_type) {
        PersonalInfoFragment fragment = new PersonalInfoFragment();
        Bundle bun = new Bundle();
        bun.putInt("user_type", user_type);
        fragment.setArguments(bun);
        return fragment;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bun = getArguments();
        if (bun != null){
            user_type = bun.getInt("user_type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bin = FragmentPersonalInfoBinding.inflate(inflater);

        bin.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UiUtils.isEmpty(bin.personInfoEtFirstName)
                        || UiUtils.isEmpty(bin.personInfoEtLastName)){
                    UiUtils.makeToast(R.string.emptyFields, getActivity());
                    return;
                }
                String firstname = bin.personInfoEtFirstName.getText().toString();
                String lastname = bin.personInfoEtLastName.getText().toString();
                UiUtils.makeToast(firstname + " , " + lastname, getActivity());
                listener.onNextClick(1);
            }
        });

        if (user_type != 0)
            bin.progress.setText("1/5");
        return bin.getRoot();
    }
}