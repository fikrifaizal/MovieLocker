package com.sinau.movielocker.data.source.remote.response.tvshow

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowItemsResponse(

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TvShowResponse>,

	@field:SerializedName("total_results")
	val totalResults: Int
) : Parcelable
