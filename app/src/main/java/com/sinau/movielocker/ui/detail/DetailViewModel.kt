package com.sinau.movielocker.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.vo.Resource

class DetailViewModel(private val repository: Repository) : ViewModel() {
    private var id: Int = 0

    fun setSelectedItem(itemId: Int) {
        this.id = itemId
    }

    fun getMovie(): LiveData<Resource<MovieEntity>> = repository.getDetailMovie(id)

    fun getTvShow(): LiveData<Resource<TvShowEntity>> = repository.getDetailTvShow(id)

    fun setFavoriteMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFavorite
        repository.setFavoriteMovie(movieEntity, newState)
    }

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFavorite
        repository.setFavoriteTvShow(tvShowEntity, newState)
    }
}