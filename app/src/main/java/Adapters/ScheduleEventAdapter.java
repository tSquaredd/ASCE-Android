package Adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ascebuffalo.asce.R;

import java.util.ArrayList;
import java.util.List;

import Objects.ScheduleEvent;

/**
 * Created by tylerturnbull on 11/16/17.
 */

public class ScheduleEventAdapter extends RecyclerView.Adapter<ScheduleEventAdapter.EventViewHolder> {

    private static final String LOG_TAG = ScheduleEvent.class.getName();

    private ArrayList<ScheduleEvent> mList;


    final private ScheduleEventOnClickHandler mClickHandler;

    public interface ScheduleEventOnClickHandler{
        void onClick(ScheduleEvent event, int position, View view);
    }

    public ScheduleEventAdapter( ArrayList<ScheduleEvent> list, ScheduleEventOnClickHandler handler){
        mList = list;
        mClickHandler = handler;
    }


    @Override
    public ScheduleEventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.schedule_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        EventViewHolder viewHolder = new EventViewHolder(view);

        return viewHolder;

    }


    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.bind(mList.get(position));
        holder.titleTextView.setTransitionName("transition" + position);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView titleTextView;
        TextView startTimeTextView;
        TextView endTimeTextView;
        TextView locationTextView;
        TextView sectionsTextView;

        public EventViewHolder(View itemView){
            super(itemView);

            titleTextView = (TextView)itemView.findViewById(R.id.tv_event_name);
            startTimeTextView = (TextView)itemView.findViewById(R.id.tv_event_time);
            endTimeTextView = (TextView)itemView.findViewById(R.id.tv_event_time2);
            locationTextView = (TextView)itemView.findViewById(R.id.tv_event_location);
            sectionsTextView = (TextView)itemView.findViewById(R.id.tv_event_sections);

            itemView.setOnClickListener(this);
        }

        void bind(ScheduleEvent event){
            titleTextView.setText(event.getTitle());
            startTimeTextView.setText(event.getStartTime());
            if(!event.getEndTime().equals("0"))
                endTimeTextView.setText(event.getEndTime());
            else
                endTimeTextView.setVisibility(View.INVISIBLE);
            if(event.getLocation() != null){
                locationTextView.setText(event.getLocation());
                locationTextView.setVisibility(View.VISIBLE);
                itemView.findViewById(R.id.location_img).setVisibility(View.VISIBLE);
            }


            if(event.getSections() != null) {
                sectionsTextView.setText(event.getSections());
                sectionsTextView.setVisibility(View.VISIBLE);
                itemView.findViewById(R.id.section_img).setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            ScheduleEvent event = mList.get(adapterPosition);
            mClickHandler.onClick(event, adapterPosition, v);

        }
    }


}
