package com.cn.tink.simpledemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    public List<ServerData> data;


    public MyFragmentPagerAdapter(FragmentManager fm, String[] titles, List<ServerData> data) {
        super(fm);
        this.titles = titles;
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(data);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
