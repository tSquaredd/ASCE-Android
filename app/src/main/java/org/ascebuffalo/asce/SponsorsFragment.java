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

import Adapters.SponsorAdapter;
import Objects.Sponsor;
/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorsFragment extends Fragment {

    private List<Sponsor> data = new ArrayList<>();
    private SponsorAdapter adapter;

    public SponsorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_sponsors, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_sponsor);
        data = Sponsor.getData();
        adapter = new SponsorAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setHasOptionsMenu(true);

        return root;
    }


}
