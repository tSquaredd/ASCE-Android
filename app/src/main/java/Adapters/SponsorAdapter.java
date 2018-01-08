package Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ascebuffalo.asce.MainActivity;
import org.ascebuffalo.asce.R;
import org.ascebuffalo.asce.SponsorsFragment;

import java.util.ArrayList;
import java.util.List;

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

        int layoutIdForListItem = R.layout.fragment_sponsors_list_item;

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

        TextView nameTextView;
        ImageView picTextView;
        TextView moneyTextView;
        TextView desTextView;

        public EventViewHolder(View itemView){
            super(itemView);

            nameTextView = (TextView)itemView.findViewById(R.id.tv_sp_name);
            picTextView = (ImageView) itemView.findViewById(R.id.tv_sp_pic);
            moneyTextView = (TextView)itemView.findViewById(R.id.tv_sp_money);
            desTextView = (TextView)itemView.findViewById(R.id.tv_sp_des);
        }

        void bind(Sponsor event){
            nameTextView.setText(event.getName());



            picTextView.setImageResource(event.getPic());


            moneyTextView.setText(event.getMoney());
            desTextView.setText("");
        }
    }


}
