package com.example.imdb_app.model

import com.example.imdb_app.network.MovieApi
import com.example.imdb_app.network.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MovieRepository @Inject constructor(_movieApi: MovieApi) {

    private val movieApi = _movieApi
    fun getPopularMovies(): Flow<List<Results>> = flow {
        val getResponse = movieApi.getMovies()
        emit(getResponse.body()!!.results)
    }.flowOn(Dispatchers.IO)

}

/**
 *     private fun getMovies(movieApi: MovieApi) {
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
 */