package com.sinau.movielocker.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.utils.DataDummy
import com.sinau.movielocker.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel

    private val dummyMovie = Resource.success(DataDummy.generateDummyMovie()[0])
    private val movieId = dummyMovie.data?.movieId

    private val dummyTvShow = Resource.success(DataDummy.generateDummyTvShow()[0])
    private val tvShowId = dummyTvShow.data?.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Mock
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(repository)
        if (movieId != null) {
            detailViewModel.setSelectedItem(movieId)
        }
        if (tvShowId != null) {
            detailViewModel.setSelectedItem(tvShowId)
        }
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieId?.let { repository.getDetailMovie(it) }).thenReturn(movie)
        dummyMovie.data?.movieId?.let { detailViewModel.setSelectedItem(it) }

        val movieEntity = detailViewModel.getMovie().value?.data
        dummyMovie.data?.movieId?.let { verify(repository).getDetailMovie(it) }

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.data?.movieId, movieEntity?.movieId)
        assertEquals(dummyMovie.data?.title, movieEntity?.title)
        assertEquals(dummyMovie.data?.overview, movieEntity?.overview)
        assertEquals(dummyMovie.data?.releaseDate, movieEntity?.releaseDate)
        assertEquals(dummyMovie.data?.runtime, movieEntity?.runtime)
        movieEntity?.voteAverage?.let { dummyMovie.data?.voteAverage?.let { it1 -> assertEquals(it1, it, 0.0) } }
        assertEquals(dummyMovie.data?.posterPath, movieEntity?.posterPath)
        assertEquals(dummyMovie.data?.backdropPath, movieEntity?.backdropPath)

        detailViewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(tvShowId?.let { repository.getDetailTvShow(it) }).thenReturn(tvShow)
        dummyTvShow.data?.tvShowId?.let { detailViewModel.setSelectedItem(it) }

        val tvShowEntity = detailViewModel.getTvShow().value?.data
        dummyTvShow.data?.tvShowId?.let { verify(repository).getDetailTvShow(it) }

        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.data?.tvShowId, tvShowEntity?.tvShowId)
        assertEquals(dummyTvShow.data?.name, tvShowEntity?.name)
        assertEquals(dummyTvShow.data?.overview, tvShowEntity?.overview)
        assertEquals(dummyTvShow.data?.firstAirDate, tvShowEntity?.firstAirDate)
        assertEquals(dummyTvShow.data?.episodeRunTime, tvShowEntity?.episodeRunTime)
        dummyTvShow.data?.voteAverage?.let { tvShowEntity?.voteAverage?.let { it1 ->
            assertEquals(it,
                it1, 0.0)
        } }
        assertEquals(dummyTvShow.data?.posterPath, tvShowEntity?.posterPath)
        assertEquals(dummyTvShow.data?.backdropPath, tvShowEntity?.backdropPath)

        detailViewModel.getTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

    @Test
    fun setFavoriteTvShow() {
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(tvShowId?.let { repository.getDetailTvShow(it) }).thenReturn(tvShow)
        dummyTvShow.data?.tvShowId?.let { detailViewModel.setSelectedItem(it) }

        val tvShowEntity = detailViewModel.getTvShow().value?.data as TvShowEntity
        dummyTvShow.data?.tvShowId?.let { verify(repository).getDetailTvShow(it) }

        detailViewModel.setFavoriteTvShow(tvShowEntity)
        verify(repository).setFavoriteTvShow(tvShowEntity, true)
    }

    @Test
    fun setFavoriteMovie() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieId?.let { repository.getDetailMovie(it) }).thenReturn(movie)
        dummyMovie.data?.movieId?.let { detailViewModel.setSelectedItem(it) }

        val movieEntity = detailViewModel.getMovie().value?.data as MovieEntity
        dummyMovie.data?.movieId?.let { verify(repository).getDetailMovie(it) }

        detailViewModel.setFavoriteMovie(movieEntity)
        verify(repository).setFavoriteMovie(movieEntity, true)
    }
}