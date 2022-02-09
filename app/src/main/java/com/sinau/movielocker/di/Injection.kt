package com.sinau.movielocker.di

import android.content.Context
import com.sinau.movielocker.data.Repository
import com.sinau.movielocker.data.source.local.LocalDataSource
import com.sinau.movielocker.data.source.local.room.MovieDatabase
import com.sinau.movielocker.data.source.remote.RemoteDataSource
import com.sinau.movielocker.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): Repository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}