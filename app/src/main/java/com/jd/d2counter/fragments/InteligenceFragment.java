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


public class InteligenceFragment extends Fragment {

    List<Integer> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inteligence, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        list = new ArrayList<Integer>();

        list.add(R.drawable.ancient_apparition_vert);
        list.add(R.drawable.bane_vert);
        list.add(R.drawable.batrider_vert);
        list.add(R.drawable.chen_vert);
        list.add(R.drawable.crystal_maiden_vert);
        list.add(R.drawable.dark_seer_vert);
        list.add(R.drawable.dazzle_vert);
        list.add(R.drawable.death_prophet_vert);
        list.add(R.drawable.disruptor_vert);
        list.add(R.drawable.enchantress_vert);
        list.add(R.drawable.enigma_vert);
        list.add(R.drawable.furion_vert);
        list.add(R.drawable.invoker_vert);
        list.add(R.drawable.jakiro_vert);
        list.add(R.drawable.keeper_of_the_light_vert);
        list.add(R.drawable.leshrac_vert);
        list.add(R.drawable.lich_vert);
        list.add(R.drawable.lina_vert);
        list.add(R.drawable.lion_vert);
        list.add(R.drawable.necrolyte_vert);
        list.add(R.drawable.obsidian_destroyer_vert);
        list.add(R.drawable.ogre_magi_vert);
        list.add(R.drawable.puck_vert);
        list.add(R.drawable.pugna_vert);
        list.add(R.drawable.queenofpain_vert);
        list.add(R.drawable.rubick_vert);
        list.add(R.drawable.shadow_demon_vert);
        list.add(R.drawable.shadow_shaman_vert);
        list.add(R.drawable.silencer_vert);
        list.add(R.drawable.skywrath_mage_vert);
        list.add(R.drawable.storm_spirit_vert);
        list.add(R.drawable.tinker_vert);
        list.add(R.drawable.visage_vert);
        list.add(R.drawable.warlock_vert);
        list.add(R.drawable.windrunner_vert);
        list.add(R.drawable.witch_doctor_vert);
        list.add(R.drawable.zuus_vert);
    }

    private void initView(View view) {
        ViewHolder holder = new ViewHolder();
        holder.grid = (GridView) view.findViewById(R.id.intelligence_grid);
        HeroSelectAdapter adapter = new HeroSelectAdapter(getActivity(), list);
        holder.grid.setAdapter(adapter);
    }

    private static class ViewHolder {
        GridView grid;
    }
}
