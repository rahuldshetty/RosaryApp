package com.rahuldshetty.rosaryaudioapp.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.rahuldshetty.rosaryaudioapp.R;
import com.rahuldshetty.rosaryaudioapp.main_fragments.MainFragment;

public class HomeActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;

    private MainFragment konkani,english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundleEng = new Bundle();
        bundleEng.putString("type", "eng");
        Bundle bundleKan = new Bundle();
        bundleKan.putString("type", "kan");

        english = new MainFragment();
        english.setArguments(bundleEng);

        konkani = new MainFragment();
        konkani.setArguments(bundleKan);

        frameLayout = findViewById(R.id.home_frame_layout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navKonkani:
                        loadFragment(konkani);
                        return true;

                    case R.id.navRomi:
                        loadFragment(english);
                        return true;
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.navKonkani);
        loadFragment(konkani);

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.home_frame_layout, fragment);
        fragmentTransaction.commit();
    }

}
