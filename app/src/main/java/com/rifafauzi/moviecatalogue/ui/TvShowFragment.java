package com.rifafauzi.moviecatalogue.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.adapter.MovieAdapter;
import com.rifafauzi.moviecatalogue.adapter.TvShowAdapter;
import com.rifafauzi.moviecatalogue.model.MovieModel;
import com.rifafauzi.moviecatalogue.model.TvShowModel;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TvShowAdapter tvShowAdapter;
    private TvShowViewModel tvShowViewModel;
    private List<TvShowModel> tvShowModels;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_tvShow);
        progressBar = view.findViewById(R.id.progress_bar_tvShow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
            tvShowModels = tvShowViewModel.getTvShow();

            tvShowAdapter = new TvShowAdapter(getActivity());
            tvShowAdapter.setListTvShow(tvShowModels);

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tvShowAdapter);
        }
    }

}
