package com.example.jetmovie.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetmovie.model.Movies
import com.example.jetmovie.model.getMovies
import com.example.jetmovie.navigations.MovieScreens
import com.example.jetmovie.widgets.MovieRow


@Composable
fun HomeScreen(navController: NavController){
    val list = listOf<String>(
        "Bleach", "Naruto", "Berserk", "Dororo", "GoldenTime",
        "Bleach", "Naruto", "Berserk", "Dororo", "GoldenTime",
        "Bleach", "Naruto", "Berserk", "Dororo", "GoldenTime"

    )

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 10.dp) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = " Movie List ->",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    ) {
        MainContent(getMovies(),navController = navController)
    }

}
@Composable
fun MainContent(movieList : List<Movies>, navController: NavController){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items=movieList){items->
                MovieRow(movie = items, LocalContext.current){ title ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$title")
                }
            }
        }

    }
}

