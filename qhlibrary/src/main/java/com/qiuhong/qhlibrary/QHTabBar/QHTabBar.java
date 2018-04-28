package com.qiuhong.qhlibrary.QHTabBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qiuhong.qhlibrary.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuhong on 27/04/2018.
 */

public class QHTabBar extends LinearLayout implements View.OnClickListener {

    private List<TextView> tabTextList = new ArrayList<>();
    private List<ImageView> tabImageList = new ArrayList<>();

    private TabBarClickCallback callback;
    private int[] normalImages;
    private int[] focusImages;
    private View view;

    public QHTabBar(Context context){
        this(context, null);
    }

    public QHTabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.tab_bar, this, true);
        initView();
    }

    private void initView() {
        ImageView tab_image_0 = view.findViewById(R.id.tab_image_0);
        ImageView tab_image_1 = view.findViewById(R.id.tab_image_1);
        ImageView tab_image_2 = view.findViewById(R.id.tab_image_2);
        ImageView tab_image_3 = view.findViewById(R.id.tab_image_3);
        ImageView tab_image_4 = view.findViewById(R.id.tab_image_4);

        TextView tab_text_0 = view.findViewById(R.id.tab_text_0);
        TextView tab_text_1 = view.findViewById(R.id.tab_text_1);
        TextView tab_text_2 = view.findViewById(R.id.tab_text_2);
        TextView tab_text_3 = view.findViewById(R.id.tab_text_3);
        TextView tab_text_4 = view.findViewById(R.id.tab_text_4);

        tabTextList.add(tab_text_0);
        tabTextList.add(tab_text_1);
        tabTextList.add(tab_text_2);
        tabTextList.add(tab_text_3);
        tabTextList.add(tab_text_4);

        tabImageList.add(tab_image_0);
        tabImageList.add(tab_image_1);
        tabImageList.add(tab_image_2);
        tabImageList.add(tab_image_3);
        tabImageList.add(tab_image_4);

        view.findViewById(R.id.ly_0).setOnClickListener(this);
        view.findViewById(R.id.ly_1).setOnClickListener(this);
        view.findViewById(R.id.ly_2).setOnClickListener(this);
        view.findViewById(R.id.ly_3).setOnClickListener(this);
        view.findViewById(R.id.ly_4).setOnClickListener(this);
    }

    public void setTabTextAndImage(String[] texts, int[] normalImages, int[] focusImages) {
        this.normalImages = normalImages;
        this.focusImages = focusImages;
        for (int i = 0; i < texts.length; i++) {
            tabTextList.get(i).setText(texts[i]);
            tabImageList.get(i).setImageResource(normalImages[i]);
        }
        tabImageList.get(0).setImageResource(focusImages[0]);

        switch (texts.length) {
            case 1:
                view.findViewById(R.id.ly_1).setVisibility(GONE);
            case 2:
                view.findViewById(R.id.ly_2).setVisibility(GONE);
            case 3:
                view.findViewById(R.id.ly_3).setVisibility(GONE);
            case 4:
                view.findViewById(R.id.ly_4).setVisibility(GONE);
        }
    }

    public void setClickCallback(TabBarClickCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ly_0) {
            setFocus(0);
            callback.onTabClick(0);
        } else if (view.getId() == R.id.ly_1) {
            setFocus(1);
            callback.onTabClick(1);
        } else if (view.getId() == R.id.ly_2) {
            setFocus(2);
            callback.onTabClick(2);
        } else if (view.getId() == R.id.ly_3) {
            setFocus(3);
            callback.onTabClick(3);
        } else if (view.getId() == R.id.ly_4) {
            setFocus(4);
            callback.onTabClick(4);
        }
    }

    public interface TabBarClickCallback {
        /**
         * 点击返回按钮回调
         */
        void onTabClick(int tabNumber);
    }

    public void setFocus(int position) {
        for (int i = 0; i < tabImageList.size(); i++) {
            tabImageList.get(i).setImageResource(normalImages[i]);
        }
        tabImageList.get(position).setImageResource(focusImages[position]);
    }


}
