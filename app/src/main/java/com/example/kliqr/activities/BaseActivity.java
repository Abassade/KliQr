package com.example.kliqr.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kliqr.R;
import com.example.kliqr.fragments.AccountsFragment;
import com.example.kliqr.fragments.BillsFragment;
import com.example.kliqr.fragments.OverviewFragment;
import com.example.kliqr.fragments.TransactionFragment;
import com.example.kliqr.utils.BottomNavigationViewBehaviour;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class BaseActivity extends AppCompatActivity {

    long back_pressed=0;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = getSupportActionBar();
        // Inflate the overview fragment from the app lunch
        setUpFragment(new OverviewFragment());
        toolbar.setTitle("Overview");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setItemHorizontalTranslationEnabled(false);


        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehaviour());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()) {
                    case R.id.overview:
                        toolbar.setTitle("Overview");
                        fragment = new OverviewFragment();
                        break;
                    case R.id.bank:
                        toolbar.setTitle("Bank Account");
                        fragment = new AccountsFragment();
                        break;
                    case R.id.transaction:
                        toolbar.setTitle("Transaction");
                        fragment = new TransactionFragment();
                        break;
                    case R.id.bills:
                        toolbar.setTitle("Bills");
                        fragment = new BillsFragment();
                        break;
                }
                setUpFragment(fragment);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
        {
            Toast.makeText(getBaseContext(), "Double tap to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }

    public void setUpFragment(Fragment fragment){
        if (fragment!=null){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.rootview, fragment);
            transaction.commit();
        }
    }


}
