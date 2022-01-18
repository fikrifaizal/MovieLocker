package com.sinau.movielocker.ui.movie

import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.MovieEntity
import com.sinau.movielocker.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}