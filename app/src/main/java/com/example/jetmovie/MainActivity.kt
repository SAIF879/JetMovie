package com.example.jetmovie

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetmovie.navigations.MovieNavigation
import com.example.jetmovie.ui.theme.JetMovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = listOf<String>(
            "Bleach", "Naruto", "Berserk", "Dororo", "GoldenTime",
            "Bleach", "Naruto", "Berserk", "Dororo", "GoldenTime",
            "Bleach", "Naruto", "Berserk", "Dororo", "GoldenTime"

        )
        setContent {
            MyApp {
                MovieNavigation()
            }

        }
    }
}

@Composable
fun MyApp(content : @Composable () -> Unit){
    JetMovieTheme {
 content()
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        val list = listOf<String>("Bleach","Naruto","Berserk", "Dororo", "GoldenTime")
        MyApp {
        MovieNavigation()
        }

    }

}