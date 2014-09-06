package com.jd.d2counter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jd.d2counter.R;
import com.jd.d2counter.objects.Hero;

import java.util.List;

public class HeroListAdapter extends BaseAdapter {

    boolean isBig;
    Context mContext;
    List<Hero> mList;
    LayoutInflater mLayoutInflater;

    public HeroListAdapter(Context context, List<Hero> list, boolean big) {
        isBig = big;
        mList = list;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
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
        ViewHolder holder = new ViewHolder();
        if (view == null) {
            view = mLayoutInflater.inflate(isBig ? R.layout.item_hero_big : R.layout.item_hero_small, viewGroup, false);
            holder.content = view.findViewById(R.id.item_hero_content);
            holder.image = (ImageView) view.findViewById(R.id.item_hero_image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag(position);
        }

        Hero hero = (Hero) getItem(position);

        return view;
    }

    private static class ViewHolder {
        private View content;
        private ImageView image;
    }

}
