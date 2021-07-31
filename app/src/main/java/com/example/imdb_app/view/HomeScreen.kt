package com.example.imdb_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.imdb_app.adapter.MovieAdapter
import com.example.imdb_app.adapter.onMovieClickListener
import com.example.imdb_app.databinding.FragmentHomeScreenBinding
import com.example.imdb_app.network.Results
import com.example.imdb_app.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeScreen : Fragment(), onMovieClickListener {

    private lateinit var binding : FragmentHomeScreenBinding
    private val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeScreenBinding.inflate(layoutInflater)
        binding.viewModel=movieViewModel
        binding.lifecycleOwner=viewLifecycleOwner
        binding.recyclerView.adapter=MovieAdapter(this)
       return binding.root
    }

    override fun onMovieClick(results: Results, position: Int) {
        Toast.makeText(context, "item number $position ", Toast.LENGTH_SHORT).show()
    }

}