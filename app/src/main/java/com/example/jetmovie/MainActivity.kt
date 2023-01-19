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
                MainContent(movieList = list)
            }

        }
    }
}

@Composable
fun MyApp(content : @Composable () -> Unit){
    JetMovieTheme {
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
           content()
           
       }
    }
}

@Composable
fun MainContent(movieList : List<String>){
Column(modifier = Modifier.padding(12.dp)) {
    LazyColumn {
        items(items=movieList){items->
           MovieRow(title = items , LocalContext.current )
        }
    }
    
}
}

@Composable
fun MovieRow(title : String, context: Context){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(100.dp)
        .clickable {
            Toast
                .makeText(context, "u cliked on $title", Toast.LENGTH_SHORT)
                .show()
        }
        ,
        shape = RoundedCornerShape(16.dp),
        elevation = 6.dp

    ) {

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(10.dp)
                .size(80.dp), shape = RectangleShape, elevation = 4.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie image placeHolder")
            }
            Text(text = title , fontWeight =  FontWeight.SemiBold,)
        }

    }
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        val list = listOf<String>("Bleach","Naruto","Berserk", "Dororo", "GoldenTime")
        MyApp {
            MainContent(movieList = list)
        }

    }

}