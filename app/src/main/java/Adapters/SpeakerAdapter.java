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

import Objects.Speaker;

/**
 * Created by ziyi liu on 11/25/2017.
 */

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Speaker> data = Collections.emptyList();

    public SpeakerAdapter(Context context, List<Speaker> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = inflater.inflate(R.layout.speaker_list_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(rootview);
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
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView selfie;
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            selfie = itemView.findViewById(R.id.selfie);
            name = itemView.findViewById(R.id.professor_name);
        }
    }
}
