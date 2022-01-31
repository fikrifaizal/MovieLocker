package com.sinau.movielocker.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.source.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity

class MovieViewModel(private val repository: Repository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = repository.getAllMovies()
}