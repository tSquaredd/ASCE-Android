package org.ascebuffalo.asce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;


//TODO: handle no internet connection

/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    public TwitterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Twitter.initialize(getContext());

        View v = inflater.inflate(R.layout.fragment_twitter, container, false);
        getActivity().setTitle("Twitter");
       mRecyclerView = (RecyclerView)v.findViewById(R.id.rv_twitter);
       mProgressBar = (ProgressBar)v.findViewById(R.id.pb_twitter);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query("#MRLC")
                .query("#MRLC2018")
                .query("#ERYMC")
                .query("#ERYMC2018")
                .query("#ASCE")
                .maxItemsPerRequest(100)
                .build();


        /*TODO: Consider changing setViewStyle below to TweetLightStyleWithAction
        but would need to implement twitter login
         */


        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(getContext())
                        .setTimeline(searchTimeline)
                        .setViewStyle(R.style.tw__TweetLightStyle)
                        .build();

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }
        });

        mRecyclerView.setAdapter(adapter);


    }


}
