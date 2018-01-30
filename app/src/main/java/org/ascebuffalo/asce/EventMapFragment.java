package org.ascebuffalo.asce;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventMapFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    public EventMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_event_map, container, false);
        tabLayout = root.findViewById(R.id.nav_map_tabs);
        viewPager = root.findViewById(R.id.map_pager);

        adapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        return root;
    }
    public class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new CustomFragment();
            Bundle args = new Bundle();
            int imageId = 0;
            switch (position){
                case 0:
                    imageId = R.drawable.buffalo_airtport_terminate_map;
                    break;
                case 1:
                    imageId= R.drawable.rail_map;
                    break;
                case 2:
                    imageId = R.drawable.event_map_first_floor;
                    break;
                case 3:
                    imageId = R.drawable.event_map_second_floor;
                    break;
            }
            args.putInt("map",imageId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return "Airport";
                case 1:
                    return "NFTA Rail";
                case 2:
                    return "Hotel First Floor";
                case 3:
                    return "Hotel second Floor";
            }
            return null;
        }
    }
}
