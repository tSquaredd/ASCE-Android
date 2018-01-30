package org.ascebuffalo.asce;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MenuItem itemToHide;
    private Fragment current_fragment;
    DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        current_fragment = new HomeFragment();
        drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {}

            @Override
            public void onDrawerOpened(View drawerView) {}

            @Override
            public void onDrawerStateChanged(int newState) {}

            @Override
            public void onDrawerClosed(View drawerView) {
                if (current_fragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                    transaction.replace(R.id.content_frame, current_fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    current_fragment = null;
                }
            }
        });


        // intitialize home fragmet
        Fragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
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
        itemToHide = menu.findItem(R.id.action_search);
        itemToHide.setVisible(false);

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
        // TODO: Could switch this to a switch statement for small increase in performance ?

        switch(item.getItemId()){
            case R.id.nav_home:
                current_fragment = new HomeFragment();
                setTitle("Welcome");
                break;
            case R.id.nav_schedule:
                current_fragment = new ScheduleFragment();
                setTitle("Schedule");
                break;
            case R.id.nav_speakers:
                current_fragment = new SpeakersFragment();
                setTitle("Speakers");
                break;
            case R.id.nav_sponsors:
                current_fragment = new SponsorsFragment();
                setTitle("Sponsors");
                break;
            case R.id.nav_program:
                current_fragment = new ProgramFragment();
                setTitle("Program");
                break;
            case R.id.nav_event_map:
                current_fragment = new EventMapFragment();
                setTitle("Maps");
                break;
            case R.id.nav_entertainment:
//                current_fragment = new EntertainmentFragment();
//                setTitle("Entertainment");

                // Alternate recomendations based on client specs
                Intent entertainmentIntent = new Intent(Intent.ACTION_VIEW);
                entertainmentIntent.setData(Uri.parse("http://ascebuffalo.org/recommendations/"));
                startActivity(entertainmentIntent);
                break;
            case R.id.nav_groupme:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://groupme.com/join_group/33044875/JACRv8"));
                startActivity(intent);
                break;
            case R.id.nav_twitter:
                current_fragment = new TwitterFragment();
                setTitle("Twitter");
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
