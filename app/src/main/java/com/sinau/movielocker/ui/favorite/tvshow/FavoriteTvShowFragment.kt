package com.sinau.movielocker.ui.favorite.tvshow

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sinau.movielocker.databinding.FragmentFavoriteTvShowBinding
import com.sinau.movielocker.ui.tvshow.TvShowAdapter
import com.sinau.movielocker.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding as FragmentFavoriteTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance((requireActivity()))
            val favTvShowViewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()

            favTvShowViewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { fav ->
                if (fav != null) {
                    tvShowAdapter.setTvShow(fav)
                    tvShowAdapter.notifyDataSetChanged()
                    showStatus(true)
                } else {
                    showStatus(false)
                }
            })

            with(binding.rvFavoriteTvShow) {
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

    private fun showStatus(isNotEmpty: Boolean) {
        if (isNotEmpty) {
            binding.rvFavoriteTvShow.visibility = View.VISIBLE
            binding.status.visibility = View.GONE
        } else {
            binding.rvFavoriteTvShow.visibility = View.GONE
            binding.status.visibility = View.VISIBLE
        }
    }
}