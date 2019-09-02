package com.rifafauzi.moviecatalogue.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rifafauzi.moviecatalogue.R
import com.rifafauzi.moviecatalogue.model.TvShow
import com.rifafauzi.moviecatalogue.ui.DetailMovieActivity

import java.util.ArrayList

class TvShowAdapter(private val activity: Activity) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val tvShows = ArrayList<TvShow>()

    fun setListTvShow(listTvShow: List<TvShow>?) {
        if (listTvShow == null) return
        this.tvShows.clear()
        this.tvShows.addAll(listTvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        val data = tvShows[position]
        holder.textViewTitle.text = data.name
        holder.textViewDesc.text = data.overview
        holder.textViewDate.text = data.releaseDate
        Glide.with(holder.itemView.context)
                .load(Contract.LINK_IMAGE + data.posterPath)
                .apply(RequestOptions.placeholderOf(R.drawable.img_default_bg)
                        .error(R.drawable.ic_error))
                .into(holder.imageViewPoster)
        holder.itemView.setOnClickListener {
            val intent = Intent(activity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_TvSHOW, data.id.toString())
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    inner class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewTitle: TextView = itemView.findViewById(R.id.movie_name)
        val textViewDesc: TextView = itemView.findViewById(R.id.movie_desc)
        val textViewDate: TextView = itemView.findViewById(R.id.movie_date)
        val imageViewPoster: ImageView = itemView.findViewById(R.id.movie_poster)

    }
}