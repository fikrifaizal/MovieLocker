package com.sinau.movielocker.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>> = repository.getFavoriteTvShow()
}