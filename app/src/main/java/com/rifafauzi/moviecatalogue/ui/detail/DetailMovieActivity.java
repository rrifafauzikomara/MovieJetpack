package com.rifafauzi.moviecatalogue.ui.detail;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

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
    private Menu menu;
    private String movieId, tvShowId;
    private MovieViewModel movieViewModel;
    private TvShowViewModel tvShowViewModel;

    @NonNull
    private MovieViewModel obtainViewModelMovies(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }

    @NonNull
    private TvShowViewModel obtainViewModelTvShow(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel.class);
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

        movieViewModel = obtainViewModelMovies(this);
        tvShowViewModel = obtainViewModelTvShow(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movieId = extras.getString(EXTRA_MOVIE);
            tvShowId = extras.getString(EXTRA_TvSHOW);
            progressBar.setVisibility(View.VISIBLE);
            if (movieId != null) {
                movieViewModel.setMovieId(Integer.parseInt(movieId));
                movieViewModel.detailMovies.observe(this, movies -> {
                    if (movies != null) {

                        switch (movies.status) {
                            case LOADING:
                                progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (movies.data != null) {
                                    progressBar.setVisibility(View.GONE);
                                    progressBar.setVisibility(View.GONE);
                                    collapsingToolbarLayout.setTitle(movies.data.getTitle());
                                    textViewDate.setText(movies.data.getReleaseDate());
                                    textViewDesc.setText(movies.data.getOverview());
                                    Glide.with(getApplicationContext())
                                            .load(Contract.LINK_IMAGE + movies.data.getPosterPath())
                                            .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                                                    .error(R.drawable.ic_error))
                                            .into(imageViewPoster);
                                }
                                break;
                            case ERROR:
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });
            } else if (tvShowId != null) {
                tvShowViewModel.setTvShowId(Integer.parseInt(tvShowId));
                tvShowViewModel.detailTvShow.observe(this, tvShow -> {
                    if (tvShow != null) {

                        switch (tvShow.status) {
                            case LOADING:
                                progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (tvShow.data != null) {
                                    progressBar.setVisibility(View.GONE);
                                    collapsingToolbarLayout.setTitle(tvShow.data.getName());
                                    textViewDate.setText(tvShow.data.getFirstAirDate());
                                    textViewDesc.setText(tvShow.data.getOverview());

                                    Glide.with(getApplicationContext())
                                            .load(Contract.LINK_IMAGE + tvShow.data.getPosterPath())
                                            .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                                                    .error(R.drawable.ic_error))
                                            .into(imageViewPoster);
                                }
                                break;
                            case ERROR:
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;
        if (movieId != null) {
            movieViewModel.detailMovies.observe(this, courseWithModule -> {
                if (courseWithModule != null) {
                    switch (courseWithModule.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            if (courseWithModule.data != null) {
                                progressBar.setVisibility(View.GONE);
                                boolean state = courseWithModule.data.isFavorite();
                                setFavoriteState(state);
                            }
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        } else if (tvShowId != null) {
            tvShowViewModel.detailTvShow.observe(this, courseWithModule -> {
                if (courseWithModule != null) {
                    switch (courseWithModule.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            if (courseWithModule.data != null) {
                                progressBar.setVisibility(View.GONE);
                                boolean state = courseWithModule.data.isFavorite();
                                setFavoriteState(state);
                            }
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        } else if (item.getItemId() == R.id.action_bookmark) {
            if (movieId != null) {
                movieViewModel.setFavorite();
            } else if (tvShowId != null) {
                tvShowViewModel.setFavorite();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFavoriteState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_bookmark);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
