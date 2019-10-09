package com.rifafauzi.moviecatalogue.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.ui.detail.DetailMovieActivity;

public class FavoriteMoviePagedListAdapter extends PagedListAdapter<MoviesEntity, FavoriteMoviePagedListAdapter.MovieViewHolder> {

    private final Activity activity;

    public FavoriteMoviePagedListAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    private static DiffUtil.ItemCallback<MoviesEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MoviesEntity>() {
                @Override
                public boolean areItemsTheSame(MoviesEntity oldMovie, MoviesEntity newMovie) {
                    return oldMovie.getTitle().equals(newMovie.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(MoviesEntity oldMovie, @NonNull MoviesEntity newMovie) {
                    return oldMovie.equals(newMovie);
                }
            };

    public MoviesEntity getItemById(int swipedPosition) {
        return getItem(swipedPosition);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MoviesEntity data = getItem(position);
        if (data != null) {
            holder.textViewTitle.setText(data.getTitle());
            holder.textViewDesc.setText(data.getOverview());
            holder.textViewDate.setText(data.getReleaseDate());
            Glide.with(holder.itemView.getContext())
                    .load(Contract.LINK_IMAGE + data.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.img_default_bg)
                            .error(R.drawable.ic_error))
                    .into(holder.imageViewPoster);
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(activity, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, String.valueOf(data.getId()));
                activity.startActivity(intent);
            });
        }


    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        final TextView textViewTitle;
        final TextView textViewDesc;
        final TextView textViewDate;
        final ImageView imageViewPoster;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.movie_name);
            textViewDesc = itemView.findViewById(R.id.movie_desc);
            textViewDate = itemView.findViewById(R.id.movie_date);
            imageViewPoster = itemView.findViewById(R.id.movie_poster);
        }
    }
}
