package com.sinau.movielocker.data.source.remote

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getAllMovies() : LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        ApiConfig.getApiService().getPopularMovies()
            .enqueue(object : Callback<MovieItemsResponse> {
                override fun onResponse(
                    call: Call<MovieItemsResponse>,
                    response: Response<MovieItemsResponse>
                ) {
                    if (response.isSuccessful) {
                        resultResponse.postValue(ApiResponse.success(response.body()?.results as List<MovieResponse>))
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                        resultResponse.postValue(ApiResponse.empty(response.message(), emptyList()))
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<MovieItemsResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                    resultResponse.postValue(ApiResponse.error(t.message.toString(), emptyList()))
                    EspressoIdlingResource.decrement()
                }
            })
        return resultResponse
    }

    fun getDetailMovie(id: Int) : LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultResponse = MutableLiveData<ApiResponse<MovieResponse>>()
        ApiConfig.getApiService().getDetailMovie(id)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        resultResponse.postValue(ApiResponse.success(response.body() as MovieResponse))
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                    EspressoIdlingResource.decrement()
                }
            })
        return resultResponse
    }

    fun getAllTvShows() : LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultResponse = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        ApiConfig.getApiService().getPopularTvShows()
            .enqueue(object : Callback<TvShowItemsResponse> {
                override fun onResponse(
                    call: Call<TvShowItemsResponse>,
                    response: Response<TvShowItemsResponse>
                ) {
                    if (response.isSuccessful) {
                        resultResponse.postValue(ApiResponse.success(response.body()?.results as List<TvShowResponse>))
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                        resultResponse.postValue(ApiResponse.empty(response.message(), emptyList()))
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<TvShowItemsResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                    resultResponse.postValue(ApiResponse.error(t.message.toString(), emptyList()))
                    EspressoIdlingResource.decrement()
                }
            })
        return resultResponse
    }

    fun getDetailTvShow(id: Int) : LiveData<ApiResponse<TvShowResponse>> {
        EspressoIdlingResource.increment()
        val resultResponse = MutableLiveData<ApiResponse<TvShowResponse>>()
        ApiConfig.getApiService().getDetailTvShow(id)
            .enqueue(object : Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    if (response.isSuccessful) {
                        resultResponse.postValue(ApiResponse.success(response.body() as TvShowResponse))
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                    EspressoIdlingResource.decrement()
                }
            })
        return resultResponse
    }

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }
}