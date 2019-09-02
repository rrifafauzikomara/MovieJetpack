package com.rifafauzi.moviecatalogue.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseTvShow(@field:SerializedName("results")
                     @field:Expose
                     val tvShows: List<TvShow>)
