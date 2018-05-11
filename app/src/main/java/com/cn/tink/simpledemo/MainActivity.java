package com.cn.tink.simpledemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager pager;
    private String[] titles = new String[]{"CITY GUIDE", "SHOP", "EAT"};
    private List<ServerData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        this.pager = (ViewPager) findViewById(R.id.pager);
        this.tab = (TabLayout) findViewById(R.id.tab);
        //get data
        String json = Utils.getServerData("data.json", getApplicationContext());
        Gson gson = new Gson();
        list = gson.fromJson(json, new TypeToken<List<ServerData>>() {
        }.getType());
        pager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), titles, list));
        /*Tab与ViewPager绑定*/
        tab.setupWithViewPager(pager);
    }
}
