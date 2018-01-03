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
                eventList = fridayScheduleData();

            } else{
                // Saturday
                eventList = saturdayEventSchedule();
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

    public ArrayList<ScheduleEvent> fridayScheduleData(){
        String[] presenterList;
        String[] moderatorList;
        String[] leaderList;


        ArrayList<ScheduleEvent> list = new ArrayList<>(15);
        ScheduleEvent event = new ScheduleEvent("Registration / Continental Breakfast",
                "7:00", "7:45",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Don Wittmer";

        presenterList = new String[5];
        presenterList[0] = "Tony Cioffi";
        presenterList[1] = "Jason Havens";
        presenterList[2] = "Michael J. Finn";
        presenterList[3] = "Kristina Swallow";
        presenterList[4] = "Tom Smith";


        event = new ScheduleEvent("Welcome",
                "7:45", "8:15",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC",
                null);

        list.add(event);

        moderatorList = new String[2];
        moderatorList[0] = "Greg Kuklinksi";
        moderatorList[1] = "Shawn Kelley";

        presenterList = new String[2];
        presenterList[0] = "Nancy Berson";
        presenterList[1] = "Jennifer Lawrence";

        event = new ScheduleEvent("ASCE Live",
                "8:15", "9:15",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC",
                "Learn about the ins and outs of ASCE including the organization, structure, " +
                        "and internal workings."
                );

        list.add(event);

        event = new ScheduleEvent("Break",
                "9:15", "9:30",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null
                );

        list.add(event);

        presenterList = new String[1];
        presenterList[0] = "Jesse Gormley";

        event = new ScheduleEvent("Flipping the Script on Networking",
                "9:30", "10:30",
                "ROOM**",
                presenterList,
                null,
                null,
                null,
                "ERYMC / WSCL",
                null);

        list.add(event);

        leaderList = new String[4];
        leaderList[0] = "Tony Cioffi (ROOM**)";
        leaderList[1] = "John Casana (ROOM**)";
        leaderList[2] = "Chuck Black (ROOM**)";
        leaderList[3] = "Peter Moore (ROOM**)";

        event = new ScheduleEvent("Region Breakout Session",
                "10:30", "12:00",
                "Depends on Section",
                null,
                null,
                leaderList,
                null,
                "WSBL / ERYMC / WSCL",
                "Join others from your region and learn new names and faces; " +
                        "acquire new skills with a fun filled icebreaker.\n" +
                        "Region leaders meet with their respective section / branch leaders, Younger member leaders " +
                        "and Student chapter leaders."
                );

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Peter Moore";

        event = new ScheduleEvent("Networking Lunch",
                "12:00", "12:40",
                "Grand B-G",
                null,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        presenterList = new String[1];
        presenterList[0] = "Robin Kemper";

        event = new ScheduleEvent("Society Speaker",
                "12:40", "12:55",
                "Grand B-G",
                presenterList,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        presenterList = new String[1];
        presenterList[0] = "Jesse Gormley";

        event = new ScheduleEvent("CYM Town Hall and Rountables",
                "1:15", "2:45",
                "Grand B-G",
                presenterList,
                null,
                null,
                null,
                "ERYMC",
                "Roundtable topics include: Fundraising, Government Affairs, Professional Development, " +
                        "University Outreach and Job Fair, K-12 and Community Outreach, Social Media and Marketing, " +
                        "Social and Networking Events, Increasing Membership, and Board Recruitment and Retention");

        list.add(event);

        event = new ScheduleEvent("ERYMC Group Photo",
                "2:30", "2:45",
                "Announcement made prior on location",
                null,
                null,
                null,
                null,
                null,
                null);

        list.add(event);

        event = new ScheduleEvent("Networking Break",
                "2:45", "3:00",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "John Casana";

        leaderList = new String[3];
        leaderList[0] = "Kristina Swallow";
        leaderList[1] = "Robin Kemper";
        leaderList[2] = "Tom Smith";

        event = new ScheduleEvent("Society Leaders Q&A",
                "3:05", "4:00",
                "Regency Ballroom",
                null,
                moderatorList,
                leaderList,
                null,
                "WSBL / ERYMC",
                null);

        list.add(event);

        presenterList = new String[2];
        presenterList[0] = "Nancy Berson";
        presenterList[1] = "Shawn Kelley";

        event = new ScheduleEvent("\"The ASCE Adventure\" Awards Presentation",
                "4:00", "4:15",
                "Regency Ballroom",
                presenterList,
                null,
                null,
                null,
                "WSBL / ERYMC",
                null);

        moderatorList = new String[1];
        moderatorList[0] = "Francis Mahaney";

        presenterList = new String[1];
        presenterList[0] = "Charlie Mumford";

        event = new ScheduleEvent("How to execute a successful ASCE K-12 Outreach Event from start to finish",
                "4:15", "5:15",
                "ROOM**",
                presenterList,
                moderatorList,
                null,
                null,
                "ERYMC",
                null);

        list.add(event);

        event = new ScheduleEvent("Joint Social",
                "6:00", "7:00",
                "Pearl Street Grill",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Ticketed event. Appetizers and drink tickets provided. Location accesible by public tranist and/or walking.");

        list.add(event);

        return list;
    }

    public ArrayList<ScheduleEvent> saturdayEventSchedule() {
        String[] presenterList;
        String[] moderatorList;
        String[] leaderList;


        ArrayList<ScheduleEvent> list = new ArrayList<>(11);
        ScheduleEvent event = new ScheduleEvent("Networking Breakfast",
                "7:30", "8:00",
                "Grand B-G",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Meet new friends and learn their stories; Swap buisness cards; learn what " +
                        "classes students enjoy and why they want to be Civil Engineers");

        list.add(event);

        event = new ScheduleEvent("Coffee with the 2019 President-Elect Nominees",
                "8:00", "8:30",
                "Grand B-G",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Chuck Black";

        presenterList = new String[1];
        presenterList[0] = "Maria Lehman";

        event = new ScheduleEvent("Managing the Disruption of the Civil Engineering Profession",
                "8:30", "9:15",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Jason Havens";

        presenterList = new String[2];
        presenterList[0] = "Raosanne Frandina";
        presenterList[1] = "Stacy M. Kubit";

        event = new ScheduleEvent("The good, the bad, and where we should take MWBE policy",
                "9:20", "10:15",
                "Grand E-G",
                presenterList,
                moderatorList,
                null,
                null,
                "ERYMC",
                null);

        list.add(event);

        event = new ScheduleEvent("Networking Break",
                "10:15", "10:30",
                "Pre-function Area",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                null);

        presenterList = new String[1];
        presenterList[0] = "Melissa Burns";

        event = new ScheduleEvent("Business Meeting",
                "10:30", "12:10",
                "Grand E-G",
                presenterList,
                null,
                null,
                null,
                "ERYMC",
                null);

        list.add(event);

        event = new ScheduleEvent("Leadership Lunch",
                "12:15", "12:35",
                "Grand B-G",
                null,
                null,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Enjoy lunch with new friends and sicuss the events of the weekend; Share new ideas and actions you learned from the weekend sessions");

        list.add(event);

        moderatorList = new String[1];
        moderatorList[0] = "Don Wittmer";

        presenterList = new String[1];
        presenterList[0] = "Nicholas M. DeNichilo";

        event = new ScheduleEvent("ASCE Industry Leaders Council Keynote: \"XXXXX\"",
                "12:35", "1:25",
                "Grand B-G",
                presenterList,
                moderatorList,
                null,
                null,
                "WSBL / ERYMC / WSCL",
                "Learn from those who have made leading others a career goal and found success"
                );

        list.add(event);

        moderatorList = new String[2];
        moderatorList[0] = "Jason Havens";
        moderatorList[1] = "Francis Mahaney";

        presenterList = new String[2];
        presenterList[0] = "Kelly Dooley";
        presenterList[1] = "Jason Lang";

        event = new ScheduleEvent("Should we Raise the Bar?",
                "1:30", "2:30",
                "Grand B-G",
                null,
                moderatorList,
                null,
                presenterList,
                "ERYMC",
                null);

        list.add(event);

        return list;

    }





}
