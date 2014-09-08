package com.jd.d2counter.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.jd.d2counter.R;
import com.jd.d2counter.database.Database;
import com.jd.d2counter.database.DatabaseHelper;
import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HomeActivity extends ActionBarActivity implements View.OnClickListener {

    public static ViewHolder mHolder;
    public static DatabaseHelper mDatabase;
    public static List<Hero> mTestList;
    public static List<Hero> mTeamPickList;
    public static List<Hero> mEnemyPickList;
    public static List<Hero> mTeamBanList;
    public static List<Hero> mEnemyBanList;
    public static List<Hero> mSuggestPickList;
    public static List<Hero> mSuggestBanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mTeamPickList.size() > 0) {
            for (int i = 0; i < mTeamPickList.size(); i++) {
                switch (i) {
                    case 0:
                        mHolder.teamPick01.setImageResource((int) mTeamPickList.get(i).getImage());
                        break;
                    case 1:
                        mHolder.teamPick02.setImageResource((int) mTeamPickList.get(i).getImage());
                        break;
                    case 2:
                        mHolder.teamPick03.setImageResource((int) mTeamPickList.get(i).getImage());
                        break;
                    case 3:
                        mHolder.teamPick04.setImageResource((int) mTeamPickList.get(i).getImage());
                        break;
                    case 4:
                        mHolder.teamPick05.setImageResource((int) mTeamPickList.get(i).getImage());
                        break;
                }
            }
        }
    }

    private void initData(){
        mDatabase = DatabaseHelper.with(this);
        mDatabase.open();
        new LoadDatabase().execute();
        mTestList = new ArrayList<Hero>();
        mTeamPickList = new ArrayList<Hero>();
    }

    private void initView(){
        setContentView(R.layout.activity_home);

        mHolder = new ViewHolder();
        mHolder.loading = findViewById(R.id.loading);
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

    private class LoadDatabase extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setLoading(View.VISIBLE);
            mTestList = new ArrayList<Hero>();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDatabase.insertHero();
//            mDatabase.insertCounter();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setLoading(View.GONE);
            mTestList = mDatabase.getHeroList(Hero.TYPE_STRENGHT);


        }
    }

    private void setLoading(int visibility){
        mHolder.loading.setVisibility(visibility);
    }

    @Override
    public void onClick(View view) {
        if (view == mHolder.teamPick01) {
            startActivity(new Intent(this, HeroSelectActivity.class));
        } else if (view == mHolder.teamPick02) {
            startActivity(new Intent(this, HeroSelectActivity.class));
        } else if (view == mHolder.teamPick03) {
            startActivity(new Intent(this, HeroSelectActivity.class));
        } else if (view == mHolder.teamPick04) {
            startActivity(new Intent(this, HeroSelectActivity.class));
        } else if (view == mHolder.teamPick05) {
            startActivity(new Intent(this, HeroSelectActivity.class));
        } else if (view == mHolder.enemyPick01) {

        } else if (view == mHolder.enemyPick02) {

        } else if (view == mHolder.enemyPick03) {

        } else if (view == mHolder.enemyPick04) {

        } else if (view == mHolder.enemyPick05) {

        } else if (view == mHolder.teamBan01) {

        } else if (view == mHolder.teamBan02) {

        } else if (view == mHolder.teamBan03) {

        } else if (view == mHolder.teamBan04) {

        } else if (view == mHolder.teamBan05) {

        } else if (view == mHolder.enemyBan01) {

        } else if (view == mHolder.enemyBan02) {

        } else if (view == mHolder.enemyBan03) {

        } else if (view == mHolder.enemyBan04) {

        } else if (view == mHolder.enemyBan05) {

        } else if (view == mHolder.suggestPick01) {

        } else if (view == mHolder.suggestPick02) {

        } else if (view == mHolder.suggestPick03) {

        } else if (view == mHolder.suggestPick04) {

        } else if (view == mHolder.suggestPick05) {

        } else if (view == mHolder.suggestBan01) {

        } else if (view == mHolder.suggestBan02) {

        } else if (view == mHolder.suggestBan03) {

        } else if (view == mHolder.suggestBan04) {

        } else if (view == mHolder.suggestBan05) {

        }

//        Intent intent = new Intent(HomeActivity.this, HeroSelectActivity.class);
//        startActivity(intent);
    }

    private static class ViewHolder {
        private View loading;

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
