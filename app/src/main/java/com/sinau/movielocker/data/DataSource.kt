package com.sinau.movielocker.data

import androidx.lifecycle.LiveData
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.vo.Resource

interface DataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>

    fun getDetailMovie(id: Int): LiveData<Resource<MovieEntity>>

    fun getDetailTvShow(id: Int): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)
}