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

        list.add(R.drawable.antimage_vert);
        list.add(R.drawable.bloodseeker_vert);
        list.add(R.drawable.bounty_hunter_vert);
        list.add(R.drawable.broodmother_vert);
        list.add(R.drawable.clinkz_vert);
        list.add(R.drawable.drow_ranger_vert);
        list.add(R.drawable.faceless_void_vert);
        list.add(R.drawable.gyrocopter_vert);
        list.add(R.drawable.juggernaut_vert);
        list.add(R.drawable.lone_druid_vert);
        list.add(R.drawable.luna_vert);
        list.add(R.drawable.medusa_vert);
        list.add(R.drawable.meepo_vert);
        list.add(R.drawable.mirana_vert);
        list.add(R.drawable.morphling_vert);
        list.add(R.drawable.naga_siren_vert);
        list.add(R.drawable.nevermore_vert);
        list.add(R.drawable.nyx_assassin_vert);
        list.add(R.drawable.phantom_assassin_vert);
        list.add(R.drawable.phantom_lancer_vert);
        list.add(R.drawable.razor_vert);
        list.add(R.drawable.riki_vert);
        list.add(R.drawable.slark_vert);
        list.add(R.drawable.sniper_vert);
        list.add(R.drawable.spectre_vert);
        list.add(R.drawable.templar_assassin_vert);
        list.add(R.drawable.terrorblade_vert);
        list.add(R.drawable.troll_warlord_vert);
        list.add(R.drawable.ursa_vert);
        list.add(R.drawable.vengefulspirit_vert);
        list.add(R.drawable.venomancer_vert);
        list.add(R.drawable.viper_vert);
        list.add(R.drawable.weaver_vert);
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
