package Adapters;

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
    private int mNumItems;

    final private ScheduleEventOnClickHandler mClickHandler;

    public interface ScheduleEventOnClickHandler{
        void onClick(ScheduleEvent event);
    }

    public ScheduleEventAdapter( ArrayList<ScheduleEvent> list, ScheduleEventOnClickHandler handler){
        mList = list;
        mNumItems = list.size();
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
    }








    @Override
    public int getItemCount() {
        return mNumItems;
    }


    class EventViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView timeTextView;
        TextView locationTextView;
        TextView sectionsTextView;

        public EventViewHolder(View itemView){
            super(itemView);

            titleTextView = (TextView)itemView.findViewById(R.id.tv_event_name);
            timeTextView = (TextView)itemView.findViewById(R.id.tv_event_time);
            locationTextView = (TextView)itemView.findViewById(R.id.tv_event_location);
            sectionsTextView = (TextView)itemView.findViewById(R.id.tv_event_sections);
        }

        void bind(ScheduleEvent event){
            titleTextView.setText(event.getTitle());
            String timeInterval = event.getStartTime() + " - " +event.getEndTime();
            timeTextView.setText(timeInterval);
            if(event.getLocation() != null){
                locationTextView.setText(event.getLocation());
                locationTextView.setVisibility(View.VISIBLE);
            }


            if(event.getSections() != null) {
                sectionsTextView.setText(event.getSections());
                sectionsTextView.setVisibility(View.VISIBLE);
            }
        }
    }


}
