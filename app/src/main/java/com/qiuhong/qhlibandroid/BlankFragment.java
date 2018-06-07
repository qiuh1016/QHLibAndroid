package com.qiuhong.qhlibandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qiuhong.qhlibrary.QHEditDialog.QHEditDialog;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        textView.setText("Hello World from section: " + getArguments().getInt(ARG_SECTION_NUMBER));
        rootView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QHEditDialog qhEditDialog = new QHEditDialog(getActivity());
                qhEditDialog.setTitle("IP", "PORT");
                qhEditDialog.setOnBtnClicked(new QHEditDialog.OnBtnClicked() {
                    @Override
                    public void onConfirmClicked(String str1, String str2) {
                        Toast.makeText(getActivity(), str1 + " , " + str2, Toast.LENGTH_SHORT).show();
                    }
                });
                qhEditDialog.show();
            }
        });
        return rootView;
    }
}
