package com.sinau.movielocker.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.vo.Resource

class MovieViewModel(private val repository: Repository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = repository.getAllMovies()
}