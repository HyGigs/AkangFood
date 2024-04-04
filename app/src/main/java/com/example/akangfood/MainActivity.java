package com.example.akangfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.akangfood.Fragments.FavoriteFragment;
import com.example.akangfood.Fragments.MakananFragment;
import com.example.akangfood.Fragments.MinumanFragment;
import com.example.akangfood.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView tvNameUser, tvEmailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        drawerLayout = binding.drawerLayout;
        navigationView = binding.navView;
        toolbar = binding.toolbar;

        setSupportActionBar(toolbar);

        // Get reference to TextViews in header layout
        tvNameUser = navigationView.getHeaderView(0).findViewById(R.id.tvNameUser);
        tvEmailUser = navigationView.getHeaderView(0).findViewById(R.id.tvEmailUser);

        // Retrieve name and email from intent extras
        Intent intent = getIntent();
        String name = intent.getStringExtra("nameUser");
        String email = intent.getStringExtra("emailUser");

        // Update TextViews in header layout
        tvNameUser.setText(name);
        tvEmailUser.setText(email);

        // Setup navigation drawer
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Initialize with default fragment
        replaceFragment(new MakananFragment());
        navigationView.setCheckedItem(R.id.menu_makanan);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_makanan) {
            navigationView.setCheckedItem(R.id.menu_makanan);
            replaceFragment(new MakananFragment());
        } else if (itemId == R.id.menu_minuman) {
            navigationView.setCheckedItem(R.id.menu_minuman);
            replaceFragment(new MinumanFragment());
        } else if (itemId == R.id.menu_favorite) {
            navigationView.setCheckedItem(R.id.menu_favorite);
            replaceFragment(new FavoriteFragment());
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}
