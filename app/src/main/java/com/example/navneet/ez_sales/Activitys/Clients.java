package com.example.navneet.ez_sales.Activitys;

import android.app.Activity;
import android.support.design.widget.TabLayout;



import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.example.navneet.ez_sales.Adapters.SimpleFragmentPagerAdapter;
import com.example.navneet.ez_sales.R;


public class Clients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        getSupportActionBar().hide();



        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager()));


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        // Give the PagerSlidingTabStrip the ViewPager
       /* PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.getShouldExpand();
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);*/
    }

}
