package com.olgag.movielogic

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.olgag.movielogic.model.MainViewModelFactory
import com.olgag.movielogic.model.MovieViewModel
import com.olgag.movielogic.navigation.NavigationHost
import com.olgag.movielogic.ui.theme.MovieLogicTheme
import com.olgag.movielogic.utilities.Constants.Companion.KEY_VIEW_MODEL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieLogicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val owner = LocalViewModelStoreOwner.current
                    owner?.let {
                        val viewModel: MovieViewModel = viewModel(
                            it,
                            KEY_VIEW_MODEL,
                            MainViewModelFactory(
                                LocalContext.current.applicationContext
                                        as Application
                            )
                        )
                        val navController = rememberNavController()
                        NavigationHost(navController, viewModel)
                    }
                }
            }
        }
    }
}