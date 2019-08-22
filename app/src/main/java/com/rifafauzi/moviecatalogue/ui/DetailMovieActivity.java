package com.rifafauzi.moviecatalogue.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.model.MovieModel;
import com.rifafauzi.moviecatalogue.model.TvShowModel;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TVSHOW = "extra_tvShow";
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TextView textViewDate, textViewDesc;
    private ImageView imageViewPoster;
    private MovieViewModel movieViewModel;
    private TvShowViewModel tvShowViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);

        collapsingToolbarLayout = findViewById(R.id.collapsingDetail);
        textViewDate = findViewById(R.id.tgl);
        textViewDesc = findViewById(R.id.desc);
        imageViewPoster = findViewById(R.id.poster);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            String tvShowId = extras.getString(EXTRA_TVSHOW);
            if (movieId != null) {
                setMovie(movieViewModel.getMovieModel(movieId));
            } else if (tvShowId != null) {
                setTvShow(tvShowViewModel.getTvShowModel(tvShowId));
            }
        }

    }

    private void setMovie(MovieModel movie) {
        collapsingToolbarLayout.setTitle(movie.getTitle());
        textViewDate.setText(movie.getRelease());
        textViewDesc.setText(movie.getDescription());

        Glide.with(getApplicationContext())
                .load(getApplicationContext().getResources().getIdentifier(movie.getImagePath(),
                        "drawable", getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                        .error(R.drawable.ic_error))
                .into(imageViewPoster);
    }

    private void setTvShow(TvShowModel tvShow) {
        collapsingToolbarLayout.setTitle(tvShow.getTitle());
        textViewDate.setText(tvShow.getRelease());
        textViewDesc.setText(tvShow.getDescription());

        Glide.with(getApplicationContext())
                .load(getApplicationContext().getResources().getIdentifier(tvShow.getImagePath(),
                        "drawable", getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                        .error(R.drawable.ic_error))
                .into(imageViewPoster);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
