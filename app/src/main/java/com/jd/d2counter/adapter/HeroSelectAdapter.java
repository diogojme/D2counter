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

    Context mContext;
    List<Integer> mList;
    LayoutInflater mLayoutInflater;

    public HeroSelectAdapter(Context context, List<Integer> list) {
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
            view = mLayoutInflater.inflate(R.layout.item_hero_big, viewGroup, false);
            holder.content = view.findViewById(R.id.item_hero_content);
            holder.image = (ImageView) view.findViewById(R.id.item_hero_image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag(position);
        }
        int resourceId = mList.get(position);

        Picasso.with(mContext).load(resourceId).into(holder.image);

        return view;
    }

    private static class ViewHolder {
        private View content;
        private ImageView image;
    }
}
