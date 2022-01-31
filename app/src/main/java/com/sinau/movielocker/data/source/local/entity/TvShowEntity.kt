package com.sinau.movielocker.data.source.local.entity

data class TvShowEntity(
    var tvShowId: Int,
    var name: String,
    var overview: String,
    var firstAirDate: String,
    var episodeRunTime: Int,
    var posterPath: String,
    var backdropPath: String,
    var voteAverage: Double
)