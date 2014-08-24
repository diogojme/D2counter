package com.jd.d2counter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.jd.d2counter.R;
import com.jd.d2counter.adapter.HeroSelectAdapter;

import java.util.ArrayList;
import java.util.List;


public class AgilityFragment extends Fragment {
    List<Integer> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agility, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        list = new ArrayList<Integer>();
        list.add(R.drawable.abaddon_vert);
        list.add(R.drawable.alchemist_vert);
        list.add(R.drawable.ancient_apparition_vert);

        list.add(R.drawable.ancient_apparition_vert);
        list.add(R.drawable.antimage_vert);
        list.add(R.drawable.axe_vert);
        list.add(R.drawable.batrider_vert);
        list.add(R.drawable.beastmaster_vert);
        list.add(R.drawable.bloodseeker_vert);
        list.add(R.drawable.clinkz_vert);
        list.add(R.drawable.doom_bringer_vert);
        list.add(R.drawable.bristleback_vert);
        list.add(R.drawable.ancient_apparition_vert);
        list.add(R.drawable.earth_spirit_vert);
        list.add(R.drawable.broodmother_vert);
        list.add(R.drawable.chaos_knight_vert);
        list.add(R.drawable.earthshaker_vert);
        list.add(R.drawable.drow_ranger_vert);
        list.add(R.drawable.drow_ranger_vert);
        list.add(R.drawable.furion_vert);
        list.add(R.drawable.enigma_vert);
        list.add(R.drawable.earth_spirit_vert);
        list.add(R.drawable.doom_bringer_vert);
        list.add(R.drawable.bane_vert);
        list.add(R.drawable.keeper_of_the_light_vert);
        list.add(R.drawable.lich_vert);
    }

    private void initView(View view) {
        ViewHolder holder = new ViewHolder();
        holder.grid = (GridView) view.findViewById(R.id.agility_grid);
        HeroSelectAdapter adapter = new HeroSelectAdapter(getActivity(), list);
        holder.grid.setAdapter(adapter);
    }

    private static class ViewHolder {
        GridView grid;
    }
}
