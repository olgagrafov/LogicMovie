package com.olgag.movielogic.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.olgag.movielogic.model.MovieViewModel

@Composable
fun ComposableDetailsScreen(viewModel: MovieViewModel){
    val movie = viewModel.movieItem.value
    movie?.let {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = movie.original_title)
            Text(text = movie.overview)
            Text(text = movie.popularity.toString())
            Text(text = movie.id.toString())
        }
    }
}