package com.sinau.movielocker.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.sinau.movielocker.data.source.remote.RemoteDataSource
import com.sinau.movielocker.utils.DataDummy
import com.sinau.movielocker.utils.LiveDataTestUtil
import org.junit.Assert
import org.junit.Rule

import org.junit.Test
import org.mockito.Mockito

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repository = FakeRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val movieId = movieResponse[0].id
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].id
    private val detailMovieResponse = DataDummy.generateRemoteDummyMovie()[0]
    private val detailTvShowResponse = DataDummy.generateRemoteDummyTvShow()[0]

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadAllMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(repository.getAllMovies())
        verify(remote).getAllMovies(any())
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadAllTvShowsCallback)
                .onAllTvShowsReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvShowEntities = LiveDataTestUtil.getValue(repository.getAllTvShows())
        verify(remote).getAllTvShows(any())
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMovieReceived(detailMovieResponse)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())
        val detailMovieEntity = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())
        Assert.assertNotNull(detailMovieEntity)
        Assert.assertEquals(detailMovieResponse.id, detailMovieEntity.movieId)
        Assert.assertEquals(detailMovieResponse.title, detailMovieEntity.title)
        Assert.assertEquals(detailMovieResponse.overview, detailMovieEntity.overview)
        Assert.assertEquals(detailMovieResponse.releaseDate, detailMovieEntity.releaseDate)
        Assert.assertEquals(detailMovieResponse.duration, detailMovieEntity.runtime)
        Assert.assertEquals(detailMovieResponse.voteAverage, detailMovieEntity.voteAverage, 0.0)
        Assert.assertEquals(detailMovieResponse.posterPath, detailMovieEntity.posterPath)
        Assert.assertEquals(detailMovieResponse.backdropPath, detailMovieEntity.backdropPath)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback)
                .onDetailTvShowReceived(detailTvShowResponse)
            null
        }.`when`(remote).getDetailTvShow(eq(tvShowId), any())
        val detailTvShowEntity = LiveDataTestUtil.getValue(repository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTvShow(eq(tvShowId), any())
        Assert.assertNotNull(detailTvShowEntity)
        Assert.assertEquals(detailTvShowResponse.id, detailTvShowEntity.tvShowId)
        Assert.assertEquals(detailTvShowResponse.name, detailTvShowEntity.name)
        Assert.assertEquals(detailTvShowResponse.overview, detailTvShowEntity.overview)
        Assert.assertEquals(detailTvShowResponse.firstAirDate, detailTvShowEntity.firstAirDate)
        Assert.assertEquals(detailTvShowResponse.episodeRunTime.average().toInt(), detailTvShowEntity.episodeRunTime)
        Assert.assertEquals(detailTvShowResponse.voteAverage, detailTvShowEntity.voteAverage, 0.0)
        Assert.assertEquals(detailTvShowResponse.posterPath, detailTvShowEntity.posterPath)
        Assert.assertEquals(detailTvShowResponse.backdropPath, detailTvShowEntity.backdropPath)
    }
}