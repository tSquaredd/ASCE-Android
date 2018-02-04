package Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ascebuffalo.asce.R;
import org.ascebuffalo.asce.Speaker_profile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


import Objects.Speaker;

/**
 * Created by ziyi liu on 11/25/2017.
 */

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Speaker> data = Collections.emptyList();
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    private int layoutItemId;


    public SpeakerAdapter(Context context, List<Speaker> data, boolean isForEventDetails) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        if(isForEventDetails)
            layoutItemId = R.layout.speaker_card_list_item_view;
        else
            layoutItemId = R.layout.speaker_list_item;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview;
        MyViewHolder myViewHolder;
        if (viewType == TYPE_LIST) {
            rootview = inflater.inflate(layoutItemId, parent, false);
            myViewHolder = new MyViewHolder(rootview, viewType);
            return myViewHolder;
        } else if (viewType == TYPE_HEAD) {
            rootview = inflater.inflate(R.layout.head_layout, parent, false);
            myViewHolder = new MyViewHolder(rootview, viewType);
            return myViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (holder.view_type == TYPE_LIST) {
            holder.selfie.setImageResource(data.get(position).getSelfie());
            holder.name.setText(data.get(position).getName());
            holder.position.setText(data.get(position).getPosition());
        } else if (holder.view_type == TYPE_HEAD) {
                holder.header.setText(data.get(position).getName().charAt(0)+"");
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        int view_type;

        ImageView selfie;
        TextView name;
        TextView position;
        TextView bio;


        TextView header;

        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType == TYPE_LIST) {
                itemView.setOnClickListener(this);
                selfie = itemView.findViewById(R.id.selfie);
                name = itemView.findViewById(R.id.professor_name);
                position = itemView.findViewById(R.id.position);
                bio = itemView.findViewById(R.id.speakers_text);
                view_type = 1;
            }
            if (viewType == TYPE_HEAD) {
                itemView.setOnClickListener(null);
                header = itemView.findViewById(R.id.letter);
                view_type = 0;
            }
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Speaker speaker = data.get(position);
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Intent intent = new Intent(activity, Speaker_profile.class);
            intent.putExtra("speaker", speaker);
            activity.startActivity(intent);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position).isFirst() ==1) return TYPE_HEAD;
        return TYPE_LIST;
    }
    public void setFilter(List<Speaker> SpeakerList) {
        data = new ArrayList<>();
        data.addAll(SpeakerList);
        notifyDataSetChanged();
    }

}
