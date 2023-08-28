package com.olgag.movielogic.db

import androidx.lifecycle.LiveData
import com.olgag.movielogic.model.MovieItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieRepositoryDB (private val movieDao: MovieDao) {
    val movieList: LiveData<List<MovieItem>> = movieDao.getAllMovies()
    val moviePopularList: LiveData<List<MovieItem>> = movieDao.getPopularMovie()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertMovie(newMovie: MovieItem) {
        coroutineScope.launch(Dispatchers.IO) {
            movieDao.insertMovie(newMovie)
        }
    }
}