package com.sinau.movielocker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sinau.movielocker.R
import com.sinau.movielocker.data.MovieEntity
import com.sinau.movielocker.data.TvShowEntity
import com.sinau.movielocker.databinding.ActivityDetailBinding
import com.sinau.movielocker.utils.DataDummy

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOV)
            val tvShowId = extras.getInt(EXTRA_TV)
            when {
                extras.containsKey(EXTRA_MOV) -> {
                    for (movies in DataDummy.generateDummyMovie()) {
                        if (movies.movieId == movieId) {
                            populateDetail(movies)
                        }
                    }
                }
                extras.containsKey(EXTRA_TV) -> {
                    for (tvShow in DataDummy.generateDummyTvShow()) {
                        if (tvShow.tvShowId == tvShowId) {
                            populateDetail(tvShow)
                        }
                    }
                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detail_title)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
    }

    private fun populateDetail(movieEntity: MovieEntity) {
        binding.tvTitle.text = movieEntity.title
        Glide.with(this)
            .load(movieEntity.posterPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivPoster)
    }

    private fun populateDetail(tvShowEntity: TvShowEntity) {
        binding.tvTitle.text = tvShowEntity.title
        Glide.with(this)
            .load(tvShowEntity.posterPath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(binding.ivPoster)
    }

    companion object {
        const val EXTRA_MOV = "extra_mov"
        const val EXTRA_TV = "extra_tv"
    }
}