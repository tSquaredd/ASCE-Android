package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ascebuffalo.asce.R;

import java.util.Collections;
import java.util.List;

import Objects.Sponsor;


public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    private List<Sponsor> data = Collections.emptyList();


    public SponsorAdapter(Context context, List<Sponsor> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview;
        MyViewHolder myViewHolder;
        if(viewType == TYPE_LIST){
            rootview = inflater.inflate(R.layout.sponsor_list_item, parent, false);
            myViewHolder = new MyViewHolder(rootview,viewType);
            return myViewHolder;
        }
        else if(viewType == TYPE_HEAD){
            rootview = inflater.inflate(R.layout.head_layout, parent, false);
            myViewHolder = new MyViewHolder(rootview,viewType);
            return myViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if(holder.view_type == TYPE_LIST){
            holder.sponsor.setImageResource(data.get(position).getS_picture());
            holder.name.setText(data.get(position).getS_name());
            holder.level.setText(data.get(position).getS_level());
        }
        else if (holder.view_type == TYPE_HEAD){
            holder.header.setText(data.get(position).getS_level());
        }

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        int view_type;

        ImageView sponsor;
        TextView name;
        TextView level;
        TextView header;


        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            if(viewType == TYPE_LIST){
                sponsor = itemView.findViewById(R.id.sponsor_logo);
                name = itemView.findViewById(R.id.sponsor_company);
                level = itemView.findViewById(R.id.sponsor_position);
                view_type = 1;

            }
            if (viewType == TYPE_HEAD){
                header = itemView.findViewById(R.id.letter);
                view_type = 0;
            }

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(data.get(position).getIs_header() == 1)
            return TYPE_HEAD;
        return TYPE_LIST;
    }
}
