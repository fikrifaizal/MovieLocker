package com.sinau.movielocker.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieItemsResponse(

    @field:SerializedName("results")
	val results: List<MovieResponse>
)