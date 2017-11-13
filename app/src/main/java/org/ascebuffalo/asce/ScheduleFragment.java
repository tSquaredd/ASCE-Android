package org.ascebuffalo.asce;


import android.app.ActionBar;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    ScheduleAdapter mScheduleAdapter;
    ViewPager mViewPager;

    TabLayout mTabLayout;



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
            if (position == 0){
                fragment = new FridayScheduleFragment();
                return fragment;
            } else{
                fragment = new SaturdayScheduleFragment();
                return fragment;
            }
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
