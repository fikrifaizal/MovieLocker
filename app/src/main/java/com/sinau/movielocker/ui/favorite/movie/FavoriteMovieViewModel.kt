package com.sinau.movielocker.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val repository: Repository) : ViewModel() {
    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = repository.getFavoriteMovie()
}