package Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ascebuffalo.asce.R;
import org.ascebuffalo.asce.Speaker_profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Objects.Speaker;

/**
 * Created by ziyi liu on 11/25/2017.
 */

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Speaker> data = Collections.emptyList();
//    private boolean[] header_section = new boolean[26];
//    private static final int TYPE_HEAD = 0;
//    private static final int TYPE_LIST = 1;

    public SpeakerAdapter(Context context, List<Speaker> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview;
        MyViewHolder myViewHolder;
        rootview = inflater.inflate(R.layout.speaker_list_item, parent, false);
        myViewHolder = new MyViewHolder(rootview);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.selfie.setImageResource(data.get(position).getSelfie());
        holder.name.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView selfie;
        TextView name;


        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            selfie = itemView.findViewById(R.id.selfie);
            name = itemView.findViewById(R.id.professor_name);

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

}
