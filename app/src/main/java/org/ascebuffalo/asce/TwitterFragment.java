package org.ascebuffalo.asce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterFragment extends Fragment {


    public TwitterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Twitter.initialize(getContext());

        View v = inflater.inflate(R.layout.fragment_twitter, container, false);
        final RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.rv_twitter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query("#android")
                .maxItemsPerRequest(50)
                .build();

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(getContext())
                .setTimeline(searchTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build();

        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return v;
    }



}
