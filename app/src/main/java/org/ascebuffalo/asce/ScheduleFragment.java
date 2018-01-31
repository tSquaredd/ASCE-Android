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

import Objects.ScheduleEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private ScheduleAdapter mScheduleAdapter;
    private ViewPager mViewPager;
    private ArrayList<ScheduleEvent> mEventList;
    private TabLayout mTabLayout;



    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result=inflater.inflate(R.layout.fragment_schedule, container, false);
        getActivity().setTitle("Schedule");
        ViewPager pager=(ViewPager)result.findViewById(R.id.nav_pager);

        pager.setAdapter(new ScheduleAdapter(getActivity(), getChildFragmentManager()));

        mTabLayout = (TabLayout)result.findViewById(R.id.nav_schedule_tabs);
        mTabLayout.setupWithViewPager(pager);



        return(result);


    }

    public class ScheduleAdapter extends FragmentStatePagerAdapter {

        Context context = null;
        public ScheduleAdapter (Context context, FragmentManager fm){
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment;
            ArrayList<ScheduleEvent> eventList;
            Bundle args = new Bundle();
            fragment = new DayScheduleFragment();

            if (position == 0){
                // Friday
                eventList = ScheduleEvent.fridayScheduleData();

            } else{
                // Saturday
                eventList = ScheduleEvent.saturdayEventSchedule();
            }

            args.putParcelableArrayList("events", eventList);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return "Friday";
            }else{
                return "Saturday";
            }
        }
    }

}
