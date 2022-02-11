package com.sinau.movielocker.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {
    private lateinit var favoriteTvShowViewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        favoriteTvShowViewModel = FavoriteTvShowViewModel(repository)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyFavTvShows = pagedList
        Mockito.`when`(dummyFavTvShows.size).thenReturn(1)
        val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = dummyFavTvShows

        Mockito.`when`(repository.getFavoriteTvShow()).thenReturn(tvShows)
        val tvShowEntities = favoriteTvShowViewModel.getFavoriteTvShow().value
        verify(repository).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(1, tvShowEntities?.size)

        favoriteTvShowViewModel.getFavoriteTvShow().observeForever(observer)
        verify(observer).onChanged(dummyFavTvShows)
    }
}