package com.jd.d2counter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jd.d2counter.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HeroSelectAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Integer> mHeroesList;

    public HeroSelectAdapter(Context context, List<Integer> heroesList) {
        if (context == null) return;
        mContext= context;
        mHeroesList = heroesList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mHeroesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_hero_selection, viewGroup, false);
            assert convertView != null;
            holder.image = (ImageView) convertView.findViewById(R.id.item_hero_selection_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(position != 10 && position != 22){
            Picasso.with(mContext).load(mHeroesList.get(position)).placeholder(R.drawable.placeholder).into( holder.image);
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
    }

}
