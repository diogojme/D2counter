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
        setContentView(R.layout.activity_home);

        mHolder = new ViewHolder();

        mHolder.teamBan01 = (ImageView) findViewById(R.id.team_ban_01);
        mHolder.teamBan02 = (ImageView) findViewById(R.id.team_ban_02);
        mHolder.teamBan03 = (ImageView) findViewById(R.id.team_ban_03);
        mHolder.teamBan04 = (ImageView) findViewById(R.id.team_ban_04);
        mHolder.teamBan05 = (ImageView) findViewById(R.id.team_ban_05);

        mHolder.enemyBan01 = (ImageView) findViewById(R.id.enemy_ban_01);
        mHolder.enemyBan02 = (ImageView) findViewById(R.id.enemy_ban_02);
        mHolder.enemyBan03 = (ImageView) findViewById(R.id.enemy_ban_03);
        mHolder.enemyBan04 = (ImageView) findViewById(R.id.enemy_ban_04);
        mHolder.enemyBan05 = (ImageView) findViewById(R.id.enemy_ban_05);

        mHolder.teamPick01 = (ImageView) findViewById(R.id.team_pick_01);
        mHolder.teamPick02 = (ImageView) findViewById(R.id.team_pick_02);
        mHolder.teamPick03 = (ImageView) findViewById(R.id.team_pick_03);
        mHolder.teamPick04 = (ImageView) findViewById(R.id.team_pick_04);
        mHolder.teamPick05 = (ImageView) findViewById(R.id.team_pick_05);

        mHolder.enemyPick01 = (ImageView) findViewById(R.id.enemy_pick_01);
        mHolder.enemyPick02 = (ImageView) findViewById(R.id.enemy_pick_02);
        mHolder.enemyPick03 = (ImageView) findViewById(R.id.enemy_pick_03);
        mHolder.enemyPick04 = (ImageView) findViewById(R.id.enemy_pick_04);
        mHolder.enemyPick05 = (ImageView) findViewById(R.id.enemy_pick_05);

        mHolder.suggestBan01 = (ImageView) findViewById(R.id.suggest_ban_01);
        mHolder.suggestBan02 = (ImageView) findViewById(R.id.suggest_ban_02);
        mHolder.suggestBan03 = (ImageView) findViewById(R.id.suggest_ban_03);
        mHolder.suggestBan04 = (ImageView) findViewById(R.id.suggest_ban_04);
        mHolder.suggestBan05 = (ImageView) findViewById(R.id.suggest_ban_05);

        mHolder.suggestPick01 = (ImageView) findViewById(R.id.suggest_pick_01);
        mHolder.suggestPick02 = (ImageView) findViewById(R.id.suggest_pick_02);
        mHolder.suggestPick03 = (ImageView) findViewById(R.id.suggest_pick_03);
        mHolder.suggestPick04 = (ImageView) findViewById(R.id.suggest_pick_04);
        mHolder.suggestPick05 = (ImageView) findViewById(R.id.suggest_pick_05);

        mHolder.teamBan01.setOnClickListener(this);
        mHolder.teamBan02.setOnClickListener(this);
        mHolder.teamBan03.setOnClickListener(this);
        mHolder.teamBan04.setOnClickListener(this);
        mHolder.teamBan05.setOnClickListener(this);

        mHolder.enemyBan01.setOnClickListener(this);
        mHolder.enemyBan02.setOnClickListener(this);
        mHolder.enemyBan03.setOnClickListener(this);
        mHolder.enemyBan04.setOnClickListener(this);
        mHolder.enemyBan05.setOnClickListener(this);

        mHolder.teamPick01.setOnClickListener(this);
        mHolder.teamPick02.setOnClickListener(this);
        mHolder.teamPick03.setOnClickListener(this);
        mHolder.teamPick04.setOnClickListener(this);
        mHolder.teamPick05.setOnClickListener(this);

        mHolder.enemyPick01.setOnClickListener(this);
        mHolder.enemyPick02.setOnClickListener(this);
        mHolder.enemyPick03.setOnClickListener(this);
        mHolder.enemyPick04.setOnClickListener(this);
        mHolder.enemyPick05.setOnClickListener(this);

        mHolder.suggestBan01.setOnClickListener(this);
        mHolder.suggestBan02.setOnClickListener(this);
        mHolder.suggestBan03.setOnClickListener(this);
        mHolder.suggestBan04.setOnClickListener(this);
        mHolder.suggestBan05.setOnClickListener(this);

        mHolder.suggestPick01.setOnClickListener(this);
        mHolder.suggestPick02.setOnClickListener(this);
        mHolder.suggestPick03.setOnClickListener(this);
        mHolder.suggestPick04.setOnClickListener(this);
        mHolder.suggestPick05.setOnClickListener(this);

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
        private ImageView teamPick02;
        private ImageView teamPick03;
        private ImageView teamPick04;
        private ImageView teamPick05;

        private ImageView enemyPick01;
        private ImageView enemyPick02;
        private ImageView enemyPick03;
        private ImageView enemyPick04;
        private ImageView enemyPick05;

        private ImageView teamBan01;
        private ImageView teamBan02;
        private ImageView teamBan03;
        private ImageView teamBan04;
        private ImageView teamBan05;

        private ImageView enemyBan01;
        private ImageView enemyBan02;
        private ImageView enemyBan03;
        private ImageView enemyBan04;
        private ImageView enemyBan05;

        private ImageView suggestPick01;
        private ImageView suggestPick02;
        private ImageView suggestPick03;
        private ImageView suggestPick04;
        private ImageView suggestPick05;

        private ImageView suggestBan01;
        private ImageView suggestBan02;
        private ImageView suggestBan03;
        private ImageView suggestBan04;
        private ImageView suggestBan05;
    }
}
