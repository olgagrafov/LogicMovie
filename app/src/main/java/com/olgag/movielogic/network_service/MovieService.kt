package com.olgag.movielogic.network_service

import com.olgag.movielogic.model.MovieItem
import com.olgag.movielogic.utilities.Constants.Companion.API_KEY
import com.olgag.movielogic.utilities.Constants.Companion.API_STRING
import com.olgag.movielogic.utilities.Constants.Companion.MOVIE
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET(MOVIE)
    suspend fun getMovie(@Query(API_STRING) _apiKey: String? = API_KEY): MovieItem
}