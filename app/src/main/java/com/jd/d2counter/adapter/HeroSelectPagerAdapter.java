package com.jd.d2counter.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jd.d2counter.fragments.AgilityFragment;
import com.jd.d2counter.fragments.InteligenceFragment;
import com.jd.d2counter.fragments.StrenghtFragment;

public class HeroSelectPagerAdapter extends FragmentPagerAdapter {

    private static final String[] TITLES = {"FORÇA", "INTELIGÊNCIA", "AGILIDADE"};

    public HeroSelectPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new StrenghtFragment();
                break;
            case 1:
                fragment = new InteligenceFragment();
                break;
            case 2:
                fragment = new AgilityFragment();
                break;
            default:
                fragment = new StrenghtFragment();
                break;
        }
        return fragment;
    }
}