package com.sinau.movielocker.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.vo.Resource

class TvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<List<TvShowEntity>>> = repository.getAllTvShows()
}