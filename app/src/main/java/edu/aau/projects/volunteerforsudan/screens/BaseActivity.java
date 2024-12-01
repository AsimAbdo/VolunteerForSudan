package edu.aau.projects.volunteerforsudan.screens;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends LogActivity {

    public boolean checkPermission(String permission, Context context){
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermissions(Activity activity, int req_code, String... permissions){
        if (permissions.length > 0){
            ActivityCompat.requestPermissions(activity, permissions, req_code);
        }
    }

    public void pushFragment(FragmentActivity activity, Fragment fragment, int container_id, String title){
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container_id, fragment);
        ft.addToBackStack(null);
        ft.commit();
        activity.setTitle(title);
    }

    public void pushFragment(FragmentActivity activity, Fragment fragment, int container_id, int title){
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container_id, fragment);
        ft.addToBackStack(null);
        ft.commit();
        activity.setTitle(title);
    }

    public void pushFragment(FragmentActivity activity, Fragment fragment, int container_id, boolean addToBackStack){
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container_id, fragment);
        if (addToBackStack)
            ft.addToBackStack(null);
        ft.commit();
    }
}
