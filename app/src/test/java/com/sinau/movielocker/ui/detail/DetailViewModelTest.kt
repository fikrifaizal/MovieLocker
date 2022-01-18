package com.sinau.movielocker.ui.detail

import com.sinau.movielocker.utils.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.movieId

    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setSelectedMovie(movieId)
        detailViewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        detailViewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = detailViewModel.getMovie()

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage, 0.0)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.backdropPath, movieEntity.backdropPath)
    }

    @Test
    fun getTvShow() {
        detailViewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShowEntity = detailViewModel.getTvShow()

        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.voteAverage, tvShowEntity.voteAverage, 0.0)
        assertEquals(dummyTvShow.posterPath, tvShowEntity.posterPath)
        assertEquals(dummyTvShow.backdropPath, tvShowEntity.backdropPath)
    }
}