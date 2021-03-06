package com.jd.d2counter.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.jd.d2counter.R;
import com.jd.d2counter.activities.HomeActivity;
import com.jd.d2counter.adapter.HeroSelectAdapter;
import com.jd.d2counter.database.DatabaseHelper;
import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;


public class StrenghtFragment extends Fragment implements HeroSelectAdapter.OnHeroClickListener {

    int mIdList;
    List<Hero> list;
    ViewHolder mHolder;
    DatabaseHelper mDatabase;
    HeroSelectAdapter mAdapter;
    int mOrder;
    int mStatus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_strenght, container, false);
        initData();
        initView(view);
        initAdapter();
        return view;
    }

    private void initData() {
        list = new ArrayList<Hero>();
        mDatabase = DatabaseHelper.with(getActivity());
        mDatabase.open();
        Intent intent = getActivity().getIntent();
        mIdList = intent.getIntExtra(HomeActivity.LIST_SELECTION, 0);
        mStatus = intent.getIntExtra(Hero.EXTRA_STATUS_NAME, -1);
        mOrder = intent.getIntExtra(Hero.EXTRA_ORDER, 0);
    }

    private void initView(View view) {
        mHolder = new ViewHolder();
        mHolder.loading = view.findViewById(R.id.loading);
        mHolder.grid = (GridView) view.findViewById(R.id.strength_grid);
    }

    private void initAdapter() {
        new DataTask().execute();
    }

    @Override
    public void onHeroClick(Hero hero) {
        mDatabase.updateHeroStatus(hero.getId(), mStatus, mOrder);

        switch (mIdList) {
            case HomeActivity.LIST_TEAM_PICK:
                if (!containsInList(hero)) {
                    HomeActivity.mTeamPickList.add(hero);
                    getActivity().finish();
                }
                break;
            case HomeActivity.LIST_ENEMY_PICK:
                if (!containsInList(hero)) {
                    HomeActivity.mEnemyPickList.add(hero);
                    getActivity().finish();
                }
                break;
            case HomeActivity.LIST_TEAM_BAN:
                if (!containsInList(hero)) {
                    HomeActivity.mTeamBanList.add(hero);
                    getActivity().finish();
                }
                break;
            case HomeActivity.LIST_ENEMY_BAN:
                if (!containsInList(hero)) {
                    HomeActivity.mEnemyBanList.add(hero);
                    getActivity().finish();
                }
                break;
        }
    }

    private boolean containsInList(Hero hero) {
        for (Hero aList : HomeActivity.mEnemyPickList) {
            if (aList.getId() == hero.getId()) {
                return true;
            }
        }
        for (Hero aList : HomeActivity.mTeamPickList) {
            if (aList.getId() == hero.getId()) {
                return true;
            }
        }
        for (Hero aList : HomeActivity.mEnemyBanList) {
            if (aList.getId() == hero.getId()) {
                return true;
            }
        }
        for (Hero aList : HomeActivity.mTeamBanList) {
            if (aList.getId() == hero.getId()) {
                return true;
            }
        }
        return false;
    }

    private class DataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setLoading(true);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            list = mDatabase.getHeroList(Hero.TYPE_STRENGHT);
            mAdapter = new HeroSelectAdapter(getActivity(), list, StrenghtFragment.this);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mHolder.grid.setAdapter(mAdapter);
            setLoading(false);
        }
    }

    private void setLoading(boolean loading) {
        mHolder.loading.setVisibility(loading ? View.VISIBLE : View.INVISIBLE);
    }

    private static class ViewHolder {
        GridView grid;
        View loading;
    }
}
