package com.example.imdb_app.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.imdb_app.R
import com.example.imdb_app.constant.TAG
import com.example.imdb_app.databinding.FragmentDetailScreenBinding


class DetailScreen : Fragment() {

    lateinit var binding : FragmentDetailScreenBinding
    private val args : DetailScreenArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentDetailScreenBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        val result = args.movieResult
        Log.d(TAG, "result is $result ")
        binding.movie =result
        return binding.root
    }

}