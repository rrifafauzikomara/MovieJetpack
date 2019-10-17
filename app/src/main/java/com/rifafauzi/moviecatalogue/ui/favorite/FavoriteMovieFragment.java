package com.rifafauzi.moviecatalogue.ui.favorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.adapter.FavoriteMoviePagedListAdapter;
import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteMovieFragment extends Fragment {

    private FavoriteMoviePagedListAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MovieViewModel viewModel;

    public FavoriteMovieFragment() {
        // Required empty public constructor
    }

    @NonNull
    private MovieViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_movies_favorite);
        progressBar = view.findViewById(R.id.progress_bar_movie_favorite);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            viewModel = obtainViewModel(getActivity());

            adapter = new FavoriteMoviePagedListAdapter(getActivity());

            viewModel.getFavorite().observe(this, courses -> {
                if (courses != null) {
                    switch (courses.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            adapter.submitList(courses.data);
                            adapter.notifyDataSetChanged();
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
            recyclerView.setAdapter(adapter);


            //Memberikan aksi untuk swipe
            itemTouchHelper.attachToRecyclerView(recyclerView);

        }
    }

    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();
                MoviesEntity moviesEntity = adapter.getItemById(swipedPosition);
                viewModel.setBookmark(moviesEntity);
                Snackbar snackbar = Snackbar.make(getView(), "Batalkan menghapus item sebelumnya?", Snackbar.LENGTH_LONG);
                snackbar.setAction("Ok", v -> viewModel.setBookmark(moviesEntity));
                snackbar.show();
            }
        }
    });

}