package com.example.jayantachowdhury.myapplication4.ViewPagerActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.jayantachowdhury.myapplication4.Fragment.DontsFragment;
import com.example.jayantachowdhury.myapplication4.R;
import com.example.jayantachowdhury.myapplication4.ViewPagerAdapter;


public class TabWithIconActivity extends AppCompatActivity {

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    ViewPagerAdapter adapter;

    //Fragments

    com.example.jayantachowdhury.myapplication4.Fragment.DosFragment dosFragment;
    DontsFragment dontsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_without_icon);
        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        setupViewPager(viewPager);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }




    private void setupViewPager(ViewPager viewPager)
    {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        dosFragment=new com.example.jayantachowdhury.myapplication4.Fragment.DosFragment();
        dontsFragment=new DontsFragment();
        adapter.addFragment(dosFragment,"DO'S");
        adapter.addFragment(dontsFragment,"DONT'S");
        viewPager.setAdapter(adapter);
    }

}
