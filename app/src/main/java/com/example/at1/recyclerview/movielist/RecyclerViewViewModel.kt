package com.example.at1.recyclerview.movielist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.at1.recyclerview.movielist.adapters.Event
import com.example.at1.recyclerview.movielist.adapters.MovieListener
import com.example.at1.recyclerview.movielist.recdata.ConstMovieData
import com.example.at1.recyclerview.movielist.recdata.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.random.Random

class RecyclerViewViewModel : ViewModel(), MovieListener {

    private val TAG = "RecyclerViewViewModel"

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    private val _showProgressBar = MutableLiveData(false)
    val showProgressBar: LiveData<Boolean> = _showProgressBar

    val showToast = MutableLiveData<Event<Movie>>()

    init {
        Log.d(TAG, "RecyclerViewViewModel :: init: ")
        submitMovieList()
    }

    private fun submitMovieList() {
        Log.d(TAG, "RecyclerViewViewModel :: submitMovieList: ")
        viewModelScope.launch {
            fetchMovies()

                .onStart {
                    Log.d(TAG, "RecyclerViewViewModel :: submitMovieList :: 1")
                    _showProgressBar.postValue(true)
                    Log.d(TAG, "RecyclerViewViewModel :: submitMovieList :: 2")
                }.catch { err ->
                    Log.d(TAG, "RecyclerViewViewModel :: submitMovieList : 3")
                    _showProgressBar.postValue(false)
                    Log.d(TAG, "RecyclerViewViewModel :: submitMovieList : 4")
                }
                .collect { list ->
                    Log.d(TAG, "RecyclerViewViewModel :: submitMovieList :: 5")
                    _showProgressBar.postValue(false)
                    Log.d(TAG, "RecyclerViewViewModel :: submitMovieList :: 6")
                    _movieList.value = list
                    Log.d(TAG, "RecyclerViewViewModel :: submitMovieList :: 7")
                }

        }
    }

    fun addRandomMovie() {
        Log.d(TAG, "RecyclerViewViewModel :: addRandomMovie :: 1")
        val rand = Random.nextInt(0, ConstMovieData.movieList.size - 1)
        Log.d(TAG, "RecyclerViewViewModel :: addRandomMovie :: $rand")
        ConstMovieData.movieList.add(
            ConstMovieData.movieList[rand]
        )
        Log.d(TAG, "RecyclerViewViewModel :: addRandomMovie :: 2")
        submitMovieList()
    }

    private fun fetchMovies() = flow<List<Movie>> {
        Log.d(TAG, "RecyclerViewViewModel :: fetchMovies :: 1")
        delay(700)
        Log.d(TAG, "RecyclerViewViewModel :: fetchMovies :: 2")
        emit(ConstMovieData.movieList)
        Log.d(TAG, "RecyclerViewViewModel :: fetchMovies :: 3")
    }.flowOn(Dispatchers.IO)

    override fun onMovieClicked(movie: Movie) {
        Log.d(TAG, "RecyclerViewViewModel :: onMovieClicked :: ")
        showToast.value = Event(movie)
    }

    override fun onFavouriteClicked(movie: Movie) {
        val ind = ConstMovieData.movieList.indexOf(movie)
        Log.d(TAG, "RecyclerViewViewModel :: onFavouriteClicked: $ind")
        Log.d(TAG, "RecyclerViewViewModel :: onFavouriteClicked: 1: ${ConstMovieData.movieList[ind].favourite}")
        ConstMovieData.movieList[ind].favourite = !ConstMovieData.movieList[ind].favourite
        Log.d(TAG, "RecyclerViewViewModel :: onFavouriteClicked: 2: ${ConstMovieData.movieList[ind].favourite}")
        submitMovieList()
    }
}