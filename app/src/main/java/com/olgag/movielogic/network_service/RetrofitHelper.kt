package com.olgag.movielogic.network_service

import com.olgag.movielogic.utilities.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }
}