package com.sinau.movielocker.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sinau.movielocker.data.source.local.LocalDataSource
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.remote.ApiResponse
import com.sinau.movielocker.data.source.remote.RemoteDataSource
import com.sinau.movielocker.data.source.remote.response.movie.MovieResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowResponse
import com.sinau.movielocker.utils.AppExecutors
import com.sinau.movielocker.vo.Resource

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteDataSource, localDataSource, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDb(): LiveData<List<MovieEntity>> = localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val allMovies = ArrayList<MovieEntity>()
                for (response in data) {
                    with(response) {
                        // agar tidak error saat data null
                        val poster = posterPath ?: ""
                        val backdrop = backdropPath ?: ""

                        val movie = MovieEntity(
                            id,
                            title,
                            overview,
                            releaseDate,
                            0,
                            poster,
                            backdrop,
                            voteAverage
                        )
                        allMovies.add(movie)
                    }
                }
                localDataSource.insertMovies(allMovies)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDb(): LiveData<List<TvShowEntity>> = localDataSource.getAllTvShows()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> = remoteDataSource.getAllTvShows()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val allTvShows = ArrayList<TvShowEntity>()
                for (response in data) {
                    with(response) {
                        // agar tidak error saat data null
                        val poster = posterPath ?: ""
                        val backdrop = backdropPath ?: ""

                        val tvShow = TvShowEntity(
                            id,
                            name,
                            overview,
                            firstAirDate,
                            0,
                            poster,
                            backdrop,
                            voteAverage
                        )
                        allTvShows.add(tvShow)
                    }
                }
                localDataSource.insertTvShows(allTvShows)
            }

        }.asLiveData()
    }

    override fun getDetailMovie(id: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors) {
            public override fun loadFromDb(): LiveData<MovieEntity> = localDataSource.getDetailMovieById(id)

            override fun shouldFetch(data: MovieEntity?): Boolean = data == null

            public override fun createCall(): LiveData<ApiResponse<MovieResponse>> = remoteDataSource.getDetailMovie(id)

            public override fun saveCallResult(data: MovieResponse) {
                with(data) {
                    // agar tidak error saat data null
                    val poster = posterPath ?: ""
                    val backdrop = backdropPath ?: ""
                    val newOverview = overview ?: "-"

                    val detailMovie = MovieEntity(
                        id,
                        title,
                        newOverview,
                        releaseDate,
                        duration,
                        poster,
                        backdrop,
                        voteAverage
                    )
                    localDataSource.insertDetailMovie(detailMovie)
                }
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(id: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowResponse>(appExecutors) {
            public override fun loadFromDb(): LiveData<TvShowEntity> = localDataSource.getDetailTvShowById(id)

            override fun shouldFetch(data: TvShowEntity?): Boolean = data == null

            public override fun createCall(): LiveData<ApiResponse<TvShowResponse>> = remoteDataSource.getDetailTvShow(id)

            public override fun saveCallResult(data: TvShowResponse) {
                with(data) {
                    // agar tidak error saat data null
                    val poster = posterPath ?: ""
                    val backdrop = backdropPath ?: ""
                    val newOverview = overview ?: "-"

                    val detailTvShow = TvShowEntity(
                        id,
                        name,
                        newOverview,
                        firstAirDate,
                        episodeRunTime.average().toInt(),
                        poster,
                        backdrop,
                        voteAverage
                    )
                    localDataSource.insertDetailTvShow(detailTvShow)
                }
            }

        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<List<MovieEntity>> =
        localDataSource.getFavoriteMovies()

    override fun getFavoriteTvShow(): LiveData<List<TvShowEntity>> =
        localDataSource.getFavoriteTvShows()

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie, state)
        }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteTvShow(tvShow, state)
        }
}