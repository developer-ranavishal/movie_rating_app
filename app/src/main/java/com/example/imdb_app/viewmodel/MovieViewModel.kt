package com.example.imdb_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb_app.constant.TAGN
import com.example.imdb_app.model.MovieRepository
import com.example.imdb_app.network.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {

    private var _allPopularMovie = MutableLiveData<List<Results>>()
    val allPopularMovie: LiveData<List<Results>>
        get() = _allPopularMovie

    init {
        callingPopularMovies(movieRepository)
    }


    private fun callingPopularMovies(movieRepository: MovieRepository) {
        viewModelScope.launch {
            movieRepository.getPopularMovies()
                .collect { allMovie ->
                    try {
                        Log.d(TAGN, "response is successfully done ")
                        _allPopularMovie.value = allMovie
                    } catch (t: Throwable) {
                        Log.d(TAGN, "error occur which is ${t.localizedMessage}")
                    }

                }
        }
    }


}