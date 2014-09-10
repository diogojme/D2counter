package com.jd.d2counter.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jd.d2counter.R;
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
            holder.status = (TextView) convertView.findViewById(R.id.item_hero_selection_text_status);
            holder.image = (ImageView) convertView.findViewById(R.id.item_hero_selection_image);
            holder.button = (Button) convertView.findViewById(R.id.item_hero_selection_button);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Hero hero = mHeroesList.get(position);

        if(hero.getStatus() == Hero.STATUS_ENEMY_PICK){
            holder.status.setText("Picked");
            holder.status.setTextColor(Color.parseColor("#259b24"));
        }else if(hero.getStatus() == Hero.STATUS_MY_PICK){
            holder.status.setText("Picked");
            holder.status.setTextColor(Color.parseColor("#259b24"));
        }else if(hero.getStatus() == Hero.STATUS_MY_BAN){
            holder.status.setText("Ban");
            holder.status.setTextColor(Color.parseColor("#b52525"));
        }else if(hero.getStatus() == Hero.STATUS_ENEMY_BAN){
            holder.status.setText("Ban");
            holder.status.setTextColor(Color.parseColor("#b52525"));
        }else if(hero.getStatus() == Hero.STATUS_SUGGESTION_BAN){
            holder.status.setText("Suggested to ban");
            holder.status.setTextColor(Color.parseColor("#266666"));
        }else if(hero.getStatus() == Hero.STATUS_SUGGESTION_PICK){
            holder.status.setText("Suggested to pick");
            holder.status.setTextColor(Color.parseColor("#232324"));
        }

        holder.button.setOnClickListener(new HeroListener(hero));
        Picasso.with(mContext).load((int) hero.getImage()).placeholder(R.drawable.placeholder).into(holder.image);

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        Button button;
        TextView status;
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
