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
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.ui.detail.DetailMovieActivity;

public class FavoriteTvShowPageListAdapter extends PagedListAdapter<TvShowEntity, FavoriteTvShowPageListAdapter.TvShowViewHolder> {

    private final Activity activity;

    public FavoriteTvShowPageListAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    private static DiffUtil.ItemCallback<TvShowEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvShowEntity>() {
                @Override
                public boolean areItemsTheSame(TvShowEntity oldTvShowEntity, TvShowEntity newTvShowEntity) {
                    return oldTvShowEntity.getName().equals(newTvShowEntity.getName());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(TvShowEntity oldTvShowEntity, @NonNull TvShowEntity newTvShowEntity) {
                    return oldTvShowEntity.equals(newTvShowEntity);
                }
            };

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new FavoriteTvShowPageListAdapter.TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTvShowPageListAdapter.TvShowViewHolder holder, int position) {
        TvShowEntity data = getItem(position);
        if (data != null) {
            holder.textViewTitle.setText(data.getName());
            holder.textViewDesc.setText(data.getOverview());
            holder.textViewDate.setText(data.getFirstAirDate());
            Glide.with(holder.itemView.getContext())
                    .load(Contract.LINK_IMAGE + data.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.img_default_bg)
                            .error(R.drawable.ic_error))
                    .into(holder.imageViewPoster);
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(activity, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.getId());
                activity.startActivity(intent);
            });
        }
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {

        final TextView textViewTitle;
        final TextView textViewDesc;
        final TextView textViewDate;
        final ImageView imageViewPoster;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.movie_name);
            textViewDesc = itemView.findViewById(R.id.movie_desc);
            textViewDate = itemView.findViewById(R.id.movie_date);
            imageViewPoster = itemView.findViewById(R.id.movie_poster);
        }
    }
}
