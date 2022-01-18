package com.sinau.movielocker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sinau.movielocker.R
import com.sinau.movielocker.data.MovieEntity
import com.sinau.movielocker.data.TvShowEntity
import com.sinau.movielocker.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOV)
            val tvShowId = extras.getInt(EXTRA_TV)
            when {
                extras.containsKey(EXTRA_MOV) -> {
                    detailViewModel.setSelectedMovie(movieId)
                    val movies = detailViewModel.getMovie()
                    populateDetail(movies)
                }
                extras.containsKey(EXTRA_TV) -> {
                    detailViewModel.setSelectedTvShow(tvShowId)
                    val tvShows = detailViewModel.getTvShow()
                    populateDetail(tvShows)
                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detail_title)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
    }

    private fun populateDetail(movieEntity: MovieEntity) {
        binding.tvTitle.text = movieEntity.title
        binding.tvOverview.text = movieEntity.overview
        binding.tvDate.text = movieEntity.releaseDate
        binding.tvDuration.text = movieEntity.duration
        val rating = movieEntity.voteAverage.toString() + " / 10"
        binding.tvRating.text = rating
        Glide.with(this)
            .load(movieEntity.posterPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivPoster)
        Glide.with(this)
            .load(movieEntity.backdropPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivBackdrop)
    }

    private fun populateDetail(tvShowEntity: TvShowEntity) {
        binding.tvTitle.text = tvShowEntity.title
        binding.tvOverview.text = tvShowEntity.overview
        binding.tvDate.text = tvShowEntity.releaseDate
        binding.tvDuration.text = tvShowEntity.duration
        val rating = tvShowEntity.voteAverage.toString() + " / 10"
        binding.tvRating.text = rating
        Glide.with(this)
            .load(tvShowEntity.posterPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivPoster)
        Glide.with(this)
            .load(tvShowEntity.backdropPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivBackdrop)
    }

    companion object {
        const val EXTRA_MOV = "extra_mov"
        const val EXTRA_TV = "extra_tv"
    }
}