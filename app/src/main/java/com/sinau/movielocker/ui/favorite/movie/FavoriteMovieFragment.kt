package com.sinau.movielocker.ui.favorite.movie

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sinau.movielocker.databinding.FragmentFavoriteMovieBinding
import com.sinau.movielocker.ui.movie.MovieAdapter
import com.sinau.movielocker.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding as FragmentFavoriteMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val favMovieViewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]
            val movieAdapter = MovieAdapter()

            favMovieViewModel.getFavoriteMovie().observe(viewLifecycleOwner, { fav ->
                if (fav != null) {
                    movieAdapter.submitList(fav)
                    movieAdapter.notifyDataSetChanged()
                    showStatus(true)
                } else {
                    showStatus(false)
                }
            })

            with(binding.rvFavoriteMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showStatus(isNotEmpty: Boolean) {
        if (isNotEmpty) {
            binding.rvFavoriteMovie.visibility = View.VISIBLE
            binding.status.visibility = View.GONE
        } else {
            binding.rvFavoriteMovie.visibility = View.GONE
            binding.status.visibility = View.VISIBLE
        }
    }
}