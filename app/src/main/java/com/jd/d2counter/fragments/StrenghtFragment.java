package com.jd.d2counter.fragments;

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


public class StrenghtFragment extends Fragment implements HeroSelectAdapter.OnHeroClickListener{

    List<Hero> list;
    ViewHolder mHolder;
    DatabaseHelper mDatabase;
    HeroSelectAdapter mAdapter;

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
        if (!containsInList(HomeActivity.mTeamPickList, hero)) {
            HomeActivity.mTeamPickList.add(hero);
            getActivity().finish();
        }
    }

    private boolean containsInList(List<Hero> list, Hero hero) {
        for (Hero aList : list) {
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
