package com.rifafauzi.moviecatalogue.adapter;

import android.app.Activity;
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
import com.rifafauzi.moviecatalogue.model.TvShowModel;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private final Activity activity;
    private List<TvShowModel> tvShowModels = new ArrayList<>();

    public TvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShowModel> getTvShowModels() {
        return tvShowModels;
    }

    public void setListTvShow(List<TvShowModel> listTvShow) {
        if (listTvShow == null) return;
        this.tvShowModels.clear();
        this.tvShowModels.addAll(listTvShow);
    }

    @NonNull
    @Override
    public TvShowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.TvShowViewHolder holder, int position) {
        holder.textViewTitle.setText(getTvShowModels().get(position).getTitle());
        holder.textViewDesc.setText(getTvShowModels().get(position).getDescription());
        holder.textViewDate.setText(getTvShowModels().get(position).getRelease());
        Glide.with(holder.itemView.getContext())
                .load(activity.getApplicationContext().getResources().getIdentifier(getTvShowModels().get(position).getImagePath(), "drawable", activity.getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                        .error(R.drawable.ic_error))
                .into(holder.imageViewPoster);

    }

    @Override
    public int getItemCount() {
        return getTvShowModels().size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder {

        final TextView textViewTitle;
        final TextView textViewDesc;
        final TextView textViewDate;
        final ImageView imageViewPoster;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.movie_name);
            textViewDesc = itemView.findViewById(R.id.movie_desc);
            textViewDate = itemView.findViewById(R.id.movie_date);
            imageViewPoster = itemView.findViewById(R.id.movie_poster);
        }
    }
}