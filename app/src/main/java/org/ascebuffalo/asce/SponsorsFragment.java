package org.ascebuffalo.asce;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.String;

import java.util.ArrayList;

import Adapters.SponsorAdapter;

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



        View result=inflater.inflate(R.layout.fragment_sponsors, container, false);
        ViewPager pager=(ViewPager)result.findViewById(R.id.nav_pager);

        pager.setAdapter(new SponsorAdapter(getActivity(),getChildFragmentManager()));

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
            fragment = new SponsorFragment();
            eventList=testdata();
            args.putParcelableArrayList("Sponsor", eventList);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 1;
        }
/*
        @Override
        public CharSequence getPageTitle(int position) {
            return "Sponsors";
        }
  */
    }
    public static ArrayList<Sponsor> testdata(){

        ArrayList<Sponsor> list = new ArrayList<>();
        Sponsor fakeEvent=new Sponsor("sponsor1", R.mipmap.ic_launcher,"donate: $1000","this is the description for our first sponsor: balalalalalalalallalalalalaala");
        list.add(fakeEvent);

        Sponsor fakeEvent1=new Sponsor("sponsor12", R.drawable.ic_action_facebook,"donate: $2000","Michael Joseph Jackson (August 29, 1958 – June 25, 2009) was an American singer, songwriter, and dancer. Dubbed the \"King of Pop\", he was one of the most popular entertainers in the world, and was the best-selling music artist during the year of his death.[1][2] Jackson's contributions to music, dance, and fashion[3][4][5] along with his publicized personal life made him a global figure in popular culture for over four decades.\n" +
                "\n" +
                "The eighth child of the Jackson family, Michael made his professional debut in 1964 with his elder brothers Jackie, Tito, Jermaine, and Marlon as a member of the Jackson 5. He began his solo career in 1971 while at Motown Records. In the early 1980s, Jackson became a dominant figure in popular music. His music videos, including those of \"Beat It\", \"Billie Jean\", and \"Thriller\" from his 1982 album Thriller, are credited with breaking racial barriers and transforming the medium into an art form and promotional tool. The popularity of these videos helped bring the television channel MTV to fame. Jackson's 1987 album Bad spawned the U.S. Billboard Hot 100 number-one singles \"I Just Can't Stop Loving You\", \"Bad\", \"The Way You Make Me Feel\", \"Man in the Mirror\", and \"Dirty Diana\", becoming the first album to have five number-one singles in the nation. He continued to innovate with videos such as \"Black or White\" and \"Scream\" throughout the 1990s, and forged a reputation as a touring solo artist. Through stage and video performances, Jackson popularized a number of complicated dance techniques, such as the robot and the moonwalk, to which he gave the name. His distinctive sound and style has influenced numerous artists of various music genres.");
        list.add(fakeEvent1);
        Sponsor fakeEvent2=new Sponsor("sponsor13", R.drawable.ic_action_twitter,"donate: $3000","this is the description for our third sponsor: hualalalalalalalalalallalalalalala");
        list.add(fakeEvent2);
        Sponsor fakeEvent3=new Sponsor("sponsor14", R.drawable.ic_action_business,"donate: $4000","this is the description for our fourth sponsor: duanglalalalalalalalalallalaallalala");
        list.add(fakeEvent3);


        return list;

    }




}
