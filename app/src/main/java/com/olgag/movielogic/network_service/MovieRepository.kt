package com.olgag.movielogic.network_service

import com.olgag.movielogic.model.MovieItem

class MovieRepository {
    private val movieService = RetrofitHelper.movieService

    suspend fun getMovie(): MovieItem {
        return try {
            movieService.getMovie()
        } catch (e: Exception){
            MovieItem(0,0F, "", "","")
        }
    }
}