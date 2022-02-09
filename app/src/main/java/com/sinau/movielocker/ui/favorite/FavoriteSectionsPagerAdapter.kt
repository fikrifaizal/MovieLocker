package com.sinau.movielocker.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sinau.movielocker.ui.favorite.movie.FavoriteMovieFragment
import com.sinau.movielocker.ui.favorite.tvshow.FavoriteTvShowFragment

class FavoriteSectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> FavoriteMovieFragment()
        }
    }

}