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
import com.rifafauzi.moviecatalogue.model.TvShow;
import com.rifafauzi.moviecatalogue.ui.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private final Activity activity;
    private List<TvShow> tvShows = new ArrayList<>();

    public TvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setListTvShow(List<TvShow> listTvShow) {
        if (listTvShow == null) return;
        this.tvShows.clear();
        this.tvShows.addAll(listTvShow);
    }

    @NonNull
    @Override
    public TvShowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.TvShowViewHolder holder, int position) {
        TvShow data = tvShows.get(position);
        holder.textViewTitle.setText(data.getName());
        holder.textViewDesc.setText(data.getOverview());
        holder.textViewDate.setText(data.getReleaseDate());
        Glide.with(holder.itemView.getContext())
                .load(Contract.LINK_IMAGE + data.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.img_default_bg)
                        .error(R.drawable.ic_error))
                .into(holder.imageViewPoster);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_TvSHOW, ""+data.getId());
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
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