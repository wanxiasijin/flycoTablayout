package com.example.demo;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CommonTabLayout mTabLayout;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ExchangeFragment exchangeFragment;
    private DuplicateFragment duplicateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (CommonTabLayout) findViewById(R.id.commontablayout);
        initFragment();
        initData();
    }
    private void initFragment() {
        if(duplicateFragment==null){
            duplicateFragment=new DuplicateFragment();
        }
        if (exchangeFragment==null){
            exchangeFragment=new ExchangeFragment();
        }
        mFragments.clear();
        mTabEntities.clear();
        mFragments.add(duplicateFragment);
        mFragments.add(exchangeFragment);

        mTabEntities.add(new TabEntity("电子联单", 0, 0));
        mTabEntities.add(new TabEntity("土方交换", 0, 0));

    }
    private void initData() {
        mTabLayout.setIndicatorWidth(10);
        mTabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
    }
}
