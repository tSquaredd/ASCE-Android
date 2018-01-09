package org.ascebuffalo.asce;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.twitter.sdk.android.core.models.Search;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import Adapters.SpeakerAdapter;
import Objects.Speaker;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakersFragment extends Fragment implements SearchView.OnQueryTextListener{

//    private SpeakerAdapter adapter;

    private List<Speaker> data = new ArrayList<>();

    private SpeakerAdapter adapter;


    public SpeakersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_speakers, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_speaker);
        getData();
        adapter = new SpeakerAdapter(getActivity(),data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.main,menu);

        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(this);

    }



    //sample data
    public void getData() {

        data.add(new Speaker(R.drawable.speaker_details_header, "Don Wittmer", 0,getString(R.string.Don_Wittmer), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Tony Cioffi", 0,getString(R.string.Tony_Cioffi), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Jason Havens", 0,getString(R.string.Jason_Havens), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Michael J. Finn", 0,getString(R.string.Michael_J_Finn), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Kristina Swallow", 0,getString(R.string.Kristina_Swallow), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Tom Smith", 0,getString(R.string.Tom_Smith), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Greg Kuklinski", 0,getString(R.string.Greg_Kuklinski), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Shawn Kelley", 0,getString(R.string.Shawn_Kelley), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Nancy Berson", 0,getString(R.string.Nancy_Berson), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Jennifer Lawrence", 0,getString(R.string.Jennifer_Lawrence), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Jesse Gormley", 0,getString(R.string.Jesse_Gormley), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "John Casana", 0,getString(R.string.John_Casana), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Chuck Black", 0,getString(R.string.Chuck_Black), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Peter Moore", 0,getString(R.string.Peter_Moore), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Robin Kemper", 0,getString(R.string.Robin_Kemper), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Francis Mahaney", 0,getString(R.string.Francis_Mahaney), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Charlie Mumford", 0,getString(R.string.Charlie_Mumford), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Maria Lehman", 0,getString(R.string.Maria_Lehman), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Raosanne Frandina", 0,getString(R.string.Raosanne_Frandina), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Melissa Burns", 0,getString(R.string.Melissa_Burns), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Kelly Dooley", 0,getString(R.string.Kelly_Dooley), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Bethany Mazur", 0,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Jason Lang", 0,getString(R.string.Jason_Lang), getString(R.string.Bio)));


        // header
        data.add(new Speaker(R.drawable.speaker_details_header, "Francis Mahaney", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Grey Kuklinski", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Jason Havens", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Kristina Swallow", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Michael J. Finn", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Nancy Berson", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Peter Moore", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Robin Kemper", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Shawn Kelley", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Tony Cioffi", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Don Wittmer", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Bethany Mazur", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        data.add(new Speaker(R.drawable.speaker_details_header, "Chuck Black", 1,getString(R.string.Bethany_Mazur), getString(R.string.Bio)));
        Collections.sort(data, (o1, o2) -> {
            if (o1.getName().charAt(0) - o2.getName().charAt(0) == 0) {
                return o2.isFirst() - o1.isFirst();
            }
            return o1.getName().charAt(0) - o2.getName().charAt(0);
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Speaker> filteredModelList = filter(data, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }
    private List<Speaker> filter(List<Speaker> list, String query) {
        Log.d("size of List", String.valueOf(list.size()));
        query = query.toLowerCase();
        final List<Speaker> filteredModelList = new ArrayList<>();
        for (Speaker model : list) {
                final String text = model.getName().toLowerCase();
                if (text.contains(query)) {
                    Log.d("is exist?", text);
                    filteredModelList.add(model);
                }
        }
        return filteredModelList;
    }
}
