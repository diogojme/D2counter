package com.jd.d2counter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.jd.d2counter.R;


public class HomeActivity extends ActionBarActivity implements View.OnClickListener {

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
            Intent intent = new Intent(HomeActivity.this, HeroSelectActivity.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder {
        private ImageView teamPick01;
    }
}
