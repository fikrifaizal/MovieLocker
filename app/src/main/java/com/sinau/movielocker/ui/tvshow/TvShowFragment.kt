package com.sinau.movielocker.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sinau.movielocker.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding as FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val tvShowViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShow = tvShowViewModel.getTvShows()

            val tvShowAdapter = TvShowAdapter()
            tvShowAdapter.setTvShow(tvShow)

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
}