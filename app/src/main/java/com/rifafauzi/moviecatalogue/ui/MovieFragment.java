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
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.ViewModelFactory;


public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MovieAdapter movieAdapter;

    public static Fragment newInstance() {
        return new MovieFragment();
    }

    @NonNull
    private MovieViewModel obtainViewModel() {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(this, factory).get(MovieViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_movies);
        progressBar = view.findViewById(R.id.progress_bar_movie);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            MovieViewModel movieViewModel = obtainViewModel();
            movieAdapter = new MovieAdapter(getActivity());

            movieViewModel.getListMovies().observe(this, moviesList -> {
                progressBar.setVisibility(View.GONE);
                movieAdapter.setListMovies(moviesList);
                movieAdapter.notifyDataSetChanged();
            });

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(movieAdapter);

        }
    }

}
