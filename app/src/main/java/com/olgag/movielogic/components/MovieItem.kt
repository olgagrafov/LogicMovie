package com.olgag.movielogic.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.olgag.movielogic.model.MovieItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(
    movie: MovieItem,
    onItemClicked: () -> Unit,) {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        modifier = paddingModifier
            .fillMaxWidth()
            .clickable { onItemClicked() }
    ) {
        Column(modifier = paddingModifier) {
            Text(text = movie.original_title)
        }
    }
}