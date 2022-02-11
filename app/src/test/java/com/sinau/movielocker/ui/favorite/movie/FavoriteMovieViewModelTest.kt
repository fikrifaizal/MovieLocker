package com.sinau.movielocker.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {
    private lateinit var favoriteMovieViewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        favoriteMovieViewModel = FavoriteMovieViewModel(repository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyFavMovies = pagedList
        Mockito.`when`(dummyFavMovies.size).thenReturn(1)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyFavMovies

        Mockito.`when`(repository.getFavoriteMovie()).thenReturn(movies)
        val movieEntities = favoriteMovieViewModel.getFavoriteMovie().value
        verify(repository).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(1, movieEntities?.size)

        favoriteMovieViewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dummyFavMovies)
    }
}