package com.sinau.movielocker.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sinau.movielocker.databinding.FragmentMovieBinding
import com.sinau.movielocker.viewmodel.ViewModelFactory
import com.sinau.movielocker.vo.Status

class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding as FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = MovieAdapter()

            movieViewModel.getMovies().observe(viewLifecycleOwner, {movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> onLoading(true)
                        Status.SUCCESS -> {
                            onLoading(false)
                            movieAdapter.setMovie(movies.data)
                            movieAdapter.notifyDataSetChanged()
                            showStatus(true)
                        }
                        Status.ERROR -> {
                            onLoading(false)
                            showStatus(false)
                        }
                    }
                }
            })

            with(binding.rvMovie) {
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

    private fun onLoading(condition: Boolean) {
        if (condition) {
            binding.progressBar.visibility = View.VISIBLE
            binding.rvMovie.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.rvMovie.visibility = View.VISIBLE
        }
    }

    private fun showStatus(isOnline: Boolean) {
        if (isOnline) {
            binding.rvMovie.visibility = View.VISIBLE
            binding.status.visibility = View.GONE
        } else {
            binding.rvMovie.visibility = View.GONE
            binding.status.visibility = View.VISIBLE
        }
    }
}