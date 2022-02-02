package com.sinau.movielocker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sinau.movielocker.BuildConfig
import com.sinau.movielocker.R
import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.databinding.ActivityDetailBinding
import com.sinau.movielocker.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance()
        val detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        onLoading(true)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOV)
            val tvShowId = extras.getInt(EXTRA_TV)
            when {
                extras.containsKey(EXTRA_MOV) -> {
                    detailViewModel.setSelectedItem(movieId)
                    detailViewModel.getMovie().observe(this, {movie ->
                        populateDetail(movie)
                        onLoading(false)
                    })
                }
                extras.containsKey(EXTRA_TV) -> {
                    detailViewModel.setSelectedItem(tvShowId)
                    detailViewModel.getTvShow().observe(this, {tvShow ->
                        populateDetail(tvShow)
                        onLoading(false)
                    })
                }
            }
        }

        supportActionBar?.title = getString(R.string.detail_title)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun populateDetail(movieEntity: MovieEntity) {
        binding.tvTitle.text = movieEntity.title
        binding.tvOverview.text = movieEntity.overview
        binding.tvDate.text = movieEntity.releaseDate
        binding.tvDuration.text = timeConverter(movieEntity.runtime)
        val rating = movieEntity.voteAverage.toString() + " / 10"
        binding.tvRating.text = rating
        Glide.with(this)
            .load(BuildConfig.POSTER_URL + movieEntity.posterPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivPoster)
        Glide.with(this)
            .load(BuildConfig.BACKDROP_URL + movieEntity.backdropPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivBackdrop)
    }

    private fun populateDetail(tvShowEntity: TvShowEntity) {
        binding.tvTitle.text = tvShowEntity.name
        binding.tvOverview.text = tvShowEntity.overview
        binding.tvDate.text = tvShowEntity.firstAirDate
        binding.tvDuration.text = timeConverter(tvShowEntity.episodeRunTime)
        val rating = tvShowEntity.voteAverage.toString() + " / 10"
        binding.tvRating.text = rating
        Glide.with(this)
            .load(BuildConfig.POSTER_URL + tvShowEntity.posterPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivPoster)
        Glide.with(this)
            .load(BuildConfig.BACKDROP_URL + tvShowEntity.backdropPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivBackdrop)
    }

    private fun timeConverter(time: Int) : String {
        return if (time > 60) {
            val timeInHour = time/60
            val timeInMinute = time-(timeInHour*60)
            "$timeInHour h $timeInMinute m"
        } else {
            "$time m"
        }
    }

    private fun onLoading(condition: Boolean) {
        if (condition) {
            binding.progressBar.visibility = View.VISIBLE
            binding.ivBackdrop.visibility = View.GONE
            binding.ivPoster.visibility = View.GONE
            binding.tvTitle.visibility = View.GONE
            binding.cvRelease.visibility = View.GONE
            binding.cvDuration.visibility = View.GONE
            binding.cvRating.visibility = View.GONE
            binding.overviewTitle.visibility = View.GONE
            binding.tvOverview.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.ivBackdrop.visibility = View.VISIBLE
            binding.ivPoster.visibility = View.VISIBLE
            binding.tvTitle.visibility = View.VISIBLE
            binding.cvRelease.visibility = View.VISIBLE
            binding.cvDuration.visibility = View.VISIBLE
            binding.cvRating.visibility = View.VISIBLE
            binding.overviewTitle.visibility = View.VISIBLE
            binding.tvOverview.visibility = View.VISIBLE
        }
    }

    companion object {
        const val EXTRA_MOV = "extra_mov"
        const val EXTRA_TV = "extra_tv"
        const val EXTRA_TV_POSITION = "extra_tv_position"
    }
}