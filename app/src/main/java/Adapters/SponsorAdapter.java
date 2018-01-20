package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ascebuffalo.asce.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Objects.ScheduleEvent;
import Objects.Speaker;
import Objects.Sponsor;


public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Sponsor> data = Collections.emptyList();


    public SponsorAdapter(Context context, List<Sponsor> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview;
        MyViewHolder myViewHolder;
        rootview = inflater.inflate(R.layout.sponsor_list_item, parent, false);
        myViewHolder = new MyViewHolder(rootview);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.sponsor.setImageResource(data.get(position).getS_picture());
        holder.name.setText(data.get(position).getS_name());
        holder.level.setText(data.get(position).getS_level());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView sponsor;
        TextView name;
        TextView level;


        public MyViewHolder(View itemView) {
            super(itemView);
            sponsor = itemView.findViewById(R.id.sponsor_logo);
            name = itemView.findViewById(R.id.sponsor_company);
            level = itemView.findViewById(R.id.sponsor_position);
        }
    }
}
