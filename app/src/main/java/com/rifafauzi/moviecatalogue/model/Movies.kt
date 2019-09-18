package com.rifafauzi.moviecatalogue.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movies(@field:SerializedName("poster_path")
             @field:Expose
             val posterPath: String,

             @field:SerializedName("overview")
             @field:Expose
             val overview: String,

             @field:SerializedName("release_date")
             @field:Expose
             val releaseDate: String,

             @field:SerializedName("first_air_date")
             @field:Expose
             val firstAirDate: String,

             @field:SerializedName("id")
             @field:Expose
             val id: Int,

             @field:SerializedName("name")
             @field:Expose
             val name: String,

             @field:SerializedName("title")
             @field:Expose
             val title: String)