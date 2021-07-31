package com.example.imdb_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_app.databinding.MovieItemBinding
import com.example.imdb_app.network.Results

class MovieAdapter(private val listener: onMovieClickListener)  : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList= listOf<Results>()
    class MovieViewHolder(private val binding : MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setBinding(results: Results){
        binding.movie=results
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
      MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       val currentMovie=movieList[position]
        holder.setBinding(currentMovie)
        holder.itemView.setOnClickListener {
            listener.onMovieClick(currentMovie,position)
        }
    }

    override fun getItemCount()=movieList.size

    fun refreshMovieList(movieList : List<Results>){
        this.movieList =movieList
        notifyDataSetChanged()     // imp line
    }

}

interface onMovieClickListener{
  fun onMovieClick(results: Results, position: Int)
}
