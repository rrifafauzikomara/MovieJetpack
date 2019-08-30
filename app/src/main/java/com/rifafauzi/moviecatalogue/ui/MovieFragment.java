package com.rifafauzi.moviecatalogue.ui;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rifafauzi.moviecatalogue.Injection;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.adapter.MovieAdapter;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.navigator.MoviesNavigator;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment implements MoviesNavigator {

    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private MovieAdapter movieAdapter;
    private List<Movies> movies;

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
            MovieViewModel movieViewModel = new MovieViewModel(Injection.repository());
            movies = new ArrayList<>();
            movieViewModel.setMoviesNavigator(this);
            movieViewModel.getListMovies();
            movieAdapter = new MovieAdapter(movies);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(movieAdapter);
        }
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.setTitle("Harap tunggu");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void loadListMovies(List<Movies> moviesList) {
        movies.addAll(moviesList);
        movieAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListMovies(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
