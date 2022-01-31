package com.sinau.movielocker.di

import com.sinau.movielocker.data.source.Repository
import com.sinau.movielocker.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): Repository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return Repository.getInstance(remoteDataSource)
    }
}