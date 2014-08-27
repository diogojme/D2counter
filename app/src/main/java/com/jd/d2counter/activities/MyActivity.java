package com.jd.d2counter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jd.d2counter.R;
import com.jd.d2counter.adapter.HeroListAdapter;
import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ViewHolder mHolder;
    private HeroListAdapter mTeamBanAdapter;
    private HeroListAdapter mTeamPickAdapter;
    private HeroListAdapter mSuggestPickAdapter;
    private HeroListAdapter mEnemyPickAdapter;
    private HeroListAdapter mSuggestBanAdapter;
    private HeroListAdapter mEnemyBanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_my);

        mHolder = new ViewHolder();
//        mHolder.teamBanList = (ListView) findViewById(R.id.main_team_ban);
//        mHolder.teamPickList = (ListView) findViewById(R.id.main_team_pick);
//        mHolder.enemyBanList = (ListView) findViewById(R.id.main_enemy_ban);
//        mHolder.enemyPickList = (ListView) findViewById(R.id.main_enemy_pick);
//        mHolder.suggestBanList = (ListView) findViewById(R.id.main_suggest_ban);
//        mHolder.suggestPickList = (ListView) findViewById(R.id.main_suggest_pick);

//        List<Hero> heroList = new ArrayList<Hero>();
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));
//        heroList.add(new Hero(0, "Abadom", "STR"));


//        mTeamBanAdapter = new HeroListAdapter(this, heroList, false);
//        mTeamPickAdapter = new HeroListAdapter(this, heroList, true);
//        mHolder.teamBanList.setAdapter(mTeamBanAdapter);
//        mHolder.teamPickList.setAdapter(mTeamPickAdapter);
//        mHolder.suggestPickList.setAdapter(mTeamBanAdapter);
//        mHolder.enemyPickList.setAdapter(mTeamPickAdapter);
//        mHolder.suggestBanList.setAdapter(mTeamBanAdapter);
//        mHolder.enemyBanList.setAdapter(mTeamBanAdapter);
//
//        mHolder.teamBanList.setOnItemClickListener(this);
//        mHolder.teamPickList.setOnItemClickListener(this);
//        mHolder.enemyBanList.setOnItemClickListener(this);
//        mHolder.enemyPickList.setOnItemClickListener(this);
//        mHolder.suggestBanList.setOnItemClickListener(this);
//        mHolder.suggestPickList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this, HeroSelectActivity.class));
    }

    private static class ViewHolder {
        private ListView teamBanList;
        private ListView teamPickList;
        private ListView suggestPickList;
        private ListView enemyPickList;
        private ListView suggestBanList;
        private ListView enemyBanList;
    }
}
