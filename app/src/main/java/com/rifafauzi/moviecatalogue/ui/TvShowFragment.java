package com.rifafauzi.moviecatalogue.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rifafauzi.moviecatalogue.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {


    public TvShowFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new TvShowFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

}
