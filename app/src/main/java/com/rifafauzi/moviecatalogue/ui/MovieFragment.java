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

import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.adapter.MovieAdapter;
import com.rifafauzi.moviecatalogue.model.MovieModel;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;

    public MovieFragment() {
        // Required empty public constructor
    }

    static Fragment newInstance() {
        return new MovieFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_movies);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
            List<MovieModel> movieModels = movieViewModel.getMovie();

            MovieAdapter movieAdapter = new MovieAdapter(getActivity());
            movieAdapter.setListMovie(movieModels);

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(movieAdapter);
        }
    }
}
