package com.olgag.movielogic.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olgag.movielogic.model.MovieItem
import com.olgag.movielogic.utilities.Constants.Companion.TBL_NAME

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieItem: MovieItem)

    @Query("SELECT * FROM ".plus(TBL_NAME))
    fun getAllMovies(): LiveData<List<MovieItem>>

    @Query("SELECT * FROM $TBL_NAME WHERE popularity > 0.5")
    fun getPopularMovie(): LiveData<List<MovieItem>>
}