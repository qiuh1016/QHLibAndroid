package com.qiuhong.qhlibrary.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.qiuhong.qhlibrary.QHTabBar.QHTabBar;
import com.qiuhong.qhlibrary.QHViewPager.QHNoScrollViewPager;
import com.qiuhong.qhlibrary.QHViewPager.QHSectionsPagerAdapter;
import com.qiuhong.qhlibrary.R;

import java.util.List;

/**
 * Created by qiuhong on 27/04/2018.
 */

abstract public class QHTabBarActivity extends AppCompatActivity {

    private QHNoScrollViewPager viewPager;
    private QHTabBar tab_Bar;
    private QHSectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar);

        initViews(initFragments());
    }

    protected abstract List<Fragment> initFragments();
    protected abstract String[] initTabText();
    protected abstract int[] initTabNormalImages();
    protected abstract int[] initTabFocusImages();

    protected boolean setScrollEnable() {
        return false;
    }

    private void initViews(List<Fragment> fragments) {
        tab_Bar = findViewById(R.id.tab_bar);
        viewPager = findViewById(R.id.view_pager);

        sectionsPagerAdapter = new QHSectionsPagerAdapter(getSupportFragmentManager(), fragments);

        viewPager.setAdapter(sectionsPagerAdapter);
        if (setScrollEnable()) {
            viewPager.setScanScroll(true);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    tab_Bar.setFocus(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        } else {
            viewPager.setScanScroll(false);
        }


        tab_Bar.setTabTextAndImage(
                initTabText(),
                initTabNormalImages(),
                initTabFocusImages()
        );
        tab_Bar.setClickCallback(new QHTabBar.TabBarClickCallback() {
            @Override
            public void onTabClick(int tabNumber) {
                viewPager.setCurrentItem(tabNumber, false);
            }
        });
    }
}