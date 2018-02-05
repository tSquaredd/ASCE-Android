package org.ascebuffalo.asce;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;

import Adapters.ScheduleEventAdapter;
import Objects.ScheduleEvent;
import Objects.Speaker;

public class Speaker_profile extends AppCompatActivity implements ScheduleEventAdapter.ScheduleEventOnClickHandler {

    RecyclerView mRecyclerView;
    ScheduleEventAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speaker_detail);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        CollapsingToolbarLayout collapsingToolbarLayout =  findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitleEnabled(false);


        ImageView imageView = findViewById(R.id.main_backdrop);
        TextView textView = findViewById(R.id.speakers_name);
        TextView speaker_position = findViewById(R.id.speakers_text);
        Bundle bundle = getIntent().getExtras();

        Speaker speaker = bundle.getParcelable("speaker");
        if(speaker != null){
            Log.d("speaker init", speaker.getName() + " with selfie " + speaker.getSelfie());

            imageView.setImageResource(speaker.getSelfie());
            textView.setText(speaker.getName());
            speaker_position.setText(speaker.getPosition());


        }


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        String speaker_name = speaker.getName();

        mRecyclerView = findViewById(R.id.speakers_detail_recyclerview);
        ArrayList<ScheduleEvent> mEventList_Saturday = ScheduleEvent.saturdayEventSchedule();
        ArrayList<ScheduleEvent> mEventList_Friday = ScheduleEvent.fridayScheduleData();
        ArrayList<ScheduleEvent> speaker_schedule = new ArrayList<>();

        for(ScheduleEvent i: mEventList_Friday) {
            if(i.getPresenters()!=null && Arrays.asList(i.getPresenters()).contains(speaker_name)){
                speaker_schedule.add(i);
            }
            else if (i.getLeaders()!=null && Arrays.asList(i.getLeaders()).contains(speaker_name)){
                speaker_schedule.add(i);
            }
            else if (i.getModerators()!=null && Arrays.asList(i.getModerators()).contains(speaker_name)){
                speaker_schedule.add(i);
            }
        }
        for(ScheduleEvent i: mEventList_Saturday) {
            if(i.getPresenters()!=null && Arrays.asList(i.getPresenters()).contains(speaker_name)){
                speaker_schedule.add(i);
            }
            else if (i.getLeaders()!=null && Arrays.asList(i.getLeaders()).contains(speaker_name)){
                speaker_schedule.add(i);
            }
            else if (i.getModerators()!=null && Arrays.asList(i.getModerators()).contains(speaker_name)){
                speaker_schedule.add(i);
            }
        }
        if(!speaker_schedule.isEmpty()){
            TextView text = findViewById(R.id.speakers_event);
            text.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(false);

        mAdapter = new ScheduleEventAdapter(speaker_schedule,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(ScheduleEvent event, int position, View v) {
        Class destinationClass = EventDetailsActivity.class;
        Intent intent = new Intent(this, destinationClass);
        intent.putExtra("event", event);
        startActivity(intent);

    }
}
