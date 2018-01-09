package org.ascebuffalo.asce;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeeAndDoActivity extends AppCompatActivity {

    @BindView(R.id.button_ent_art)
    Button mArtButton;

    @BindView(R.id.button_ent_architecture)
    Button mArchitectureButton;

    @BindView(R.id.button_ent_history)
    Button mHistoryButton;

    @BindView(R.id.button_ent_entertainment)
    Button mEntertainmentButton;

    @BindView(R.id.button_ent_shopping)
    Button mShoppingButton;

    private static final String ART_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/art";
    private static final String ARCHITECTURE_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/architecture";
    private static final String HISTORY_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/history-heritage";
    private static final String ENTERTAINMENT_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/entertainment";
    private static final String SHOPPING_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/shopping";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_and_do);

        ButterKnife.bind(this);

        // add action bar for back button
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setOnClickListeners();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setOnClickListeners(){
        mArchitectureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(ARCHITECTURE_URL_STRING));
                startActivity(intent);
            }
        });

        mArtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(ART_URL_STRING));
                startActivity(intent);
            }
        });

        mEntertainmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(ENTERTAINMENT_URL_STRING));
                startActivity(intent);
            }
        });

        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(HISTORY_URL_STRING));
                startActivity(intent);
            }
        });

        mShoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(SHOPPING_URL_STRING));
                startActivity(intent);
            }
        });
    }
}
