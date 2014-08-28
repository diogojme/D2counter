package com.jd.d2counter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.jd.d2counter.R;
import com.jd.d2counter.adapter.HeroListAdapter;
import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends ActionBarActivity implements View.OnClickListener {

    private ViewHolder mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_my);

        mHolder = new ViewHolder();
        mHolder.teamPick01 = (ImageView) findViewById(R.id.team_pick_01);

        mHolder.teamPick01.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == mHolder.teamPick01) {
            Intent intent = new Intent(MyActivity.this, HeroSelectActivity.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder {
        private ImageView teamPick01;
    }
}
