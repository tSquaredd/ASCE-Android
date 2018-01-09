package org.ascebuffalo.asce;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventMapFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    public EventMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_event_map, container, false);

        Spinner spinner = root.findViewById(R.id.spinner2);
//        AppCompatActivity activity =(AppCompatActivity) root.getContext();
//        activity.getSupportActionBar();
//        if(activity.getSupportActionBar()!=null){
//            activity.getSupportActionBar().setElevation(0);
//        }

        ArrayAdapter adapter = ArrayAdapter.createFromResource(root.getContext(),R.array.floor,R.layout.event_map_spinner_item);
        adapter.setDropDownViewResource(R.layout.event_map_spinner_dropdown_item);
        spinner.getBackground().setColorFilter(getResources().getColor(R.color.whiteArrow), PorterDuff.Mode.SRC_ATOP);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ImageView photoView = getActivity().findViewById(R.id.floor_image);
        photoView.setImageResource(R.drawable.event_map_second_floor);
        PhotoViewAttacher photoViewAttacher;
        switch(i){
            case 0:
                photoView.setImageResource(R.drawable.event_map_first_floor);
                photoViewAttacher = new PhotoViewAttacher(photoView);
                photoViewAttacher.update();
                break;
            case 1:
                photoView.setImageResource(R.drawable.event_map_second_floor);
                photoViewAttacher = new PhotoViewAttacher(photoView);
                photoViewAttacher.update();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
