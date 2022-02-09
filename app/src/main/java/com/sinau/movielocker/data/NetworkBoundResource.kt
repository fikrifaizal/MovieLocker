package com.sinau.movielocker.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.sinau.movielocker.data.source.remote.ApiResponse
import com.sinau.movielocker.data.source.remote.StatusResponse
import com.sinau.movielocker.utils.AppExecutors
import com.sinau.movielocker.vo.Resource

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDb()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = Resource.success(newData)
                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDb(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {

        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = Resource.loading(newData)
        }
        result.addSource(apiResponse) {
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (it.status) {
                StatusResponse.SUCCESS -> mExecutors.diskIO().execute {
                    saveCallResult(it.body)
                    mExecutors.mainThread().execute {
                        result.addSource(loadFromDb()) { newData ->
                            result.value = Resource.success(newData)
                        }
                    }
                }
                StatusResponse.EMPTY -> mExecutors.mainThread().execute{
                    result.addSource(loadFromDb()) { newData ->
                        result.value = Resource.success(newData)
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = Resource.error(it.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}