package com.example.imdb_app.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.imdb_app.R
import com.example.imdb_app.adapter.MovieAdapter
import com.example.imdb_app.network.Results

@BindingAdapter("setPosterImage")
fun setPosterImg(imageView: ImageView,poster_url : String?){
    val completeUrl ="https://image.tmdb.org/t/p/w500$poster_url"
    if (poster_url!=null)
    Glide.
    with(imageView.context).
            load(completeUrl).
    apply(RequestOptions().error(R.drawable.ic_broken)).
            into(imageView)

}

@BindingAdapter("setRecyclerView")
fun setRecyclerView(recyclerView: RecyclerView,movieList: List<Results>?){
    val adapter=recyclerView.adapter as MovieAdapter
    if (movieList!=null) adapter.refreshMovieList(movieList)

}