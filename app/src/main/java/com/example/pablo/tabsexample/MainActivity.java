package com.example.pablo.tabsexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.pablo.tabsexample.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preference = getSharedPreferences(getString(R.string.db_name), MODE_PRIVATE);

        String username = preference.getString("username", "");

        if(username.isEmpty()){
            //Usuarion no logueado
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Username: "+username, Toast.LENGTH_LONG).show();

            if (getSupportActionBar() != null) {
                getSupportActionBar().setElevation(0);
            }
            tabLayout = (TabLayout)findViewById(R.id.tab_layout);

            tabLayout.addTab(tabLayout.newTab().setText("Posts"));
            tabLayout.addTab(tabLayout.newTab().setText("Users"));

            viewPager = (ViewPager)findViewById(R.id.view_pager);
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);

            viewPager.addOnPageChangeListener(
                    new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {  //enter y saldra todo el codigo de abajo
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }

    }
}
