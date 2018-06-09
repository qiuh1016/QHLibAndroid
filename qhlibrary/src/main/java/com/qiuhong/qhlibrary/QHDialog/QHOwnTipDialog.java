package com.qiuhong.qhlibrary.QHDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qiuhong.qhlibrary.R;

public class QHOwnTipDialog extends Dialog {

    private TextView tv;

    private Context mContext;

    public static final int DISMISS_SHORT = 1500;
    public static final int DISMISS_LONG = 3500;

    public QHOwnTipDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
        initTipDialog();
        autoDismiss(DISMISS_SHORT);
    }

    public QHOwnTipDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        initTipDialog();
    }

    protected QHOwnTipDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
        initTipDialog();
    }

    private QHOwnTipDialog getInstance() {
        return this;
    }

    private void initTipDialog() {
        this.setCancelable(false);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.tip_dialog_own, null);
        addContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        setContentView(layout);

        // set dialog width
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        float density = dm.density;
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        int dialogWidth = screenWidth < screenHeight ? screenWidth / 3 : screenHeight / 3;
        LinearLayout ly_top = findViewById(R.id.ly_top);
        LinearLayout.LayoutParams lp_top = (LinearLayout.LayoutParams) ly_top.getLayoutParams();
        lp_top.width = dialogWidth;

        tv = findViewById(R.id.tv);

        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.7f; // 透明度
        lp.dimAmount = 0f; // 背景黑色
        this.getWindow().setBackgroundDrawableResource(R.drawable.tip_dialog_bg);
    }

    public void setText(String str) {
        tv.setText(str);
    }

    private void autoDismiss(int ms) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getInstance().dismiss();
            }
        }, ms);
    }
}
