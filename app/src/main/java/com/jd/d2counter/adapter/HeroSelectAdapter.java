package com.jd.d2counter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.jd.d2counter.R;
import com.jd.d2counter.activities.HomeActivity;
import com.jd.d2counter.objects.Hero;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HeroSelectAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Hero> mHeroesList;
    private OnHeroClickListener mListener;

    public HeroSelectAdapter(Context context, List<Hero> heroesList, OnHeroClickListener listener) {
        if (context == null) return;
        mContext = context;
        mListener = listener;
        mHeroesList = heroesList;
        mInflater = LayoutInflater.from(context);

        if (HomeActivity.mTeamPickList != null && HomeActivity.mTeamPickList.size() != 0) {
            for (int i = 0; i < mHeroesList.size(); i++) {
                for (int j = 0; j < HomeActivity.mTeamPickList.size(); j++) {
                    if (mHeroesList.get(i).getId() == HomeActivity.mTeamPickList.get(j).getId()) {
                        mHeroesList.get(i).setPicked(true);
                    }
                }
            }
        }

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
            holder.pickedMask = (ImageView) convertView.findViewById(R.id.image_mask);
            holder.image = (ImageView) convertView.findViewById(R.id.item_hero_selection_image);
            holder.button = (Button) convertView.findViewById(R.id.item_hero_selection_button);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.pickedMask.setVisibility(mHeroesList.get(position).isPicked() ? View.VISIBLE: View.INVISIBLE);
        holder.button.setOnClickListener(new HeroListener(mHeroesList.get(position)));
        Picasso.with(mContext).load((int) mHeroesList.get(position).getImage()).placeholder(R.drawable.placeholder).into(holder.image);

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        Button button;
        ImageView pickedMask;
    }

    private class HeroListener implements View.OnClickListener {
        Hero hero;

        public HeroListener(Hero hero) {
            this.hero = hero;
        }

        @Override
        public void onClick(View view) {
            mListener.onHeroClick(hero);
        }
    }

    public interface OnHeroClickListener {
        void onHeroClick(Hero hero);
    }
}
