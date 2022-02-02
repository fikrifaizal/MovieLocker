package com.sinau.movielocker.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity

class DetailViewModel(private val repository: Repository) : ViewModel() {
    private var id: Int = 0

    fun setSelectedItem(itemId: Int) {
        this.id = itemId
    }

    fun getMovie(): LiveData<MovieEntity> = repository.getDetailMovie(id)

    fun getTvShow(): LiveData<TvShowEntity> = repository.getDetailTvShow(id)
}