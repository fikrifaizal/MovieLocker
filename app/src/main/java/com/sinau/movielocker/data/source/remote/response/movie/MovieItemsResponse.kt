package com.sinau.movielocker.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieItemsResponse(

    @field:SerializedName("total_pages")
	val totalPages: Int,

    @field:SerializedName("results")
	val results: List<MovieResponse>,

    @field:SerializedName("total_results")
	val totalResults: Int
)