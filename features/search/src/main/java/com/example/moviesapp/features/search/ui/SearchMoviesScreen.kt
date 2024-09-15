package com.example.moviesapp.features.search.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.example.moviesapp.features.search.ui.viewmodel.SearchMoviesViewModel
import com.example.moviesapp.model.data.SearchMovies
import com.example.moviesapp.network.model.SearchResult
import com.example.moviesapp.network.model.SearchMoviesDTO


@Composable
internal fun SearchMoviesRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchMoviesViewModel = hiltViewModel(),
) {

    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val state = viewModel.searchedMovies.collectAsState()

    SearchMoviesScreen(modifier, textState, state.value)

//    Text(text = "Search${state.value.size}" )


}

@Composable
internal fun SearchMoviesScreen(
    modifier: Modifier = Modifier,
    textState: MutableState<TextFieldValue>,
    state: List<SearchMovies>
) {

    Column(modifier.background(color = Color.DarkGray)) {
        SearchView(textState)

        MovieList(modifier, state)
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(textState: MutableState<TextFieldValue>) {
    TextField(
        value = textState.value,
        onValueChange = { value -> textState.value = value },
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(CircleShape)
            .size(52.dp),
        textStyle = TextStyle(fontSize = 18.sp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (textState.value != TextFieldValue("")) {
                IconButton(onClick = {
                    // Removes text from TextField when you press the 'X' icon
                    textState.value = TextFieldValue("")
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White
        )
    )
}

@Composable
fun MovieList(modifier: Modifier, state: List<SearchMovies>) {
    LazyVerticalGrid(
        columns = GridCells.FixedSize(128.dp),
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
    movie: SearchMovies,
) {
    Column(
        modifier.padding(5.dp),
    ) {
        Card(
            modifier = modifier.size(250.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier,
                model = "https://image.tmdb.org/t/p/original" + movie.posterPath,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
        Text(movie.title, fontSize = 13.sp, modifier = modifier.padding(5.dp))
    }
}