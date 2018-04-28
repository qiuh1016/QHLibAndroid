package com.qiuhong.qhlibrary.QHTitleView;

/**
 * Created by qiuhong on 8/24/16.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qiuhong.qhlibrary.R;


/**
 * 导航栏组件,目前包括返回键,标题,右侧按钮.其中:
 * </br>返回键已经实现按键监听
 * </br>右侧按钮已实现按键监听
 * </br>标题默认不可点击
 * @author Asia
 *
 */
public class QHTitleView extends RelativeLayout implements View.OnClickListener {

    public QHTitleView(Context context){
        this(context, null);
    }

    private RelativeLayout backgroundLayout;
    private ImageView backView;
    private TextView titleView;
    private ImageView rightView;

    public QHTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.navigation_view, this, true);

        backView = (ImageView) view.findViewById(R.id.iv_nav_back);
        backView.setOnClickListener(this);
        rightView = (ImageView) view.findViewById(R.id.iv_nav_right);
        rightView.setOnClickListener(this);

        titleView = (TextView) view.findViewById(R.id.tv_nav_title);
        backgroundLayout = (RelativeLayout) view.findViewById(R.id.iv_nav_layout);

    }

    /**
     * 获取返回按钮
     * @return
     */
    public ImageView getBackView() {
        return backView;
    }

    /**
     * 设置返回按钮图片
     */
    public void setBackView(int imageResource) {
        backView.setImageResource(imageResource);
    }

    /**
     * 设置右侧按钮图片
     */
    public void setRightView(int imageResource) {
        rightView.setImageResource(imageResource);
    }

    /**
     * 设置背景资源
     * @author qh
     * created at 9/2/16 10:54
     */
    public void setBackgroundResource(int resid) {
        backgroundLayout.setBackgroundResource(resid);
    }

    /**
     * 获取标题控件
     * @return
     */
    public TextView getTitleView() {
        return titleView;
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title){
        titleView.setText(title);
    }

    /**
     * 设置标题字体颜色
     * @param color
     */
    public void setTitleTextColor(int color){
        titleView.setTextColor(color);
    }

    /**
     * 获取右侧按钮,默认不显示
     * @return
     */
    public ImageView getRightView() {
        return rightView;
    }

    private ClickCallback callback;
    /**
     * 设置按钮点击回调接口
     * @param callback
     */
    public void setClickCallback(ClickCallback callback) {
        this.callback = callback;
    }

    /**
     * 导航栏点击回调接口
     * </br>如若需要标题可点击,可再添加
     * @author Asia
     *
     */
    public static interface ClickCallback{
        /**
         * 点击返回按钮回调
         */
        void onBackClick();

        void onRightClick();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_nav_back) {
            callback.onBackClick();
            return;
        }
        if (id == R.id.iv_nav_right) {
            callback.onRightClick();
            return;
        }
    }
}