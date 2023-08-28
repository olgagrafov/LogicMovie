package com.olgag.movielogic.model

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olgag.movielogic.db.MovieRepositoryDB
import com.olgag.movielogic.db.MovieRoomDatabase
import com.olgag.movielogic.network_service.MovieRepository
import kotlinx.coroutines.launch
import kotlin.random.Random

class MovieViewModel (application: Application) : ViewModel() {
    private val networkRepository = MovieRepository()
    private val _movieItem = MutableLiveData<MovieItem>()

    private val movieDb = MovieRoomDatabase.getInstance(application)
    private val movieDao = movieDb.movieDao()
    private val dbRepository: MovieRepositoryDB = MovieRepositoryDB(movieDao)
    val allMovieList: LiveData<List<MovieItem>> = dbRepository.movieList
    val popularMovieList: LiveData<List<MovieItem>> = dbRepository.moviePopularList

    private val _movieDBItem: MutableState<MovieItem?> = mutableStateOf(null)
    var movieItem: State<MovieItem?> = _movieDBItem
        private set

    fun setMovieItem(movieItem: MovieItem) {
        _movieDBItem.value = movieItem
    }

    fun fetchMovie() {
        viewModelScope.launch {
            try {
                val retrievedTMovie = networkRepository.getMovie()
                _movieItem.value = retrievedTMovie
                repeat(20){  index ->
                    val movie: MovieItem = _movieItem.value!!
                    movie.id = (0..1000).random()
                    movie.popularity = Random.nextFloat()
                    dbRepository.insertMovie(movie)
                }
            } catch (e: Exception) {
                _movieItem.value =  MovieItem(0,0F, "", "","")
            }
        }
    }

}