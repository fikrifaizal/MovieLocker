package com.sinau.movielocker.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.sinau.movielocker.data.source.local.LocalDataSource
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.remote.RemoteDataSource
import com.sinau.movielocker.utils.AppExecutors
import com.sinau.movielocker.utils.DataDummy
import com.sinau.movielocker.utils.LiveDataTestUtil
import com.sinau.movielocker.utils.PagedListUtil
import com.sinau.movielocker.vo.Resource
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val repository = FakeRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val movieId = movieResponse[0].id
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].id
    private val detailMovieResponse = DataDummy.generateDummyMovie()[0]
    private val detailTvShowResponse = DataDummy.generateDummyTvShow()[0]

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        repository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovies()
        Assert.assertNotNull(movieEntities.data)
        Assert.assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        repository.getAllTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getAllTvShows()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val movieEntity = MutableLiveData<MovieEntity>()
        movieEntity.value = detailMovieResponse
        `when`(local.getDetailMovieById(movieId)).thenReturn(movieEntity)

        val detailMovieEntity = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))
        verify(local).getDetailMovieById(movieId)
        Assert.assertNotNull(detailMovieEntity)
        Assert.assertEquals(detailMovieResponse.movieId, detailMovieEntity.data?.movieId)
        Assert.assertEquals(detailMovieResponse.title, detailMovieEntity.data?.title)
        Assert.assertEquals(detailMovieResponse.overview, detailMovieEntity.data?.overview)
        Assert.assertEquals(detailMovieResponse.releaseDate, detailMovieEntity.data?.releaseDate)
        Assert.assertEquals(detailMovieResponse.runtime, detailMovieEntity.data?.runtime)
        detailMovieEntity.data?.voteAverage?.let {
            Assert.assertEquals(detailMovieResponse.voteAverage,
                it, 0.0)
        }
        Assert.assertEquals(detailMovieResponse.posterPath, detailMovieEntity.data?.posterPath)
        Assert.assertEquals(detailMovieResponse.backdropPath, detailMovieEntity.data?.backdropPath)
    }

    @Test
    fun getDetailTvShow() {
        val tvShowEntity = MutableLiveData<TvShowEntity>()
        tvShowEntity.value = detailTvShowResponse
        `when`(local.getDetailTvShowById(tvShowId)).thenReturn(tvShowEntity)

        val detailTvShowEntity = LiveDataTestUtil.getValue(repository.getDetailTvShow(tvShowId))
        verify(local).getDetailTvShowById(tvShowId)
        Assert.assertNotNull(detailTvShowEntity)
        Assert.assertEquals(detailTvShowResponse.tvShowId, detailTvShowEntity.data?.tvShowId)
        Assert.assertEquals(detailTvShowResponse.name, detailTvShowEntity.data?.name)
        Assert.assertEquals(detailTvShowResponse.overview, detailTvShowEntity.data?.overview)
        Assert.assertEquals(detailTvShowResponse.firstAirDate, detailTvShowEntity.data?.firstAirDate)
        Assert.assertEquals(detailTvShowResponse.episodeRunTime, detailTvShowEntity.data?.episodeRunTime)
        detailTvShowEntity.data?.voteAverage?.let {
            Assert.assertEquals(detailTvShowResponse.voteAverage,
                it, 0.0)
        }
        Assert.assertEquals(detailTvShowResponse.posterPath, detailTvShowEntity.data?.posterPath)
        Assert.assertEquals(detailTvShowResponse.backdropPath, detailTvShowEntity.data?.backdropPath)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        repository.getFavoriteMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavoriteMovies()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        repository.getFavoriteTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getFavoriteTvShows()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        repository.setFavoriteMovie(DataDummy.generateDummyMovie()[0], true)
        verify(local).setFavoriteMovie(DataDummy.generateDummyMovie()[0], true)
    }

    @Test
    fun setFavoriteTvShow() {
        repository.setFavoriteTvShow(DataDummy.generateDummyTvShow()[0], true)
        verify(local).setFavoriteTvShow(DataDummy.generateDummyTvShow()[0], true)
    }
}