package com.qiuhong.qhlibrary.QHEditDialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qiuhong.qhlibrary.R;

public class QHEditDialog extends Dialog {

    public EditText et_1, et_2;
    public TextView tv_cancel, tv_confirm;
    public TextView title_1, title_2;

    private Context mContext;

    private OnBtnClicked onBtnClicked;


    public QHEditDialog(Context context) {
        super(context);
        mContext = context;
        initDialog(context);
    }

    public QHEditDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        initDialog(context);
    }

    public void setEtCount(int count) {
        if (count == 1) et_2.setVisibility(View.GONE);
    }

    public void setTitle(String str1, String str2) {
        title_1.setText(str1);
        title_2.setText(str2);
    }

    public void setOnBtnClicked(OnBtnClicked onBtnClicked) {
        this.onBtnClicked = onBtnClicked;
    }

    public void setEtText(String str1, String str2) {
        et_1.setText(str1);
        et_2.setText(str2);
    }

    public void setEtHint(String str1, String str2) {
        et_1.setHint(str1);
        et_2.setHint(str2);
    }

    private void initDialog(final Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.edit_dialog, null);
        addContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        setContentView(layout);
        title_1 = findViewById(R.id.tv_et_title_1);
        title_2 = findViewById(R.id.tv_et_title_2);

        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);

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
                if ("".equals(getTextByET1())) {
                    Toast.makeText(mContext, "请先输入" + title_1.getText(), Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(getTextByET2())) {
                    Toast.makeText(mContext, "请先输入" + title_2.getText(), Toast.LENGTH_SHORT).show();
                    return;
                }
                onBtnClicked.onConfirmClicked(getTextByET1(), getTextByET2());
                dismiss();

            }
        });
    }

    public String getTextByET1() {
        return et_1.getText().toString();
    }

    public String getTextByET2() {
        return et_2.getText().toString();
    }

    public interface OnBtnClicked {
         void onConfirmClicked(String str1, String str2);
    }
}
