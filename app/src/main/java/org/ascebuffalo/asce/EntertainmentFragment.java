package org.ascebuffalo.asce;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {



    @BindView(R.id.button_ent_see_do)
    Button mSeeDoButton;

    @BindView(R.id.button_ent_eat_drink)
    Button mEatDrinkButton;

    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_entertainment, container, false);
        ButterKnife.bind(this, view);

        setOnClickListeners();

        return view;
    }

    public void setOnClickListeners(){
        mEatDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EatAndDrinkActivity.class);
                startActivity(intent);
            }
        });

        mSeeDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeAndDoActivity.class);
                startActivity(intent);
            }
        });
    }



}
