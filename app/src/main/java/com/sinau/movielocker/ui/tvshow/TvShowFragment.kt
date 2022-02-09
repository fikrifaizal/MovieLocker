package com.sinau.movielocker.ui.tvshow

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sinau.movielocker.databinding.FragmentTvShowBinding
import com.sinau.movielocker.viewmodel.ViewModelFactory
import com.sinau.movielocker.vo.Status

class TvShowFragment : Fragment() {
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding as FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()

            tvShowViewModel.getTvShows().observe(viewLifecycleOwner, {tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> onLoading(true)
                        Status.SUCCESS -> {
                            onLoading(false)
                            tvShowAdapter.setTvShow(tvShows.data)
                            tvShowAdapter.notifyDataSetChanged()
                            showStatus(true)
                        }
                        Status.ERROR -> {
                            onLoading(false)
                            showStatus(false)
                        }
                    }
                }
            })

            with(binding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
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
            binding.rvTvShow.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.rvTvShow.visibility = View.VISIBLE
        }
    }

    private fun showStatus(isOnline: Boolean) {
        if (isOnline) {
            binding.rvTvShow.visibility = View.VISIBLE
            binding.status.visibility = View.GONE
        } else {
            binding.rvTvShow.visibility = View.GONE
            binding.status.visibility = View.VISIBLE
        }
    }
}