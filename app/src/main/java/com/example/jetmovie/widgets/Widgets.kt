package com.example.jetmovie.widgets

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.jetmovie.model.Movies

@Composable
fun MovieRow(movie : Movies, context: Context, onitemClick : (String) -> Unit ={}){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(100.dp)
        .clickable {
//            Toast.makeText(context , " u clicked on $title" , Toast.LENGTH_SHORT).show()
            onitemClick(movie.id)
        }
        ,
        shape = RoundedCornerShape(16.dp),
        elevation = 6.dp

    ) {

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(10.dp)
                .size(80.dp), shape = RectangleShape, elevation = 4.dp) {
//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie image placeHolder")
                Image(
                    rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = movie.poster)
                            .allowHardware(false)
                            .build()
                    ),
                    contentDescription = "main image description "
                )

            }
          Column(modifier = Modifier.padding(4.dp)) {
              Text(text = movie.title , fontWeight =  FontWeight.Bold, style = MaterialTheme.typography.h5)
              Text(text = "Genre : ${movie.gene}"  , fontWeight = FontWeight.SemiBold , style = MaterialTheme.typography.h5)
              Text(text ="Released : ${movie.year}" , fontWeight = FontWeight.SemiBold , style = MaterialTheme.typography.h5)
          }
        }

    }

}