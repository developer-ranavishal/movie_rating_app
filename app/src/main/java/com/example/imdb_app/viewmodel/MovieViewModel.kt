package com.example.imdb_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb_app.constant.NETWORK_TAG
import com.example.imdb_app.network.MovieApi
import com.example.imdb_app.network.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(movieApi : MovieApi) : ViewModel() {

    private var mPopularMovie = MutableLiveData<List<Results>>()
    val popularMovie : LiveData<List<Results>>
    get() = mPopularMovie

    init {
        getMovies(movieApi)
    }

    private fun getMovies(movieApi: MovieApi) {
          viewModelScope.launch {
              val movieResponse=movieApi.getMovies()
              val responseBody=movieResponse.body()
              Log.d(NETWORK_TAG, "total page are  ${responseBody?.total_pages}")
              try {
                       if (responseBody!=null) {
                           Log.d(NETWORK_TAG, "movie are ${responseBody.results} ")
                           mPopularMovie.value = responseBody.results
                       }
              }catch (t : Throwable){
                  Log.d(NETWORK_TAG, "error is ${t.localizedMessage}")
              }

          }
    }

}