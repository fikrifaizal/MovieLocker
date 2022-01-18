package com.sinau.movielocker.ui.tvshow

import androidx.lifecycle.ViewModel
import com.sinau.movielocker.data.TvShowEntity
import com.sinau.movielocker.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShows(): List<TvShowEntity> = DataDummy.generateDummyTvShow()
}