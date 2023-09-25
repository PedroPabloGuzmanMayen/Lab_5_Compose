package com.example.lab5_compose


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun favorites(){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = { //Appbar
            TopAppBar(
                title = {
                    Text("Favoritos") //Appname
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Yellow ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()){
            favorites_content()
        }
    }
}

@Composable
fun favorites_content(){

    Column(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = rememberVectorPainter(image = Icons.Filled.Star),
            contentDescription = "Profile photo",
            modifier = Modifier
                .size(200.dp)
                .padding(20.dp)
                .clip(CircleShape)
                .border(3.dp, Color.Red, CircleShape),
            colorFilter = ColorFilter.tint(Color.Red))
        Text("Tus favoritos")
        Spacer(modifier = Modifier.size(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, RectangleShape),
            horizontalArrangement = Arrangement.Start){
            Image(painter = rememberVectorPainter(image = Icons.Filled.ThumbUp), contentDescription = "Thumb up", colorFilter = ColorFilter.tint(Color.Blue))
            Spacer(modifier = Modifier.size(5.dp))
            Text(events[0].name)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, RectangleShape),
            horizontalArrangement = Arrangement.Start){
            Image(painter = rememberVectorPainter(image = Icons.Filled.ThumbUp), contentDescription = "Thumb up", colorFilter = ColorFilter.tint(Color.Blue))
            Spacer(modifier = Modifier.size(5.dp))
            Text(events[1].name)

        }



    }


}

