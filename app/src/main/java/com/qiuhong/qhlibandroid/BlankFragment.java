package com.qiuhong.qhlibandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        return rootView;
    }
}
