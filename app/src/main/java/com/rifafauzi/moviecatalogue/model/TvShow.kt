package com.rifafauzi.moviecatalogue.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TvShow(@field:SerializedName("poster_path")
             @field:Expose
             val posterPath: String, @field:SerializedName("overview")
             @field:Expose
             val overview: String, @field:SerializedName("first_air_date")
             @field:Expose
             val releaseDate: String, @field:SerializedName("id")
             @field:Expose
             val id: Int, @field:SerializedName("name")
             @field:Expose
             val name: String)