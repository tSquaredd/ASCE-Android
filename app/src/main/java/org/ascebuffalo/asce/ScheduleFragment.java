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
                eventList = fridayTestData();

            } else{
                // Saturday
                eventList = saturdayTestData();
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

    public ArrayList<ScheduleEvent> fridayTestData(){

        ArrayList<ScheduleEvent> list = new ArrayList<>();
        ScheduleEvent fakeEvent = new ScheduleEvent("Registration / Breakfast", "7:15 am", "7:45 am", "Bristol Bay Ballroom");
        list.add(fakeEvent);
        fakeEvent = new ScheduleEvent("Welcome", "7:45 am", "8:15 am", "Bristol Bay Ballroom");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("A Glimpse in ASCE", "8:15 am", "9:15 am", "Bristol Bay Ballroom");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Networking Break", "9:15 am", "9:30 am", "Promenade");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("CYM Overview", "9:30 am", "9:50 am", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Round Table Discussions", "9:50 am", "10:50 am", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Community Engineering Corps", "10:50 am", "11:15 am", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Conflict Resolution", "11:15 am", "12:00 pm", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Networking Lunch", "12:00 pm", "12:40 pm", "Alaska/Denali");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Society President-Elect", "12:40 pm", "1:00 pm", "Alaska/Denali");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Region Breakouts Sessions", "1:05 pm", "2:45 pm", "Alaska/Denali");
        list.add(fakeEvent);

        return list;

    }

    public ArrayList<ScheduleEvent> saturdayTestData(){

        ArrayList<ScheduleEvent> list = new ArrayList<>();
        ScheduleEvent fakeEvent = new ScheduleEvent("Coffee with 2017 President-Elect", "7:00 am", "7:45 am", "Alaska/Denali");
        list.add(fakeEvent);
        fakeEvent = new ScheduleEvent("Networking Breakfast", "7:45 am", "8:20 am", "Alaska/Denali");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Generational Differences", "8:20 am", "9:10 am", "Alaska/Denali");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Creating a Succesful Mentor/Protege Program", "9:10 am", "9:30 am", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Best Practices: Student Engagement", "9:30 am", "9:50 am", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Alaska & Arctic Infrastructure Development", "9:50 am", "10:15 am", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Networking Break", "10:15 am", "10:30 am", "Promenade");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Buisness Meeting", "10:35 am", "12:15 pm", "Aleutian Room");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Leadership Lunch: ILC Keynote \"What Makes a Leader?", "12:15 pm", "1:25 pm", "Alaska/Denali");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Blue Technical Tour - Port of Anchorage", "1:25 pm", "5:00 pm", "Meet in Hotel Lobby");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Green Technical Tour - Anchorage Landfill", "1:25 pm", "5:00 pm", "Meet in Hotel Lobby");
        list.add(fakeEvent);

        fakeEvent = new ScheduleEvent("Red Technical Tour - Fish Hatchery", "1:25 pm", "5:00 pm", "Meet in Hotel Lobby");
        list.add(fakeEvent);

        return list;

    }


}
