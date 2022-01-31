package com.sinau.movielocker.data.source.remote.api

import com.sinau.movielocker.BuildConfig
import com.sinau.movielocker.data.source.remote.response.movie.MovieItemsResponse
import com.sinau.movielocker.data.source.remote.response.movie.MovieResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowItemsResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") key: String = BuildConfig.IMDB_TOKEN
    ) : Call<MovieItemsResponse>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key") key: String = BuildConfig.IMDB_TOKEN
    ) : Call<MovieResponse>

    @GET("tv/popular")
    fun getPopularTvShows(
        @Query("api_key") key: String = BuildConfig.IMDB_TOKEN
    ) : Call<TvShowItemsResponse>

    @GET("tv/{id}")
    fun getDetailTvShow(
        @Path("id") id: Int,
        @Query("api_key") key: String = BuildConfig.IMDB_TOKEN
    ) : Call<TvShowResponse>
}