package com.sinau.movielocker.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowEntity (
    var tvShowId: Int,
    var title: String,
    var overview: String,
    var releaseDate: String,
    var posterPath: String,
    var voteAverage: Double
) : Parcelable