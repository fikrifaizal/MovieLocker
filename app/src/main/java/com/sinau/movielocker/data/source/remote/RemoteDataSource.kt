package com.sinau.movielocker.data.source.remote

import android.content.ContentValues
import android.util.Log
import com.sinau.movielocker.data.source.remote.api.ApiConfig
import com.sinau.movielocker.data.source.remote.response.movie.MovieItemsResponse
import com.sinau.movielocker.data.source.remote.response.movie.MovieResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowItemsResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowResponse
import com.sinau.movielocker.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadAllMoviesCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getPopularMovies()
            .enqueue(object : Callback<MovieItemsResponse> {
                override fun onResponse(
                    call: Call<MovieItemsResponse>,
                    response: Response<MovieItemsResponse>
                ) {
                    response.body()?.let { callback.onAllMoviesReceived(it.results) }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieItemsResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getDetailMovie(id: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailMovie(id)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.let { callback.onDetailMovieReceived(it) }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getAllTvShows(callback: LoadAllTvShowsCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getPopularTvShows()
            .enqueue(object : Callback<TvShowItemsResponse> {
                override fun onResponse(
                    call: Call<TvShowItemsResponse>,
                    response: Response<TvShowItemsResponse>
                ) {
                    response.body()?.let { callback.onAllTvShowsReceived(it.results) }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowItemsResponse>, t: Throwable) {
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getDetailTvShow(id: Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailTvShow(id)
            .enqueue(object : Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    response.body()?.let { callback.onDetailTvShowReceived(it) }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    interface LoadAllMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(movieResponse: MovieResponse)
    }

    interface LoadAllTvShowsCallback {
        fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse>)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(tvShowResponse: TvShowResponse)
    }
}