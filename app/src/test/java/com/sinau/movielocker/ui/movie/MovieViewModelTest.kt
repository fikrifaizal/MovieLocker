package com.sinau.movielocker.ui.movie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = movieViewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(11, movieEntities.size)
    }
}