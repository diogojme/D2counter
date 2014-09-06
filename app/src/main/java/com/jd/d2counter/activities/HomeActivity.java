package com.jd.d2counter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.jd.d2counter.R;
import com.jd.d2counter.database.DatabaseHelper;
import com.jd.d2counter.fragments.StrenghtFragment;
import com.jd.d2counter.objects.Hero;

import java.util.List;


public class HomeActivity extends ActionBarActivity implements View.OnClickListener {

    private ViewHolder mHolder;
    private DatabaseHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {
        mDatabase = DatabaseHelper.with(this);
        mDatabase.open();
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

    private void updateListWithExtras(Intent data) {
        Bundle extras = data.getExtras();

        if (extras != null) {
            Hero selectedHero = extras.getParcelable("hero");
            mHolder.teamPick01.setImageResource((int) selectedHero.getImage()); //TODO mudar a imagem do hero para INT
            List<Hero> listCounter = mDatabase.getSuggestedPick(selectedHero.getId());
            if (!listCounter.isEmpty()) {
                mHolder.suggestPick01.setImageResource((int) listCounter.get(0).getImage());
                mHolder.suggestPick02.setImageResource((int) listCounter.get(1).getImage());
                mHolder.suggestPick03.setImageResource((int) listCounter.get(2).getImage());
                mHolder.suggestPick04.setImageResource((int) listCounter.get(3).getImage());
                mHolder.suggestPick05.setImageResource((int) listCounter.get(4).getImage());
            }
        }
    }

    private void setLoading(int visibility) {
        mHolder.loading.setVisibility(visibility);
    }

    @Override
    public void onClick(View view) {
        if (view == mHolder.teamPick01) {
            Intent intent = new Intent(HomeActivity.this, HeroSelectActivity.class);
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == StrenghtFragment.RESULT_HERO_SELECTED) {
            updateListWithExtras(data);
        }
    }

    private static class ViewHolder {
        View loading;

        ImageView teamPick01;
        ImageView teamPick02;
        ImageView teamPick03;
        ImageView teamPick04;
        ImageView teamPick05;

        ImageView enemyPick01;
        ImageView enemyPick02;
        ImageView enemyPick03;
        ImageView enemyPick04;
        ImageView enemyPick05;

        ImageView teamBan01;
        ImageView teamBan02;
        ImageView teamBan03;
        ImageView teamBan04;
        ImageView teamBan05;

        ImageView enemyBan01;
        ImageView enemyBan02;
        ImageView enemyBan03;
        ImageView enemyBan04;
        ImageView enemyBan05;

        ImageView suggestPick01;
        ImageView suggestPick02;
        ImageView suggestPick03;
        ImageView suggestPick04;
        ImageView suggestPick05;

        ImageView suggestBan01;
        ImageView suggestBan02;
        ImageView suggestBan03;
        ImageView suggestBan04;
        ImageView suggestBan05;
    }
}
