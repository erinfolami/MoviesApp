package com.example.moviesapp.features.upcoming.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.example.moviesapp.features.upcoming.ui.viewmodel.UpcomingViewModel
import com.example.moviesapp.model.data.UpcomingMovies

@Composable
internal fun UpcomingMoviesRoute(
    modifier: Modifier = Modifier,
    viewModel: UpcomingViewModel = hiltViewModel(),
) {

    val state by viewModel.upcomingMovies.collectAsState()

    UpcomingMoviesScreen(modifier,state)
}

@Composable
internal fun UpcomingMoviesScreen(
    modifier: Modifier = Modifier,
    state : List<UpcomingMovies>
) {

    Column(modifier.background(color = Color.DarkGray)) {

        if (state.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No Movies Found...",
                    color = Color.White,
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        } else {
            MovieList(modifier, state)
        }
    }
}


@Composable
fun MovieList(modifier: Modifier,state : List<UpcomingMovies>){
    LazyVerticalGrid(
        columns = GridCells.FixedSize( 128.dp),
        modifier = modifier.background(color = Color.DarkGray),
    ) {
        items(state) { movie ->
            movie.let {
                MovieCard(
                    modifier = Modifier,
                    movie = it,
                )
            }
        }
    }
}



@Composable
private fun MovieCard(
    modifier: Modifier,
    movie: UpcomingMovies,
) {
    Column(modifier.padding(5.dp),
    ){
        Card(
            modifier = modifier.size(250.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier,
                model = "https://image.tmdb.org/t/p/original"+movie.posterPath,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )


        }
        Text(movie.title, fontSize = 13.sp,modifier = modifier.padding(5.dp))
    }
}

