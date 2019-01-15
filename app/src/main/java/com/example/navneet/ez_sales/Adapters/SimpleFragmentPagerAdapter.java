package com.example.navneet.ez_sales.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.navneet.ez_sales.Activitys.Clients;
import com.example.navneet.ez_sales.Fragments.CheckClientsFragment;
import com.example.navneet.ez_sales.Fragments.MyClientsFragment;
import com.example.navneet.ez_sales.R;

public class SimpleFragmentPagerAdapter  extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "My Clients", "Check Clients" };

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return MyClientsFragment.newInstance(position);
        } else if (position == 1){
            return CheckClientsFragment.newInstance(position);
        }  else {
            return MyClientsFragment.newInstance(position);
        }

     // return MyClientsFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}