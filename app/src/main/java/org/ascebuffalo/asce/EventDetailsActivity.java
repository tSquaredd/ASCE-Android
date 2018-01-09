package org.ascebuffalo.asce;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import Objects.ScheduleEvent;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailsActivity extends AppCompatActivity {

    private static final String LOG_TAG = EventDetailsActivity.class.getName();

    ScheduleEvent mEvent;

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

    @BindView(R.id.tv_event_details_moderators)
    TextView mEventModeratorsTextView;

    @BindView(R.id.tv_event_details_panelists)
    TextView mEventPanelistsTextView;

    @BindView(R.id.tv_event_details_presenters)
    TextView mEventPresentersTextView;

    @BindView(R.id.tv_event_details_leaders)
    TextView mEventLeadersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ButterKnife.bind(this);
        Intent incomingIntent = getIntent();

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
        String temp = "Where: " + mEvent.getLocation();
        ssb = new SpannableStringBuilder(temp);
        ssb.setSpan(bold, 0, 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mEventLocationTextView.setText(ssb);

        mEventSectionsTextView.setText(mEvent.getSections());

        temp = "When: " + mEvent.getTimeInterval();
        ssb = new SpannableStringBuilder(temp);
        ssb.setSpan(bold, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mEventTimeTextView.setText(ssb);

        if(mEvent.getDescription() != null) {
            mEventDescTextView.setText(mEvent.getDescription());
            mEventDescTextView.setVisibility(View.VISIBLE);
            mEventDetailsHeaderTextView.setVisibility(View.VISIBLE);
        }

        if(mEvent.getModerators() != null){
            StringBuilder sb = new StringBuilder();
            sb.append("Moderators:\n");
            for(int i = 0; i < mEvent.getModerators().length; i++){
                sb.append(mEvent.getModerators()[i]).append("\n");
            }

            ssb = new SpannableStringBuilder(sb.toString());
            ssb.setSpan(bold, 0, 10, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            mEventModeratorsTextView.setText(ssb);
            mEventModeratorsTextView.setVisibility(View.VISIBLE);
        }

        if(mEvent.getPanelists() != null){
            StringBuilder sb = new StringBuilder();
            sb.append("Panelists:\n");
            for(int i = 0; i < mEvent.getPanelists().length; i++){
                sb.append(mEvent.getPanelists()[i]).append("\n");
            }

            ssb = new SpannableStringBuilder(sb.toString());
            ssb.setSpan(bold, 0, 9, Spannable.SPAN_INCLUSIVE_INCLUSIVE);



            mEventPanelistsTextView.setText(ssb);
            mEventPanelistsTextView.setVisibility(View.VISIBLE);
        }

        if(mEvent.getPresenters() != null){
            StringBuilder sb = new StringBuilder();
            sb.append("Presenters:\n");
            for(int i = 0; i < mEvent.getPresenters().length; i++){
                sb.append(mEvent.getPresenters()[i]).append("\n");
            }

            ssb = new SpannableStringBuilder(sb.toString());
            ssb.setSpan(bold, 0, 10, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


            mEventPresentersTextView.setText(ssb);
            mEventPresentersTextView.setVisibility(View.VISIBLE);
        }

        if(mEvent.getLeaders() != null){
            StringBuilder sb = new StringBuilder();
            sb.append("Leaders:\n");
            for(int i = 0; i < mEvent.getLeaders().length; i++){
                sb.append(mEvent.getLeaders()[i]).append("\n");
            }

            ssb = new SpannableStringBuilder(sb.toString());
            ssb.setSpan(bold, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            mEventLeadersTextView.setText(ssb);
            mEventLeadersTextView.setVisibility(View.VISIBLE);
        }
    }
}
