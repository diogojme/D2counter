package com.jd.d2counter.utils;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.jd.d2counter.R;

import java.util.ArrayList;
import java.util.List;


public class TabAndroid extends PagerSlidingTabStrip implements ViewPager.OnPageChangeListener {

    private int mTabSelected;
    private List<TextView> mTabList;
    private ViewPager.OnPageChangeListener mListener;

    public TabAndroid(Context context) {
        super(context);
        initTab(context);
    }

    public TabAndroid(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTab(context);
    }

    public TabAndroid(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initTab(context);
    }

    private void initTab(Context context) {
        if (!isInEditMode()) {
            super.setOnPageChangeListener(this);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, displayMetrics));
            setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, displayMetrics));
            setUnderlineHeight(0);
            setIndicatorColor(getResources().getColor(R.color.red));
            setDividerColor(Color.TRANSPARENT);
           // setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"), 0);
            setTextColor(COLOR_NORMAL);
        }
    }

    @Override
    public void setViewPager(ViewPager pager) {
        super.setViewPager(pager);
        mTabList = new ArrayList<TextView>();
        LinearLayout parent = (LinearLayout) getChildAt(0);
        if (parent != null) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                if (child instanceof TextView) {
                    child.setBackgroundColor(Color.TRANSPARENT);
                    mTabList.add((TextView) child);
                }
            }
        }
        mTabList.get(0).setTextColor(COLOR_SELECTED);
        mTabSelected = 0;
    }

    @Override
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        mListener = listener;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mListener != null) {
            mListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
          setIndicatorColor(getResources().getColor(R.color.red));
        } else if (position == 1) {
            setIndicatorColor(getResources().getColor(R.color.blue));
        } else {
            setIndicatorColor(getResources().getColor(R.color.green));
        }

        mTabList.get(mTabSelected).setTextColor(COLOR_NORMAL);
        mTabList.get(position).setTextColor(COLOR_SELECTED);
        mTabSelected = position;
        if (mListener != null) {
            mListener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (mListener != null) {
            mListener.onPageScrollStateChanged(state);
        }
    }

    public static final int COLOR_SELECTED = Color.WHITE;
    public static final int COLOR_NORMAL = Color.parseColor("#99FFFFFF");
}