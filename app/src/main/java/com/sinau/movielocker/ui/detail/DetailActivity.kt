package com.sinau.movielocker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sinau.movielocker.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}