package com.jd.d2counter.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.jd.d2counter.R;
import com.jd.d2counter.adapter.HeroSelectPagerAdapter;

public class HeroSelectActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        getSupportActionBar().hide();
        setContentView(R.layout.activity_hero_select);
        ViewHolder holder = new ViewHolder();
        holder.pager = (ViewPager) findViewById(R.id.hero_select_pager);
        holder.tabs = (PagerSlidingTabStrip) findViewById(R.id.hero_select_tabs);
        holder.pager.setAdapter(new HeroSelectPagerAdapter(this.getSupportFragmentManager()));
        holder.tabs.setViewPager(holder.pager);
    }

    private static class ViewHolder {
        ViewPager pager;
        PagerSlidingTabStrip tabs;
    }
}
