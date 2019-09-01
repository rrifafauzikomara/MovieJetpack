package com.rifafauzi.moviecatalogue.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.adapter.Contract;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TvSHOW = "extra_tvShow";
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TextView textViewDate, textViewDesc;
    private ImageView imageViewPoster;
    private ProgressBar progressBar;

    @NonNull
    private MovieViewModel obtainViewModelMovies() {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(this, factory).get(MovieViewModel.class);
    }

    @NonNull
    private TvShowViewModel obtainViewModelTvShow() {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(this, factory).get(TvShowViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbarLayout = findViewById(R.id.collapsingDetail);
        textViewDate = findViewById(R.id.tgl);
        textViewDesc = findViewById(R.id.desc);
        imageViewPoster = findViewById(R.id.poster);
        progressBar = findViewById(R.id.progress_bar_detail);

        MovieViewModel movieViewModel = obtainViewModelMovies();
        TvShowViewModel tvShowViewModel = obtainViewModelTvShow();

        int movieId = getIntent().getIntExtra(EXTRA_MOVIE, 0);
        int tvShowId = getIntent().getIntExtra(EXTRA_TvSHOW, 0);
        if (movieId != 0) {
            progressBar.setVisibility(View.VISIBLE);
            movieViewModel.getDetailMovie(movieId).observe(this, movies -> {
                progressBar.setVisibility(View.GONE);
                collapsingToolbarLayout.setTitle(movies.getTitle());
                textViewDate.setText(movies.getReleaseDate());
                textViewDesc.setText(movies.getOverview());
                Glide.with(getApplicationContext())
                        .load(Contract.LINK_IMAGE + movies.getPosterPath())
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                                .error(R.drawable.ic_error))
                        .into(imageViewPoster);
            });
        } else if (tvShowId != 0) {
            progressBar.setVisibility(View.VISIBLE);
            tvShowViewModel.getDetailTvShow(tvShowId).observe(this, tvShow -> {
                progressBar.setVisibility(View.GONE);
                collapsingToolbarLayout.setTitle(tvShow.getName());
                textViewDate.setText(tvShow.getReleaseDate());
                textViewDesc.setText(tvShow.getOverview());

                Glide.with(getApplicationContext())
                        .load(Contract.LINK_IMAGE + tvShow.getPosterPath())
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                                .error(R.drawable.ic_error))
                        .into(imageViewPoster);
            });
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
