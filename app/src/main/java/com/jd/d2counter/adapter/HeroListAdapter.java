package com.jd.d2counter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jd.d2counter.objects.Hero;

import java.util.List;

public class HeroListAdapter extends BaseAdapter {

    Context mContext;
    List<Hero> mList;

    public HeroListAdapter(Context context, List<Hero> list) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {



        return view;
    }
}
