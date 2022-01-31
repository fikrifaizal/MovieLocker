package com.sinau.movielocker.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.source.Repository
import com.sinau.movielocker.data.source.local.entity.TvShowEntity

class TvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getTvShows(): LiveData<List<TvShowEntity>> = repository.getAllTvShows()
}