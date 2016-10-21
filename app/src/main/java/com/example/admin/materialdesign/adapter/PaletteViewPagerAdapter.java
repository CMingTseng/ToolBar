package com.example.admin.materialdesign.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.materialdesign.fragment.PaletteFragment;

/**
 * Author:    Diamond_Lin
 * Version    V1.0
 * Date:      16/10/9 下午5:29
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 16/10/9      Diamond_Lin            1.0                    1.0
 * Why & What is modified:
 */
public class PaletteViewPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"tab1", "tab2", "tab3", "tab4"};

    public PaletteViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PaletteFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}