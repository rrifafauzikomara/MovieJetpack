package com.rifafauzi.moviecatalogue.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseMovies(@field:SerializedName("results")
                     @field:Expose
                     val movies: List<Movies>)