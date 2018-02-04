package org.ascebuffalo.asce;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Adapters.SpeakerAdapter;
import Objects.ScheduleEvent;
import Objects.Speaker;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailsActivity extends AppCompatActivity {

    private static final String LOG_TAG = EventDetailsActivity.class.getName();

    ScheduleEvent mEvent;
    private List<Speaker> mSpeakerData;

    // Views
    @BindView(R.id.tv_event_details_name)
    TextView mEventNameTextView;

    @BindView(R.id.tv_event_details_sections)
    TextView mEventSectionsTextView;

    @BindView(R.id.tv_event_details_location)
    TextView mEventLocationTextView;

    @BindView(R.id.tv_event_details_time)
    TextView mEventTimeTextView;

    @BindView(R.id.tv_event_details_header)
    TextView mEventDetailsHeaderTextView;

    @BindView(R.id.tv_event_details_information)
    TextView mEventDescTextView;

    @BindView(R.id.tv_event_details_moderators_header)
    TextView mEventModeratorsHeaderTextView;

    @BindView(R.id.tv_event_details_panelists_header)
    TextView mEventPanelistsHeaderTextView;

    @BindView(R.id.tv_event_details_presenters_header)
    TextView mEventPresentersHeaderTextView;

    @BindView(R.id.tv_event_details_leaders_header)
    TextView mEventLeadersHeaderTextView;

    @BindView(R.id.rv_event_details_leaders)
    RecyclerView mLeadersRecyclerView;

    @BindView(R.id.rv_event_details_panelists)
    RecyclerView mPanelistsRecyclerView;

    @BindView(R.id.rv_event_details_presenters)
    RecyclerView mPresentersRecyclerView;

    @BindView(R.id.rv_event_details_moderators)
    RecyclerView mModeratorsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ButterKnife.bind(this);
        Intent incomingIntent = getIntent();

        mSpeakerData = Speaker.getData();

        if(incomingIntent != null){
            if(incomingIntent.hasExtra("event")){
                mEvent = incomingIntent.getParcelableExtra("event");
            }
        }



        setViews();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setViews(){


        // for adding bold styling to String
        SpannableStringBuilder ssb;
        StyleSpan bold = new StyleSpan(Typeface.BOLD);


        mEventNameTextView.setText(mEvent.getTitle());
        mEventLocationTextView.setText(mEvent.getLocation());
        mEventSectionsTextView.setText(mEvent.getSections());
        mEventTimeTextView.setText(mEvent.getTimeInterval());

        if(mEvent.getDescription() != null) {
            mEventDescTextView.setText(mEvent.getDescription());
            mEventDescTextView.setVisibility(View.VISIBLE);
            mEventDetailsHeaderTextView.setVisibility(View.VISIBLE);
        }

        if(mEvent.getModerators() != null){


            // Reveal header
            mEventModeratorsHeaderTextView.setVisibility(View.VISIBLE);

            // Create list of moderators for event
            List<Speaker> moderatorList = new ArrayList<>();
            for(int i = 0; i < mEvent.getModerators().length; i++){
                for(int j = 0; j < mSpeakerData.size(); j++){
                    if(mEvent.getModerators()[i].equals(mSpeakerData.get(j).getName()) && mSpeakerData.get(j).isFirst() == 0){
                        moderatorList.add(mSpeakerData.get(j));
                        break;
                    }

                }
            }

            SpeakerAdapter adapter = new SpeakerAdapter(this, moderatorList, true);
            mModeratorsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mModeratorsRecyclerView.setAdapter(adapter);



        }

        if(mEvent.getPanelists() != null){


            // Reveal header
            mEventPanelistsHeaderTextView.setVisibility(View.VISIBLE);

            // Create list of panelists for event
            List<Speaker> panelistList = new ArrayList<>();
            for(int i = 0; i < mEvent.getPanelists().length; i++){
                for(int j = 0; j < mSpeakerData.size(); j++){
                    if(mEvent.getPanelists()[i].equals(mSpeakerData.get(j).getName()) && mSpeakerData.get(j).isFirst() == 0){
                        panelistList.add(mSpeakerData.get(j));
                    }
                }
            }

            SpeakerAdapter adapter = new SpeakerAdapter(this, panelistList, true);
            mPanelistsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mPanelistsRecyclerView.setAdapter(adapter);


        }

        if(mEvent.getPresenters() != null){


            // Reveal header
            mEventPresentersHeaderTextView.setVisibility(View.VISIBLE);

            // Create list of presenters for event
            List<Speaker> presenterList = new ArrayList<>();
            for(int i = 0; i < mEvent.getPresenters().length; i++){
                for(int j = 0; j < mSpeakerData.size(); j++){
                    if(mEvent.getPresenters()[i].equals(mSpeakerData.get(j).getName()) && mSpeakerData.get(j).isFirst() == 0){
                        presenterList.add(mSpeakerData.get(j));
                    }
                }
            }

            SpeakerAdapter adapter = new SpeakerAdapter(this, presenterList, true);
            mPresentersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mPresentersRecyclerView.setAdapter(adapter);

        }

        if(mEvent.getLeaders() != null){


            // Reveal header
            mEventLeadersHeaderTextView.setVisibility(View.VISIBLE);

            // Create list of leaders for event
            List<Speaker> leadersList = new ArrayList<>();
            for(int i = 0; i < mEvent.getLeaders().length; i++){
                for(int j = 0; j < mSpeakerData.size(); j++){
                    if(mEvent.getLeaders()[i].equals(mSpeakerData.get(j).getName()) && mSpeakerData.get(j).isFirst() == 0){
                        leadersList.add(mSpeakerData.get(j));
                    }
                }
            }

            SpeakerAdapter adapter = new SpeakerAdapter(this, leadersList, true);
            mLeadersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mLeadersRecyclerView.setAdapter(adapter);

        }
    }
}
