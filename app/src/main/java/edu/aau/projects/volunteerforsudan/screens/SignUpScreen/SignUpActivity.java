package edu.aau.projects.volunteerforsudan.screens.SignUpScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.ActivitySignUpBinding;
import edu.aau.projects.volunteerforsudan.screens.BaseActivity;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.AccountFragment;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.ContactFragment;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.IdCheckFragment;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.LicenseFragment;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.OnNextClickListener;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.PasswordFragment;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.PersonalInfoFragment;
import edu.aau.projects.volunteerforsudan.screens.SignUpScreen.fragments.UserTypeFragment;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.UserHomeActivity;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

// implements this interface to receive the value of what user have chosen
public class SignUpActivity extends BaseActivity implements UserTypeFragment.OnUserClickListener
        , OnNextClickListener {
    ActivitySignUpBinding bin;
    int user_type = -1;// 0 for regular 1 for volunteer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    // set up the views settings it will be used in onCreate method
    private void init(){
        bin = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        setSupportActionBar(bin.signToolbar);

        pushFragment(this, new UserTypeFragment(), bin.signContainer.getId(), true);
    }

    @Override
    public void onUserClick(int choice) {
        user_type = choice;
        pushFragment(this, PersonalInfoFragment.newInstance(user_type), bin.signContainer.getId(), true);
    }

    @Override
    public void onNextClick(int current_progress) {
        if (user_type == 0 && current_progress == 1){
            pushFragment(this, new AccountFragment(), bin.signContainer.getId(), true);
        } else if (user_type == 0) {
            startActivity(new Intent(this, UserHomeActivity.class));
        }
        else {
            switch (current_progress) {
                case 1:
                    pushFragment(this, new ContactFragment(), bin.signContainer.getId(), true);
                    break;
                case 2:
                    pushFragment(this, new IdCheckFragment(), bin.signContainer.getId(), true);
                    break;
                case 3:
                    pushFragment(this, new PasswordFragment(), bin.signContainer.getId(), true);
                    break;
                case 4:
                    pushFragment(this, new LicenseFragment(), bin.signContainer.getId(), true);
                    break;
            }
        }
    }
}