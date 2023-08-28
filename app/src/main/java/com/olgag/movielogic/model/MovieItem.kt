package com.olgag.movielogic.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.olgag.movielogic.utilities.Constants.Companion.TBL_NAME

@Entity(tableName = TBL_NAME)
data class MovieItem(
    @PrimaryKey(autoGenerate = false)
    var id:Int,
    var popularity: Float,
    val original_title: String,
    val overview: String,
    val poster_path: String
)
