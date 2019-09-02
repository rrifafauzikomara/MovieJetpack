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
import com.rifafauzi.moviecatalogue.adapter.TvShowAdapter;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.ViewModelFactory;


public class TvShowFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TvShowAdapter tvShowAdapter;

    static Fragment newInstance() {
        return new TvShowFragment();
    }

    @NonNull
    private TvShowViewModel obtainViewModel() {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.Companion.getInstance();
        return ViewModelProviders.of(this, factory).get(TvShowViewModel.class);
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
        progressBar = view.findViewById(R.id.progress_bar_tvShow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            TvShowViewModel tvShowViewModel = obtainViewModel();
            tvShowAdapter = new TvShowAdapter(getActivity());

            tvShowViewModel.getListTvShow().observe(this, tvShowList -> {
                progressBar.setVisibility(View.GONE);
                tvShowAdapter.setListTvShow(tvShowList);
                tvShowAdapter.notifyDataSetChanged();
            });

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tvShowAdapter);

        }
    }
}
