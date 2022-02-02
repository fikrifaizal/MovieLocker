package com.sinau.movielocker.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.remote.RemoteDataSource
import com.sinau.movielocker.data.source.remote.response.movie.MovieResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowResponse

class FakeRepository (private var remoteDataSource: RemoteDataSource) : DataSource {

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieList = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadAllMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val allMovies = ArrayList<MovieEntity>()
                for (response in movieResponse) {
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
                        // episodeRunTime dibuat 0 karena dalam API tv popular tidak ada datanya
                        // menghindari error juga >_<
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
                    val data = MovieEntity(
                        id,
                        title,
                        overview,
                        releaseDate,
                        duration,
                        posterPath,
                        backdropPath,
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
                    val data = TvShowEntity(
                        id,
                        name,
                        overview,
                        firstAirDate,
                        episodeRunTime.average().toInt(),
                        posterPath,
                        backdropPath,
                        voteAverage
                    )
                    detailTvShow.postValue(data)
                }
            }
        })
        return detailTvShow
    }
}