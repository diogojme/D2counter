package com.jd.d2counter.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.jd.d2counter.R;


public class MyActivity extends ActionBarActivity {

    private ViewHolder mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.activity_my);

        mHolder = new ViewHolder();
        mHolder.teamBanList = (ListView) findViewById(R.id.main_team_ban);
        mHolder.teamPickList = (ListView) findViewById(R.id.main_team_pick);
        mHolder.enemyBanList = (ListView) findViewById(R.id.main_enemy_ban);
        mHolder.enemyPickList = (ListView) findViewById(R.id.main_enemy_pick);
        mHolder.suggestBanList = (ListView) findViewById(R.id.main_suggest_ban);
        mHolder.suggestPickList = (ListView) findViewById(R.id.main_suggest_pick);


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
