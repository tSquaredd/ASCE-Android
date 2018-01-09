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

public class EatAndDrinkActivity extends AppCompatActivity {

    @BindView(R.id.button_ent_coffee)
    Button mCoffeeButton;

    @BindView(R.id.button_ent_bars)
    Button mBarsButton;

    @BindView(R.id.button_ent_restaraunts)
    Button mRestarauntButton;

    @BindView(R.id.button_ent_breweries)
    Button mBreweriesButton;

    private static final String COFFEE_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/coffee-shops-bakeries/";
    private static final String BARS_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/bars/";
    private static final String RESTARAUNTS_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/restaurants/";
    private static final String BREWERIES_URL_STRING = "http://www.visitbuffaloniagara.com/business-type/business-type/craft-beer/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_and_drink);

        ButterKnife.bind(this);

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
        mCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(COFFEE_URL_STRING));
                startActivity(intent);
            }
        });

        mBarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(BARS_URL_STRING));
                startActivity(intent);
            }
        });

        mBreweriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(BREWERIES_URL_STRING));
                startActivity(intent);
            }
        });

        mRestarauntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(RESTARAUNTS_URL_STRING));
                startActivity(intent);
            }
        });
    }
}
