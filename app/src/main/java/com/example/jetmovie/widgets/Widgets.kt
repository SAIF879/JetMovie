package com.example.jetmovie.widgets

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.jetmovie.model.Movies

@Composable
fun MovieRow(movie : Movies, context: Context, onitemClick : (String) -> Unit ={}){
    var expandable by remember{
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .heightIn(100.dp)
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
                .size(100.dp), shape = RectangleShape, elevation = 4.dp) {
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
              Spacer(modifier = Modifier.size(10.dp))
              Text(text = movie.title , fontWeight =  FontWeight.Bold, style = MaterialTheme.typography.caption)
              Text(text = "Genre : ${movie.gene}"  , fontWeight = FontWeight.SemiBold , style = MaterialTheme.typography.caption)
              Text(text ="Released : ${movie.year}" , fontWeight = FontWeight.SemiBold , style = MaterialTheme.typography.caption)
              
              // expandable details 
              AnimatedVisibility(visible = expandable) {
                  Column {
                      Text(buildAnnotatedString {
                          withStyle(
                              style = SpanStyle(
                                  color = Color.White,
                                  fontSize = 12.sp,
                                  fontWeight = FontWeight.SemiBold
                              )
                          ) { append("Plot :") }
                          withStyle(
                              style = SpanStyle(
                                  color = Color.White,
                                  fontSize = 12.sp,
                                  fontWeight = FontWeight.SemiBold
                              )
                          ) { append("  ${movie.plot}") }
                      })
                      // creates a thin line inBetween
                      Divider(modifier = Modifier.padding(6.dp))
                      Text(text ="Director :${movie.director}",  style = MaterialTheme.typography.caption , fontWeight = FontWeight.SemiBold)
                      Text(text ="Actors : ${movie.actors}",  style = MaterialTheme.typography.caption , fontWeight = FontWeight.SemiBold)
                      Text(text ="Ratings : ${movie.ratings}", style = MaterialTheme.typography.caption , fontWeight = FontWeight.SemiBold)
                  }
              }


              // expanding down_icon ->
              Icon(imageVector =
              if (expandable)
              Icons.Default.KeyboardArrowUp
                  else
                      Icons.Default.ArrowDropDown


                  , contentDescription =" Drop down",
                  modifier = Modifier
                      .size(25.dp)
                      .clickable {
//                          Toast.makeText(context, "u clicked on the arrow", Toast.LENGTH_SHORT).show()
                          expandable = !expandable
                      },
                  tint = Color.White
              )
          }

        }

    }

}