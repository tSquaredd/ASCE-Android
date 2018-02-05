package org.ascebuffalo.asce;


import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.ScheduleEventAdapter;
import Objects.ScheduleEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayScheduleFragment extends Fragment
implements ScheduleEventAdapter.ScheduleEventOnClickHandler{

    RecyclerView mRecyclerView;
    ScheduleEventAdapter mAdapter;

    ArrayList<ScheduleEvent> mEventList;


    public DayScheduleFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_friday_schedule, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.rv_friday_schedule);
        mEventList = new ArrayList<ScheduleEvent>();

        Bundle args = getArguments();
        mEventList = args.getParcelableArrayList("events");



        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());



        mRecyclerView.setLayoutManager(manager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                mRecyclerView.getContext(),
                manager.getOrientation()
        );
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mRecyclerView.setHasFixedSize(false);

        mAdapter = new ScheduleEventAdapter(mEventList, this);

        mRecyclerView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void onClick(ScheduleEvent event, int position, View v) {
        Context context = getContext();
        Class destinationClass = EventDetailsActivity.class;

        // Prepare transition
        Fragment currentFragment = this;
        currentFragment.setSharedElementReturnTransition(TransitionInflater.from(getContext())
                .inflateTransition(R.transition.default_transition));

        currentFragment.setExitTransition(TransitionInflater.from(getContext())
        .inflateTransition(android.R.transition.no_transition));


        Intent intent = new Intent(context, destinationClass);
        intent.putExtra("event", event);
        intent.putExtra("transition_name", "transition" + position);
//        ActivityOptionsCompat options = ActivityOptionsCompat
//                .makeSceneTransitionAnimation(getActivity(),
//                        v,
//                        "transition_event_name"
//                        );
        startActivity(intent);

    }
}
