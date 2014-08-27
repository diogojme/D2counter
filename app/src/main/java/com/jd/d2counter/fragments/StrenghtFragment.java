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


public class StrenghtFragment extends Fragment {

    List<Integer> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_strenght, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        list = new ArrayList<Integer>();

        list.add(R.drawable.abaddon_vert);
        list.add(R.drawable.alchemist_vert);
        list.add(R.drawable.axe_vert);
        list.add(R.drawable.beastmaster_vert);
        list.add(R.drawable.brewmaster_vert);
        list.add(R.drawable.bristleback_vert);
        list.add(R.drawable.centaur_vert);
        list.add(R.drawable.chaos_knight_vert);
        list.add(R.drawable.doom_bringer_vert);
        list.add(R.drawable.dragon_knight_vert);
        list.add(R.drawable.earth_spirit_vert);
        list.add(R.drawable.earthshaker_vert);
        list.add(R.drawable.elder_titan_vert);
        list.add(R.drawable.ember_spirit_vert);
        list.add(R.drawable.huskar_vert);
        list.add(R.drawable.kunkka_vert);
        list.add(R.drawable.legion_commander_vert);
        list.add(R.drawable.life_stealer_vert);
        list.add(R.drawable.lycan_vert);
        list.add(R.drawable.magnataur_vert);
        list.add(R.drawable.night_stalker_vert);
        list.add(R.drawable.omniknight_vert);
        list.add(R.drawable.phoenix_vert);
        list.add(R.drawable.pudge_vert);
        list.add(R.drawable.rattletrap_vert);
        list.add(R.drawable.sand_king_vert);
        list.add(R.drawable.shredder_vert);
        list.add(R.drawable.skeleton_king_vert);
        list.add(R.drawable.slardar_vert);
        list.add(R.drawable.spirit_breaker_vert);
        list.add(R.drawable.sven_vert);
        list.add(R.drawable.tidehunter_vert);
        list.add(R.drawable.tiny_vert);
        list.add(R.drawable.treant_vert);
        list.add(R.drawable.tusk_vert);
        list.add(R.drawable.undying_vert);
        list.add(R.drawable.wisp_vert);
    }

    private void initView(View view) {
        ViewHolder holder = new ViewHolder();
        holder.grid = (GridView) view.findViewById(R.id.strength_grid);
        HeroSelectAdapter adapter = new HeroSelectAdapter(getActivity(), list);
        holder.grid.setAdapter(adapter);
    }

    private static class ViewHolder {
        GridView grid;
    }
}
