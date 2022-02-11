package com.sinau.movielocker.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sinau.movielocker.data.source.local.LocalDataSource
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.remote.ApiResponse
import com.sinau.movielocker.data.source.remote.RemoteDataSource
import com.sinau.movielocker.data.source.remote.response.movie.MovieResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowResponse
import com.sinau.movielocker.utils.AppExecutors
import com.sinau.movielocker.vo.Resource

class FakeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : DataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val allMovies = ArrayList<MovieEntity>()
                for (response in data) {
                    with(response) {
                        val movie = MovieEntity(
                            id,
                            title,
                            overview,
                            releaseDate,
                            duration,
                            posterPath,
                            backdropPath,
                            voteAverage
                        )
                        allMovies.add(movie)
                    }
                }
                localDataSource.insertMovies(allMovies)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> = remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val allTvShows = ArrayList<TvShowEntity>()
                for (response in data) {
                    with(response) {
                        // episodeRunTime dibuat 0 karena dalam API tv popular tidak ada datanya
                        val tvShow = TvShowEntity(
                            id,
                            name,
                            overview,
                            firstAirDate,
                            0,
                            posterPath,
                            backdropPath,
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
            override fun loadFromDb(): LiveData<MovieEntity> = localDataSource.getDetailMovieById(id)

            override fun shouldFetch(data: MovieEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<MovieResponse>> = remoteDataSource.getDetailMovie(id)

            override fun saveCallResult(data: MovieResponse) {
                with(data) {
                    val movie = MovieEntity(
                        id,
                        title,
                        overview,
                        releaseDate,
                        duration,
                        posterPath,
                        backdropPath,
                        voteAverage
                    )
                    localDataSource.insertDetailMovie(movie)
                }
            }

        }.asLiveData()
    }

    override fun getDetailTvShow(id: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowResponse>(appExecutors) {
            override fun loadFromDb(): LiveData<TvShowEntity> = localDataSource.getDetailTvShowById(id)

            override fun shouldFetch(data: TvShowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<TvShowResponse>> = remoteDataSource.getDetailTvShow(id)

            override fun saveCallResult(data: TvShowResponse) {
                with(data) {
                    val tvShow = TvShowEntity(
                        id,
                        name,
                        overview,
                        firstAirDate,
                        episodeRunTime.average().toInt(),
                        posterPath,
                        backdropPath,
                        voteAverage
                    )
                    localDataSource.insertDetailTvShow(tvShow)
                }
            }

        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        localDataSource.setFavoriteMovie(movie, state)

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) =
        localDataSource.setFavoriteTvShow(tvShow, state)
}