package com.sinau.movielocker.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowItemsResponse(

	@field:SerializedName("results")
	val results: List<TvShowResponse>
)
