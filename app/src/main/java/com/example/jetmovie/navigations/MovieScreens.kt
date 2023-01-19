package com.example.jetmovie.navigations

// here basically we create enum class so as to define all the screens of our app : )

enum class MovieScreens {
    HomeScreen ,
    DetailsScreen ;
    companion object{
        fun fromRoute(route : String?):MovieScreens
          =  when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not Recognised")
            }

    }
}