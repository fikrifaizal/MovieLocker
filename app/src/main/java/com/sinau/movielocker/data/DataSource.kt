package com.sinau.movielocker.data

import androidx.lifecycle.LiveData
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.local.entity.MovieEntity

interface DataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvShows(): LiveData<List<TvShowEntity>>

    fun getDetailMovie(id: Int): LiveData<MovieEntity>

    fun getDetailTvShow(id: Int): LiveData<TvShowEntity>
}