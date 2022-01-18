package com.sinau.movielocker.ui.tvshow

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class TvShowViewModelTest {
    private lateinit var tvShowViewModel: TvShowViewModel

    @Before
    fun setUp() {
        tvShowViewModel = TvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShowEntities = tvShowViewModel.getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}