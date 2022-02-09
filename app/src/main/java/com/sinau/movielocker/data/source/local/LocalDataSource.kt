package com.sinau.movielocker.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovies()

    fun getDetailMovieById(id: Int): LiveData<MovieEntity> = mMovieDao.getDetailMovie(id)

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getTvShows()

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getFavoriteTvShows()

    fun getDetailTvShowById(id: Int): LiveData<TvShowEntity> = mMovieDao.getDetailTvShow(id)

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun insertDetailMovie(movie: MovieEntity) = mMovieDao.insertDetailMovie(movie)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieDao.insertTvShows(tvShows)

    fun insertDetailTvShow(tvShow: TvShowEntity) = mMovieDao.insertDetailTvShow(tvShow)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mMovieDao.updateTvShow(tvShow)
    }
}