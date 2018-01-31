package org.ascebuffalo.asce;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {



   @BindView(R.id.web_view_entertainment)
    WebView entWebView;

    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_entertainment, container, false);
        getActivity().setTitle("Entertainment");
        ButterKnife.bind(this, view);

        entWebView.loadUrl("https://www.visitbuffaloniagara.com/");


        return view;
    }





}
