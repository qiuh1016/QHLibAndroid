package com.qiuhong.qhlibrary.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

/**
 * Created by qiuhong on 9/8/16.
 */
public class QHDialog {

    private QHDialogClass qhDialog;
    private QHDialogClass.Builder builder;
    private boolean cancelable = true;
    private View contentView;
    private String title;
    private String message;

    private boolean needOneEditText = false;
    private String placeHolder = "";

    private String TAG = "QHDialog";

    public QHDialog(Context context) {
        builder = new QHDialogClass.Builder(context);
    }

    public QHDialog(Context context, String title, String message) {
        this.title = title;
        this.message = message;
        builder = new QHDialogClass.Builder(context);
    }

    public void show() {
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(cancelable);
        builder.setContentView(contentView);
        builder.setEditText(needOneEditText, placeHolder);
        qhDialog = builder.create();
        qhDialog.show();
    }

    public void setOnlyOneButtonText(String text) {
        builder.setOnlyOneButtonText(text);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPositiveButton(String text, int backgroundResource, DialogInterface.OnClickListener listener) {
        builder.setPositiveButton(text, backgroundResource, listener);
    }

    public void setPositiveButton(String text, DialogInterface.OnClickListener listener) {
        builder.setPositiveButton(text, listener);
    }

    public void setNegativeButton(String text, int backgroundResource, DialogInterface.OnClickListener listener) {
        builder.setNegativeButton(text, backgroundResource, listener);
    }

    public void setNegativeButton(String text, DialogInterface.OnClickListener listener) {
        builder.setNegativeButton(text, listener);
    }

    public void setNavigationBackgroundResource(int backgroundResource) {
        builder.setNavigationBackgroundResource(backgroundResource);
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }

    public void setContextView(View v) {
        this.contentView = v;
    }

    public void setEditText(String placeHolder) {
        this.needOneEditText = true;
        this.placeHolder = placeHolder;
    }

    public String getEditTextText() {
        return builder.editText.getText().toString();
    }

}
