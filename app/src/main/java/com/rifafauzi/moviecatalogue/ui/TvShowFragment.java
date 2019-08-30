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
import com.rifafauzi.moviecatalogue.adapter.TvShowAdapter;
import com.rifafauzi.moviecatalogue.model.TvShow;
import com.rifafauzi.moviecatalogue.navigator.TvShowNavigator;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;

import java.util.ArrayList;
import java.util.List;

public class TvShowFragment extends Fragment implements TvShowNavigator {

    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private TvShowAdapter tvShowAdapter;
    private List<TvShow> tvShows;

    static Fragment newInstance() {
        return new TvShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_tvShow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            TvShowViewModel tvShowViewModel = new TvShowViewModel(Injection.repository());
            tvShows = new ArrayList<>();
            tvShowViewModel.setTvShowNavigator(this);
            tvShowViewModel.getListTvShow();

            tvShowAdapter = new TvShowAdapter(tvShows);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tvShowAdapter);
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
    public void loadListTvShow(List<TvShow> tvShowList) {
        tvShows.addAll(tvShowList);
        tvShowAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListTvShow(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
