package com.example.imdb_app.network

import com.example.imdb_app.constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET


//https://api.themoviedb.org/3/movie/popular?api_key=3380e7d7ab09793624ad74578cf4fd78
//image link -.> https://image.tmdb.org/t/p/w500
interface MovieApi {
    @GET("movie/popular?api_key=$API_KEY")
    suspend fun getMovies() : Response<Movie>
}
//https://api.themoviedb.org/3/movie/popular?api_key=3380e7d7ab09793624ad74578cf4fd78