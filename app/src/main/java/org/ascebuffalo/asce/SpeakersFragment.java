package org.ascebuffalo.asce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Adapters.SpeakerAdapter;
import Objects.Speaker;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakersFragment extends Fragment {


    public SpeakersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_speakers, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_speaker);
        SpeakerAdapter adapter = new SpeakerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
//sample data
    public List<Speaker> getData() {
        List<Speaker> data = new ArrayList<>();
        data.add(new Speaker(R.drawable.ic_person_pin, "Nancy Berson"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Kelly Doyle"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Tapas Dutta"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Nick Homerding"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Sam Kito"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Jennifer Lawrence"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Blaine Leonard"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Norma Jean"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Christian Muntean"));
        data.add(new Speaker(R.drawable.ic_person_pin, "Michael Pierce"));
        return data;
    }

}
