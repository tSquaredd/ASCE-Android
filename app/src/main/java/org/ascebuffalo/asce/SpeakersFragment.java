package org.ascebuffalo.asce;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return root;
    }


    //sample data
    public List<Speaker> getData() {
        List<Speaker> data = new ArrayList<>();
        data.add(new Speaker(R.drawable.ic_person_pin, "Nancy Berson",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Nancy Berson",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Kelly Doyle",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Kelly Doyle",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Tapas Dutta",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Tapas Dutta",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Nick Homerding",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Sam Kito",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Sam Kito",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Jennifer Lawrence",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Jennifer Lawrence",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Blaine Leonard",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Blaine Leonard",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Norma Jean",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Christian Muntean",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Michael Pierce",1));
        data.add(new Speaker(R.drawable.ic_person_pin, "Christian Muntean",0));
        data.add(new Speaker(R.drawable.ic_person_pin, "Michael Pierce",0));

        Collections.sort(data, (o1, o2) -> {
            if (o1.getName().charAt(0)-o2.getName().charAt(0)==0){
                return o2.isFirst() - o1.isFirst();
            }
            return o1.getName().charAt(0)-o2.getName().charAt(0);
        });
        return data;
    }

}
