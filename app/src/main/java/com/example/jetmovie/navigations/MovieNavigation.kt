package com.example.jetmovie.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetmovie.screens.details.DetailsScreen
import com.example.jetmovie.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        // first Screen  ->
        composable(MovieScreens.HomeScreen.name){
            // here we pass where other things should lead us ->
            HomeScreen(navController = navController)
        }

        // second Screen ->
        composable(MovieScreens.DetailsScreen.name + "/{title}",
            arguments = listOf(navArgument(name = "title"){type = NavType.StringType})

        ){backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("title"))
        }


    }
}