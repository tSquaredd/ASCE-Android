package org.ascebuffalo.asce;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * Created by ziyi liu on 1/30/2018.
 */

public class CustomFragment extends Fragment {
    ImageView image;

    public CustomFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.custom_view,container,false);
        image = root.findViewById(R.id.floor_image);
        Bundle args = getArguments();
        int imageId = args.getInt("map");
        image.setImageResource(imageId);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(image);
        photoViewAttacher.update();

        return root;
    }
}
