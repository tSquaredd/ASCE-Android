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
import Objects.Sponsor;


public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.EventViewHolder> {

    private static final String LOG_TAG = Sponsor.class.getName();

    private ArrayList<Sponsor> mList;
    private int mNumItems;

    public SponsorAdapter(ArrayList<Sponsor> list){
        mList = list;
        mNumItems = list.size();
    }


    @Override
    public SponsorAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.fragment_sponsors;
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


    // May need to use onBindViewHolder




    @Override
    public int getItemCount() {
        return mNumItems;
    }


    class EventViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView timeTextView;
        TextView locationTextView;

        public EventViewHolder(View itemView){
            super(itemView);

            titleTextView = (TextView)itemView.findViewById(R.id.tv_event_name);
            timeTextView = (TextView)itemView.findViewById(R.id.tv_event_time);
            locationTextView = (TextView)itemView.findViewById(R.id.tv_event_location);
        }

        void bind(Sponsor event){
            titleTextView.setText(event.getName());
            timeTextView.setText(event.getPic());
            locationTextView.setText(event.getMoney());

        }
    }


}
