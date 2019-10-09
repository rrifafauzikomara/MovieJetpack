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
import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity
import com.rifafauzi.moviecatalogue.model.Movies
import com.rifafauzi.moviecatalogue.ui.detail.DetailMovieActivity

import java.util.ArrayList

class MovieAdapter(private val activity: Activity) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movies = ArrayList<MoviesEntity>()

    fun setListMovies(listMovies: List<MoviesEntity>?) {
        if (listMovies == null) return
        this.movies.clear()
        this.movies.addAll(listMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val data = movies[position]
        holder.textViewTitle.text = data.title
        holder.textViewDesc.text = data.overview
        holder.textViewDate.text = data.releaseDate
        Glide.with(holder.itemView.context)
                .load(Contract.LINK_IMAGE + data.posterPath)
                .apply(RequestOptions.placeholderOf(R.drawable.img_default_bg)
                        .error(R.drawable.ic_error))
                .into(holder.imageViewPoster)
        holder.itemView.setOnClickListener {
            val intent = Intent(activity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id.toString())
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewTitle: TextView = itemView.findViewById(R.id.movie_name)
        val textViewDesc: TextView = itemView.findViewById(R.id.movie_desc)
        val textViewDate: TextView = itemView.findViewById(R.id.movie_date)
        val imageViewPoster: ImageView = itemView.findViewById(R.id.movie_poster)

    }
}
