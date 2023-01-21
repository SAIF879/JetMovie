package com.example.jetmovie.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, title: String?){
    Scaffold(
        topBar = {
        TopAppBar(
            backgroundColor = Color.Magenta,
            elevation = 10.dp
        ) {

            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, tint = Color.Black ,contentDescription =" back_Arrow" ,
                      modifier = Modifier.clickable { 
                          navController.popBackStack()
                      }
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies", fontWeight = FontWeight.Bold , fontFamily = FontFamily.Monospace, textAlign = TextAlign.Center)
            }
            
        }
    }) {
        Surface(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = title.toString(), fontWeight = FontWeight.Bold , fontFamily = FontFamily.Monospace, textAlign = TextAlign.Center)
            }
        }
    }
}