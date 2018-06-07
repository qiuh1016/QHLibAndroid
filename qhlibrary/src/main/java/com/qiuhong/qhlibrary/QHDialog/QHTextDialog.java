package com.qiuhong.qhlibrary.QHDialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qiuhong.qhlibrary.R;

public class QHTextDialog extends Dialog {

    public final static int COLOR_RED = 0xFFFF0000;

    private Context mContext;

    public TextView tv_title, tv_content, tv_cancel, tv_confirm;
    private OnBtnClicked onBtnClicked;

    public QHTextDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
        initTextDialog();
    }

    public QHTextDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        initTextDialog();
    }

    protected QHTextDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
        initTextDialog();
    }

    private void initTextDialog() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.text_dialog, null);
        addContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        setContentView(layout);

        // set dialog width
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        float density = dm.density;
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        int dialogWidth = screenWidth < screenHeight ? screenWidth / 5 * 4 : screenHeight / 5 * 4;
        LinearLayout ly_top = findViewById(R.id.ly_top);
        LinearLayout ly_bottom = findViewById(R.id.ly_bottom);
        LinearLayout.LayoutParams lp_top = (LinearLayout.LayoutParams) ly_top.getLayoutParams();
        lp_top.width = dialogWidth;
        LinearLayout.LayoutParams lp_bottom = (LinearLayout.LayoutParams) ly_bottom.getLayoutParams();
        lp_bottom.width = dialogWidth;

        tv_title = findViewById(R.id.tv_title);
        tv_content = findViewById(R.id.tv_content);
        tv_cancel = findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tv_confirm = findViewById(R.id.tv_confirm);
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnClicked.onConfirmClicked();
                dismiss();
            }
        });
    }

    public void setOnBtnClicked(OnBtnClicked onBtnClicked) {
        this.onBtnClicked = onBtnClicked;
    }

    public void setTitle(String title) {
        tv_title.setText(title);
    }

    public void setContent(String content) {
        tv_content.setText(content);
    }

    public void setBtnCount(int count) {
        if (count == 1) tv_cancel.setVisibility(View.GONE);
    }

    public void setCancelText(String str) {
        tv_cancel.setText(str);
    }

    public void setConfirmText(String str) {
        tv_confirm.setText(str);
    }

    public void setConfirmColor(int color) {
        tv_confirm.setTextColor(color);
    }

    public interface OnBtnClicked {
        void onCancelClicked();
        void onConfirmClicked();
    }

}
