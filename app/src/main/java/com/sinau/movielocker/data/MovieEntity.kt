package com.sinau.movielocker.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity (
    var movieId: Int,
    var title: String,
    var overview: String,
    var releaseDate: String,
    var duration: String,
    var posterPath: String,
    var backdropPath: String,
    var voteAverage: Double
) : Parcelable