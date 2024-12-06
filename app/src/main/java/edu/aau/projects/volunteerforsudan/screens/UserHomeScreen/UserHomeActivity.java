package edu.aau.projects.volunteerforsudan.screens.UserHomeScreen;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiContext;
import androidx.appcompat.widget.SearchView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import edu.aau.projects.volunteerforsudan.R;
import edu.aau.projects.volunteerforsudan.databinding.ActivityUserHomeBinding;
import edu.aau.projects.volunteerforsudan.screens.BaseActivity;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments.ContributionsFragment;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments.HomeFragment;
import edu.aau.projects.volunteerforsudan.screens.UserHomeScreen.fragments.UploadRequestFragment;
import edu.aau.projects.volunteerforsudan.utils.UiUtils;

public class UserHomeActivity extends BaseActivity implements NavigationBarView.OnItemSelectedListener,
        LocationListener, UploadRequestFragment.OnGetImageClickListener {
    ActivityUserHomeBinding bin;
    SearchView searchView;
    LocationManager locationManager;
    private final int Location_REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init(){
        bin = ActivityUserHomeBinding.inflate(getLayoutInflater());
        setContentView(bin.getRoot());
        setSupportActionBar(bin.userToolbar);
        setTitle(getString(R.string.greeting).concat("User"));

        bin.userBottomNavView.setOnItemSelectedListener(this);
        pushFragment(this, new HomeFragment(), bin.userContainer.getId(), false);

//        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        if (! checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, this)){
//            requestPermissions(this, Location_REQ_CODE, Manifest.permission.ACCESS_FINE_LOCATION);
//        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        try {
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
//        } catch (SecurityException e){
//            UiUtils.makeToast("Permission is not granted", this);
//        }
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.user_menu_home)
            pushFragment(this, new HomeFragment(), bin.userContainer.getId(), false);
        else if (item.getItemId() == R.id.user_menu_request)
            pushFragment(this, new UploadRequestFragment(), bin.userContainer.getId(), false);
        else
            pushFragment(this, new ContributionsFragment(), bin.userContainer.getId(), false);

        return true;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
//        if (location != null)
//            return;
//        Log.d("onLocationChanged:" ,location.toString());
//
//        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//        List<Address> addresses = null;
//        try {
//            addresses = geocoder.getFromLocation(
//                    location.getLatitude(),
//                    location.getLongitude(),
//                    1
//            );
//        } catch (IOException e) {
//            Log.d("onLocationChanged:" ,"IO : " + e.getMessage());
//        }
//        catch (IllegalArgumentException e){
//            Log.d("onLocationChanged:" , "IllegalArg : " + e.getMessage());
//
//        }
//        if (addresses != null && !addresses.isEmpty()){
//            Address mAddress = addresses.get(0);
//            Log.d("onLocationChanged:" ,"Country is : " + mAddress.getCountryName());
//        }
    }

    @Override
    public Uri onGetImageClick() {
//        Intent getImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(getImage, 2);
//        registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
//            @Override
//            public void onActivityResult(Uri o) {
//
//            }
//        });
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null){
            UiUtils.makeToast("Something happened", this);
        }
        else {
            UiUtils.makeToast("Done", this);
        }
    }
}