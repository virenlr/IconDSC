package com.lukehere.app.icondsc.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.fragments.AboutFragment;
import com.lukehere.app.icondsc.fragments.AlertsFragment;
import com.lukehere.app.icondsc.fragments.FeedbackFragment;
import com.lukehere.app.icondsc.fragments.ScheduleFragment;
import com.lukehere.app.icondsc.fragments.SignOutFragment;
import com.lukehere.app.icondsc.fragments.SpeakersFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    public static int mBackCount = 0;

    @Override
    public void onBackPressed() {
        mBackCount++;

        if (mBackCount == 1) {
            Toast.makeText(this, getString(R.string.back_to_exit), Toast.LENGTH_SHORT).show();
        } else if (mBackCount == 2) {
            finishAffinity();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setItemIconTintList(null);
        mFragmentManager = getSupportFragmentManager();

        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        mFragmentTransaction = mFragmentManager.beginTransaction();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_alerts:
                                AlertsFragment alertsFragment = new AlertsFragment();
                                mFragmentTransaction.replace(R.id.fragment_container, alertsFragment);
                                mFragmentTransaction.commit();
                                break;

                            case R.id.nav_schedule:
                                ScheduleFragment scheduleFragment = new ScheduleFragment();
                                mFragmentTransaction.replace(R.id.fragment_container, scheduleFragment);
                                mFragmentTransaction.commit();
                                break;

                            case R.id.nav_speaker_details:
                                SpeakersFragment speakersFragment = new SpeakersFragment();
                                mFragmentTransaction.replace(R.id.fragment_container, speakersFragment);
                                mFragmentTransaction.commit();
                                break;
                            case R.id.nav_feedback:
                                FeedbackFragment feedbackFragment = new FeedbackFragment();
                                mFragmentTransaction.replace(R.id.fragment_container, feedbackFragment);
                                mFragmentTransaction.commit();
                                break;
                            case R.id.nav_sign_out:
                                SignOutFragment signOutFragment = new SignOutFragment();
                                mFragmentTransaction.replace(R.id.fragment_container, signOutFragment);
                                mFragmentTransaction.commit();
                                break;

                            case R.id.nav_about:
                                AboutFragment aboutFragment = new AboutFragment();
                                mFragmentTransaction.replace(R.id.fragment_container, aboutFragment);
                                mFragmentTransaction.commit();
                                break;
                        }
                        return true;
                    }
                });

        if (savedInstanceState == null) {
            mNavigationView.getMenu().performIdentifierAction(R.id.nav_alerts, 0);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mode", 1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setToolbar(Toolbar toolbar, String title) {
        setSupportActionBar(toolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(title);
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }
}