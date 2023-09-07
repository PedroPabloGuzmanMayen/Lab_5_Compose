package com.example.lab5_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun locations(information: MutableList<concertDetails>){
    Scaffold(
        topBar = { //Appbar
            TopAppBar(title = {
                Text("Lugares") //Appname
            })
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)){
            itemsIndexed(information){ index, item -> slides(information[index])

            }
        }
    }

}
@Composable
fun slides(information: concertDetails){

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .border(2.dp, Color.Black)){
        Row(){

            Image(painter = rememberImagePainter(data = "https://static.vecteezy.com/system/resources/thumbnails/000/552/683/small/location_pin_002.jpg"), contentDescription = null )
            Column() {
                Text(information.singer)
                Text(information.location)
            }
            Image(painter = rememberImagePainter(data = "https://mir-s3-cdn-cf.behance.net/user/276/10116677.547f0cc7a3aa4.jpg"), contentDescription = null)

        }
    }

}


