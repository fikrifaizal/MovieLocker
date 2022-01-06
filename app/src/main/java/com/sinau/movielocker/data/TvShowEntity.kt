package com.sinau.movielocker.data

data class TvShowEntity (
    var tvShowId: Int,
    var title: String,
    var overview: String,
    var releaseDate: String,
    var posterPath: String,
    var backdropPath: String,
    var voteAverage: Double
)