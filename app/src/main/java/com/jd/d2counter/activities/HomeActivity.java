package com.jd.d2counter.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.jd.d2counter.R;
import com.jd.d2counter.database.DatabaseHelper;
import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends ActionBarActivity implements View.OnClickListener {

    public static ViewHolder mHolder;
    public static DatabaseHelper mDatabase;
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

        updateView();

    }

    private void updateView() {
        mTeamPickList = mDatabase.getListPicks(Hero.STATUS_MY_PICK);
        mEnemyPickList = mDatabase.getListPicks(Hero.STATUS_ENEMY_PICK);
        mTeamBanList = mDatabase.getListPicks(Hero.STATUS_MY_BAN);
        mEnemyBanList = mDatabase.getListPicks(Hero.STATUS_ENEMY_BAN);
        mSuggestPickList = mDatabase.getListPicks(Hero.STATUS_NOTHING);
        mSuggestBanList = mDatabase.getListPicks(Hero.STATUS_NOTHING);

        if (mTeamPickList.size() > 0) {
            for (int i = 0; i < mTeamPickList.size(); i++) {
                switch (mTeamPickList.get(i).getOrder()) {
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
        if (mEnemyPickList.size() > 0) {
            for (int i = 0; i < mEnemyPickList.size(); i++) {
                switch (mEnemyPickList.get(i).getOrder()) {
                    case 0:
                        mHolder.enemyPick01.setImageResource((int) mEnemyPickList.get(i).getImage());
                        break;
                    case 1:
                        mHolder.enemyPick02.setImageResource((int) mEnemyPickList.get(i).getImage());
                        break;
                    case 2:
                        mHolder.enemyPick03.setImageResource((int) mEnemyPickList.get(i).getImage());
                        break;
                    case 3:
                        mHolder.enemyPick04.setImageResource((int) mEnemyPickList.get(i).getImage());
                        break;
                    case 4:
                        mHolder.enemyPick05.setImageResource((int) mEnemyPickList.get(i).getImage());
                        break;
                }
            }
        }
        if (mTeamBanList.size() > 0) {
            for (int i = 0; i < mTeamBanList.size(); i++) {
                switch (mTeamBanList.get(i).getOrder()) {
                    case 0:
                        mHolder.teamBan01.setImageResource((int) mTeamBanList.get(i).getImage());
                        break;
                    case 1:
                        mHolder.teamBan02.setImageResource((int) mTeamBanList.get(i).getImage());
                        break;
                    case 2:
                        mHolder.teamBan03.setImageResource((int) mTeamBanList.get(i).getImage());
                        break;
                    case 3:
                        mHolder.teamBan04.setImageResource((int) mTeamBanList.get(i).getImage());
                        break;
                    case 4:
                        mHolder.teamBan05.setImageResource((int) mTeamBanList.get(i).getImage());
                        break;
                }
            }
        }
        if (mEnemyBanList.size() > 0) {
            for (int i = 0; i < mEnemyBanList.size(); i++) {
                switch (mEnemyBanList.get(i).getOrder()) {
                    case 0:
                        mHolder.enemyBan01.setImageResource((int) mEnemyBanList.get(i).getImage());
                        break;
                    case 1:
                        mHolder.enemyBan02.setImageResource((int) mEnemyBanList.get(i).getImage());
                        break;
                    case 2:
                        mHolder.enemyBan03.setImageResource((int) mEnemyBanList.get(i).getImage());
                        break;
                    case 3:
                        mHolder.enemyBan04.setImageResource((int) mEnemyBanList.get(i).getImage());
                        break;
                    case 4:
                        mHolder.enemyBan05.setImageResource((int) mEnemyBanList.get(i).getImage());
                        break;
                }
            }
        }
        if (mSuggestPickList.size() > 0) {
            for (int i = 0; i < mSuggestPickList.size(); i++) {
                switch (i) {
                    case 0:
                        mHolder.suggestPick01.setImageResource((int) mSuggestPickList.get(i).getImage());
                        break;
                    case 1:
                        mHolder.suggestPick02.setImageResource((int) mSuggestPickList.get(i).getImage());
                        break;
                    case 2:
                        mHolder.suggestPick03.setImageResource((int) mSuggestPickList.get(i).getImage());
                        break;
                    case 3:
                        mHolder.suggestPick04.setImageResource((int) mSuggestPickList.get(i).getImage());
                        break;
                    case 4:
                        mHolder.suggestPick05.setImageResource((int) mSuggestPickList.get(i).getImage());
                        break;
                }
            }
        }
        if (mSuggestBanList.size() > 0) {
            for (int i = 0; i < mSuggestBanList.size(); i++) {
                switch (i) {
                    case 0:
                        mHolder.suggestBan01.setImageResource((int) mSuggestBanList.get(i).getImage());
                        break;
                    case 1:
                        mHolder.suggestBan02.setImageResource((int) mSuggestBanList.get(i).getImage());
                        break;
                    case 2:
                        mHolder.suggestBan03.setImageResource((int) mSuggestBanList.get(i).getImage());
                        break;
                    case 3:
                        mHolder.suggestBan04.setImageResource((int) mSuggestBanList.get(i).getImage());
                        break;
                    case 4:
                        mHolder.suggestBan05.setImageResource((int) mSuggestBanList.get(i).getImage());
                        break;
                }
            }
        }
    }

    private void initData() {
        mDatabase = DatabaseHelper.with(this);
        mDatabase.open();
        new LoadDatabase().execute();
        mTeamBanList = new ArrayList<Hero>();
        mEnemyBanList = new ArrayList<Hero>();
        mTeamPickList = new ArrayList<Hero>();
        mEnemyPickList = new ArrayList<Hero>();
        mSuggestBanList = new ArrayList<Hero>();
    }

    private void initView() {
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

    private class LoadDatabase extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setLoading(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDatabase.insertHero();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setLoading(View.GONE);


        }
    }

    private void setLoading(int visibility) {
        mHolder.loading.setVisibility(visibility);
    }

    @Override
    public void onClick(View view) {
        if (view == mHolder.teamPick01) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_PICK).putExtra(Hero.EXTRA_ORDER, 0));
        } else if (view == mHolder.teamPick02) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_PICK).putExtra(Hero.EXTRA_ORDER, 1));
        } else if (view == mHolder.teamPick03) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_PICK).putExtra(Hero.EXTRA_ORDER, 2));
        } else if (view == mHolder.teamPick04) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_PICK).putExtra(Hero.EXTRA_ORDER, 3));
        } else if (view == mHolder.teamPick05) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_PICK).putExtra(Hero.EXTRA_ORDER, 4));
        } else if (view == mHolder.enemyPick01) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_PICK).putExtra(Hero.EXTRA_ORDER, 0));
        } else if (view == mHolder.enemyPick02) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_PICK).putExtra(Hero.EXTRA_ORDER, 1));
        } else if (view == mHolder.enemyPick03) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_PICK).putExtra(Hero.EXTRA_ORDER, 2));
        } else if (view == mHolder.enemyPick04) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_PICK).putExtra(Hero.EXTRA_ORDER, 3));
        } else if (view == mHolder.enemyPick05) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_PICK).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_PICK).putExtra(Hero.EXTRA_ORDER, 4));
        } else if (view == mHolder.teamBan01) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_BAN).putExtra(Hero.EXTRA_ORDER, 0));
        } else if (view == mHolder.teamBan02) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_BAN).putExtra(Hero.EXTRA_ORDER, 1));
        } else if (view == mHolder.teamBan03) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_BAN).putExtra(Hero.EXTRA_ORDER, 2));
        } else if (view == mHolder.teamBan04) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_BAN).putExtra(Hero.EXTRA_ORDER, 3));
        } else if (view == mHolder.teamBan05) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_TEAM_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_MY_BAN).putExtra(Hero.EXTRA_ORDER, 4));
        } else if (view == mHolder.enemyBan01) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_BAN).putExtra(Hero.EXTRA_ORDER, 0));
        } else if (view == mHolder.enemyBan02) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_BAN).putExtra(Hero.EXTRA_ORDER, 1));
        } else if (view == mHolder.enemyBan03) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_BAN).putExtra(Hero.EXTRA_ORDER, 2));
        } else if (view == mHolder.enemyBan04) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_BAN).putExtra(Hero.EXTRA_ORDER, 3));
        } else if (view == mHolder.enemyBan05) {
            startActivity(new Intent(this, HeroSelectActivity.class).putExtra(LIST_SELECTION, LIST_ENEMY_BAN).putExtra(Hero.EXTRA_STATUS_NAME, Hero.STATUS_ENEMY_BAN).putExtra(Hero.EXTRA_ORDER, 4));
        } else if (view == mHolder.suggestPick01) {
            addSuggestPick(0);
        } else if (view == mHolder.suggestPick02) {
            addSuggestPick(1);
        } else if (view == mHolder.suggestPick03) {
            addSuggestPick(2);
        } else if (view == mHolder.suggestPick04) {
            addSuggestPick(3);
        } else if (view == mHolder.suggestPick05) {
            addSuggestPick(4);
        } else if (view == mHolder.suggestBan01) {
            addSuggestBan(0);
        } else if (view == mHolder.suggestBan02) {
            addSuggestBan(1);
        } else if (view == mHolder.suggestBan03) {
            addSuggestBan(2);
        } else if (view == mHolder.suggestBan04) {
            addSuggestBan(3);
        } else if (view == mHolder.suggestBan05) {
            addSuggestBan(4);
        }
    }

    private void addSuggestPick(int position) {
        if (mTeamPickList.size() < 5) {
            mTeamPickList.add(mSuggestPickList.get(position));
            int index = mTeamPickList.indexOf(mSuggestPickList.get(position));
            mDatabase.updateHeroStatus(mSuggestPickList.get(position).getId(), Hero.STATUS_MY_PICK, index);
            updateView();
        }
    }

    private void addSuggestBan(int position) {
        if (mTeamBanList.size() < 5) {
            mTeamBanList.add(mSuggestBanList.get(position));
            int index = mTeamBanList.indexOf(mSuggestBanList.get(position));
            mDatabase.updateHeroStatus(mSuggestBanList.get(position).getId(), Hero.STATUS_MY_BAN, index);
            updateView();
        }
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

    public static final int LIST_TEAM_PICK = 1;
    public static final int LIST_ENEMY_PICK = 2;
    public static final int LIST_TEAM_BAN = 3;
    public static final int LIST_ENEMY_BAN = 4;
    public static final String LIST_SELECTION = "listSelection";
}
