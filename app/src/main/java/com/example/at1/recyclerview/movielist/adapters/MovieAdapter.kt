package com.example.at1.recyclerview.movielist.adapters

import android.util.Log
import com.example.at1.R
import com.example.at1.databinding.ItemMovieBinding
import com.example.at1.recyclerview.movielist.recdata.Movie

class MovieAdapter(private val list: List<Movie>, private val movieListener: MovieListener) :
    BaseAdapter<ItemMovieBinding, Movie>(list) {

    private val TAG = "MovieAdapter"
    override val layoutId: Int = R.layout.item_movie

    override fun bind(binding: ItemMovieBinding, item: Movie) {
        Log.d(TAG, "MovieAdapter :: bind :: ")
        binding.apply {
            movie = item
            listener = movieListener
            executePendingBindings()
        }
    }
}

interface MovieListener {
    fun onMovieClicked(movie: Movie)
    fun onFavouriteClicked(movie: Movie)
}