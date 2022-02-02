package com.sinau.movielocker.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.remote.RemoteDataSource
import com.sinau.movielocker.data.source.remote.response.movie.MovieResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowResponse

class Repository private constructor(private var remoteDataSource: RemoteDataSource) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieList = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadAllMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val allMovies = ArrayList<MovieEntity>()
                for (response in movieResponse) {
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
                movieList.postValue(allMovies)
            }
        })
        return movieList
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowList = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadAllTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                val allTvShows = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
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
                tvShowList.postValue(allTvShows)
            }
        })
        return tvShowList
    }

    override fun getDetailMovie(id: Int): LiveData<MovieEntity> {
        val detailMovie = MutableLiveData<MovieEntity>()
        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieReceived(movieResponse: MovieResponse) {
                with(movieResponse) {
                    // agar tidak error saat data null
                    val poster = posterPath ?: ""
                    val backdrop = backdropPath ?: ""
                    val overview = overview ?: "-"

                    val data = MovieEntity(
                        id,
                        title,
                        overview,
                        releaseDate,
                        duration,
                        poster,
                        backdrop,
                        voteAverage
                    )
                    detailMovie.postValue(data)
                }
            }
        })
        return detailMovie
    }

    override fun getDetailTvShow(id: Int): LiveData<TvShowEntity> {
        val detailTvShow = MutableLiveData<TvShowEntity>()
        remoteDataSource.getDetailTvShow(id, object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowReceived(tvShowResponse: TvShowResponse) {
                with(tvShowResponse) {
                    // agar tidak error saat data null
                    val poster = posterPath ?: ""
                    val backdrop = backdropPath ?: ""
                    val overview = overview ?: "-"

                    val data = TvShowEntity(
                        id,
                        name,
                        overview,
                        firstAirDate,
                        episodeRunTime.average().toInt(),
                        poster,
                        backdrop,
                        voteAverage
                    )
                    detailTvShow.postValue(data)
                }
            }
        })
        return detailTvShow
    }
}