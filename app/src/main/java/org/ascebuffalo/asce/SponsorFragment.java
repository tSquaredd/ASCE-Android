package org.ascebuffalo.asce;

/**
 * Created by john on 2017/12/23.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import Adapters.SponsorAdapter;
import Objects.Sponsor;

public class SponsorFragment extends Fragment{
    RecyclerView mRecyclerView;
    SponsorAdapter mAdapter;

    ArrayList<Sponsor> mEventList;

    public SponsorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_friday_schedule, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.rv_friday_schedule);
        mEventList = new ArrayList<Sponsor>();

        ;
        Bundle args = getArguments();
        mEventList = args.getParcelableArrayList("Sponsor");


        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(manager);

        mRecyclerView.setHasFixedSize(false);

        mAdapter = new SponsorAdapter(mEventList);

        mRecyclerView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }






}
