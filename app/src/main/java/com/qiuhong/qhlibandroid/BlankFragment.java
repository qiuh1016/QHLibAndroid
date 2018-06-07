package com.qiuhong.qhlibandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qiuhong.qhlibrary.QHDialog.QHEditDialog;
import com.qiuhong.qhlibrary.QHDialog.QHTextDialog;
import com.qiuhong.qhlibrary.QHDialog.QHTipDialog;

/**
 * Created by qiuhong on 28/04/2018.
 */

public class BlankFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public BlankFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment newInstance(int sectionNumber) {
        Fragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        textView.setText("Hello World from section: " + getArguments().getInt(ARG_SECTION_NUMBER));
        initBtn(rootView);

        return rootView;
    }

    private void initBtn(View rootView) {
        rootView.findViewById(R.id.btn_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QHEditDialog qhEditDialog = new QHEditDialog(getActivity());
                qhEditDialog.setTitle("IP", "PORT");
                qhEditDialog.setOnBtnClicked(new QHEditDialog.OnBtnClicked() {
                    @Override
                    public void onCancelClicked() {
                        //
                    }

                    @Override
                    public void onConfirmClicked(String str1, String str2) {
                        Toast.makeText(getActivity(), str1 + " , " + str2, Toast.LENGTH_SHORT).show();
                    }
                });
                qhEditDialog.show();
            }
        });

        rootView.findViewById(R.id.btn_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QHTextDialog qhTextDialog = new QHTextDialog(getActivity());
                qhTextDialog.setTitle("提示");
                qhTextDialog.setContent("确认删除xxxx吗？");
                qhTextDialog.setConfirmText("删除");
                qhTextDialog.setConfirmColor(QHTextDialog.COLOR_RED);
                qhTextDialog.setOnBtnClicked(new QHTextDialog.OnBtnClicked() {
                    @Override
                    public void onCancelClicked() {
                        //
                    }

                    @Override
                    public void onConfirmClicked() {
                        Toast.makeText(getActivity(), "已删除", Toast.LENGTH_SHORT).show();
                    }
                });
                qhTextDialog.show();
            }
        });

        rootView.findViewById(R.id.btn_tip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QHTipDialog qhTipDialog = new QHTipDialog(getActivity());
                qhTipDialog.setText("正在加载中");
                qhTipDialog.show();
            }
        });

        rootView.findViewById(R.id.btn_alert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getActivity())
                    .setTitle("123213")
                    .setMessage("12312312312312")
                    .create()
                    .show();
            }
        });
    }
}
