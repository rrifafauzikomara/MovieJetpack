package com.rifafauzi.moviecatalogue.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.model.MovieModel;
import com.rifafauzi.moviecatalogue.model.TvShowModel;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TvSHOW = "extra_tvShow";
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TextView textViewDate, textViewDesc;
    private ImageView imageViewPoster;
    MovieViewModel movieViewModel;
    TvShowViewModel tvShowViewModel;
    private FloatingActionButton btnTrailer;

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
        btnTrailer = findViewById(R.id.btn_trailer);
        textViewDate = findViewById(R.id.tgl);
        textViewDesc = findViewById(R.id.desc);
        imageViewPoster = findViewById(R.id.poster);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            String tvShowId = extras.getString(EXTRA_TvSHOW);
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

        btnTrailer.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.getYoutube()));
            startActivity(intent);
        });
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

        btnTrailer.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvShow.getYoutube()));
            startActivity(intent);
        });
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
