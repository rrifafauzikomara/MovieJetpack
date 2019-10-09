package com.rifafauzi.moviecatalogue.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.adapter.TvShowAdapter;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.ViewModelFactory;

import static com.rifafauzi.moviecatalogue.helper.vo.Status.LOADING;


public class TvShowFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TvShowAdapter tvShowAdapter;

    public static Fragment newInstance() {
        return new TvShowFragment();
    }

    @NonNull
    private TvShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel.class);
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
            TvShowViewModel tvShowViewModel = obtainViewModel(getActivity());
            tvShowAdapter = new TvShowAdapter(getActivity());
            tvShowViewModel.setUsername("Dicoding");
            tvShowViewModel.tvShow.observe(this, tvShowList -> {
                if (tvShowList != null) {
                    switch (tvShowList.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            tvShowAdapter.setListTvShow(tvShowList.data);
                            tvShowAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            });

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tvShowAdapter);

        }
    }
}
