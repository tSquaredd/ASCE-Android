package org.ascebuffalo.asce;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

//import Adapters.SponsorAdapter;
import Objects.ScheduleEvent;
import Objects.Sponsor;
/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorsFragment extends Fragment {

    private ViewPager mViewPager;
    private ArrayList<Sponsor> mEventList;
    private TabLayout mTabLayout;

    public SponsorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result=inflater.inflate(R.layout.fragment_sponsors, container, false);
        ViewPager pager=(ViewPager)result.findViewById(R.id.nav_pager);

        pager.setAdapter(new SponsorAdapter(getActivity(),getChildFragmentManager()));

        mTabLayout = (TabLayout)result.findViewById(R.id.nav_sponsors);
        mTabLayout.setupWithViewPager(pager);
        return result;
    }

    public class SponsorAdapter extends FragmentStatePagerAdapter {

        Context context = null;
        public SponsorAdapter (Context context, FragmentManager fm){
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment;
            ArrayList<Sponsor> eventList;
            Bundle args = new Bundle();
            fragment = new SponsorsFragment();
            eventList=testdata();
            args.putParcelableArrayList("Sponsor", eventList);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 1;
        }
        /////////////new change
//change again/////
        @Override
        public CharSequence getPageTitle(int position) {
            return "Sponsors";
        }
    }
    public ArrayList<Sponsor> testdata(){

        ArrayList<Sponsor> list = new ArrayList<>();
        Sponsor fakeEvent=new Sponsor("sponsor1", "1000","picture link");
        list.add(fakeEvent);
        Sponsor fakeEvent1=new Sponsor("sponsor12", "1100","picture link 2");
        list.add(fakeEvent1);
        Sponsor fakeEvent2=new Sponsor("sponsor13", "1200","picture link 3");
        list.add(fakeEvent2);
        Sponsor fakeEvent3=new Sponsor("sponsor14", "1300","picture link 4");
        list.add(fakeEvent3);

        return list;

    }



}
