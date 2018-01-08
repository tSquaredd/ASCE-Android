package org.ascebuffalo.asce;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import Objects.Speaker;

public class Speaker_profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speaker_detail);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout =  findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitleEnabled(true);

        ImageView imageView = findViewById(R.id.main_backdrop);
        TextView textView = findViewById(R.id.speakers_text);
        Bundle bundle = getIntent().getExtras();

        Speaker speaker = bundle.getParcelable("speaker");
        if(speaker != null){
            Log.d("speaker init", speaker.getName() + " with selfie " + speaker.getSelfie());

            imageView.setImageResource(speaker.getSelfie());
            collapsingToolbarLayout.setTitle(speaker.getName());
//            textView.setText(speaker.getBio());
        }



        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
