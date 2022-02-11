package com.sinau.movielocker.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity
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
class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = Resource.success(pagedList)
        `when`(dummyMovie.data?.size).thenReturn(11)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovie

        `when`(repository.getAllMovies()).thenReturn(movies)
        val movieEntities = movieViewModel.getMovies().value?.data
        verify(repository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(11, movieEntities?.size)

        movieViewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}