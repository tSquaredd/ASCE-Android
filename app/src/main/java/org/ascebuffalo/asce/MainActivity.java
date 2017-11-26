package org.ascebuffalo.asce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        // intitialize home fragmet
        Fragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Switch Fragment based on users selection from the nav drawer
        int id = item.getItemId();

        Fragment fragment;

        // TODO: Could switch this to a switch statement for small increase in performance ?

        if (id == R.id.nav_home) {
            // Handle the camera action
            fragment = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("Home");

            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        } else if (id == R.id.nav_schedule) {

            fragment = new ScheduleFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("Schedule");

            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        } else if (id == R.id.nav_speakers) {

            fragment = new SpeakersFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("Speakers");

            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        } else if (id == R.id.nav_sponsors) {

            fragment = new SponsorsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("Sponsors");

            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();


        } else if (id == R.id.nav_program) {

            fragment = new ProgramFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("Program");

            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        } else if (id == R.id.nav_event_map){

            fragment = new EventMapFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("Event Map");

            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }else if (id == R.id.nav_entertainment){

            fragment = new EntertainmentFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("Entertainment");

            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }else if (id == R.id.nav_facebook) {

            /* TODO: Thinkin instead of fragment just go to facebook on users prefered web browser

                The other option is to use a webview and have the facebook load within our app
                however, I have done this before and it usually looks and functions better
                if you just have it go to web browser...

                OR we could see if we can also have it open right to the facebook app..
                could create an issue if user doesnt have facebook app installed..

                We will have to look into this further

                -- TYLER
            */
        } else if(id == R.id.nav_twitter){

            fragment = new TwitterFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            setTitle("twitter");
            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
