package com.sinau.movielocker.data.source.local.entity

data class MovieEntity(
    var movieId: Int,
    var title: String,
    var overview: String,
    var releaseDate: String,
    var runtime: Int,
    var posterPath: String,
    var backdropPath: String,
    var voteAverage: Double
)