package com.sinau.movielocker.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowItemsResponse(

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TvShowResponse>,

	@field:SerializedName("total_results")
	val totalResults: Int
)
