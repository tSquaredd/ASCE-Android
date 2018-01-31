package org.ascebuffalo.asce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.pdf_welcome)
    PDFView welcomePdfView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Welcome");
        ButterKnife.bind(this, view);

        File f = new File(getActivity().getCacheDir()+"/welcome.pdf");
        if (!f.exists()) try {

            InputStream is = getActivity().getAssets().open("welcome.pdf");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();


            FileOutputStream fos = new FileOutputStream(f);
            fos.write(buffer);
            fos.close();
        } catch (Exception e) { throw new RuntimeException(e); }

        welcomePdfView.fromFile(f)
                .enableAntialiasing(true)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .spacing(4).load();

        return view;
    }

}
