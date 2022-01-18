package com.sinau.movielocker.ui.detail

import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.MovieEntity
import com.sinau.movielocker.data.TvShowEntity
import com.sinau.movielocker.utils.DataDummy

class DetailViewModel : ViewModel() {
    private var movieId: Int = 0
    private var tvShowId: Int = 0

    fun setSelectedMovie(itemId: Int) {
        this.movieId = itemId
    }

    fun setSelectedTvShow(itemId: Int) {
        this.tvShowId = itemId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovie()
        for (movies in movieEntities) {
            if (movies.movieId == movieId) {
                movie = movies
            }
        }
        return movie
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowEntities = DataDummy.generateDummyTvShow()
        for (tvShows in tvShowEntities) {
            if (tvShows.tvShowId == tvShowId) {
                tvShow = tvShows
            }
        }
        return tvShow
    }
}