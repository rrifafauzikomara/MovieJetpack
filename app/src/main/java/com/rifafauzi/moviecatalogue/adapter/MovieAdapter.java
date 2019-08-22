package com.rifafauzi.moviecatalogue.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.model.MovieModel;
import com.rifafauzi.moviecatalogue.ui.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final Activity activity;
    private List<MovieModel> movieModels = new ArrayList<>();

    public MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<MovieModel> getMovieModels() {
        return movieModels;
    }

    public void setListMovie(List<MovieModel> listMovie) {
        if (listMovie == null) return;
        this.movieModels.clear();
        this.movieModels.addAll(listMovie);
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        holder.textViewTitle.setText(getMovieModels().get(position).getTitle());
        holder.textViewDesc.setText(getMovieModels().get(position).getDescription());
        holder.textViewDate.setText(getMovieModels().get(position).getRelease());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getMovieModels().get(position).getMovieId());
            activity.startActivity(intent);
        });
        Glide.with(holder.itemView.getContext())
                .load(activity.getApplicationContext().getResources().getIdentifier(getMovieModels().get(position).getImagePath(), "drawable", activity.getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                        .error(R.drawable.ic_error))
                .into(holder.imageViewPoster);

    }

    @Override
    public int getItemCount() {
        return getMovieModels().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        final TextView textViewTitle;
        final TextView textViewDesc;
        final TextView textViewDate;
        final ImageView imageViewPoster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.movie_name);
            textViewDesc = itemView.findViewById(R.id.movie_desc);
            textViewDate = itemView.findViewById(R.id.movie_date);
            imageViewPoster = itemView.findViewById(R.id.movie_poster);
        }
    }
}
