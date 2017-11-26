package org.ascebuffalo.asce;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import Objects.Speaker;

public class Speaker_profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_profile);

        ImageView imageView = findViewById(R.id.speakers_image);
        TextView textView = findViewById(R.id.speakers_text);
        Bundle bundle = getIntent().getExtras();
        Speaker speaker = bundle.getParcelable("speaker");
        if(speaker != null){
            Log.d("speaker init", speaker.getName() + " with selfie " + speaker.getSelfie());

            imageView.setImageResource(speaker.getSelfie());
            textView.setText(speaker.getName());
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
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
