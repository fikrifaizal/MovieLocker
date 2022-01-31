package com.sinau.movielocker.data.source.remote.response.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItemsResponse(

    @field:SerializedName("total_pages")
	val totalPages: Int,

    @field:SerializedName("results")
	val results: List<MovieResponse>,

    @field:SerializedName("total_results")
	val totalResults: Int
) : Parcelable