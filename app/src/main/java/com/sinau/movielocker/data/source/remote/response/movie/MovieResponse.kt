package com.sinau.movielocker.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("original_title")
    val title: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("runtime")
    val duration: Int,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("poster_path")
    val posterPath: String
)