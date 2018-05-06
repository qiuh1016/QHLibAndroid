package com.qiuhong.qhlibrary.View;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
    private QHTabBar tabBar;
    private QHSectionsPagerAdapter sectionsPagerAdapter;

    //按2次返回退出
    private boolean enableTwiceBackToExit = true;
    private boolean hasPressedBackOnce = false;
    private Toast backToast;

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

    protected void setCurrentFragment(int i) {
        this.viewPager.setCurrentItem(i);
    }

    private void initViews(List<Fragment> fragments) {
        tabBar = findViewById(R.id.tab_bar);
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
                    tabBar.setFocus(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        } else {
            viewPager.setScanScroll(false);
        }


        tabBar.setTabTextAndImage(
                initTabText(),
                initTabNormalImages(),
                initTabFocusImages()
        );
        tabBar.setClickCallback(new QHTabBar.TabBarClickCallback() {
            @Override
            public void onTabClick(int tabNumber) {
                viewPager.setCurrentItem(tabNumber, false);
            }
        });
    }

    public QHTabBar getTabBar() {
        return this.tabBar;
    }

    public QHNoScrollViewPager getViewPager() {
        return viewPager;
    }

    public QHSectionsPagerAdapter getSectionsPagerAdapter() {
        return sectionsPagerAdapter;
    }

    public void setTwiceBackExitEnable(boolean enable) {
        this.enableTwiceBackToExit = enable;
    }

    public void onBackPressed() {
        if (enableTwiceBackToExit) {
            if (!hasPressedBackOnce) {
                backToast = Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT);
                backToast.show();
                hasPressedBackOnce = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hasPressedBackOnce = false;
                    }
                },2500);
            } else {
                backToast.cancel();
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}