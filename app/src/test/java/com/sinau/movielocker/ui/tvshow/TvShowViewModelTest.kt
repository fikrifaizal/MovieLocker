package com.sinau.movielocker.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    private lateinit var tvShowViewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Before
    fun setUp() {
        tvShowViewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = dummyTvShow

        `when`(repository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = tvShowViewModel.getTvShows().value
        verify(repository).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        tvShowViewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}