package org.ascebuffalo.asce;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

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
        data = Speaker.getData();
        adapter = new SpeakerAdapter(getActivity(),data, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
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
