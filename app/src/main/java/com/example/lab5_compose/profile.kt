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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun profile(){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = { //Appbar
            TopAppBar(
                title = {
                    Text("Perfil") //Appname
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
            content()
        }
    }
}


@Composable
fun content(){

    Column(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ){
        Image(painter = rememberVectorPainter(image = Icons.Filled.Person),
              contentDescription = "Profile photo",
              modifier = Modifier
                  .size(100.dp)
                  .padding(20.dp)
                  .clip(CircleShape)
                  .border(3.dp, Color.Black, CircleShape))
        Text("Nombre de perfil")
        Spacer(modifier = Modifier.size(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, RectangleShape),
            horizontalArrangement = Arrangement.Start){
            Image(painter = rememberVectorPainter(image = Icons.Filled.Person), contentDescription = "Profile photo")
            Spacer(modifier = Modifier.size(5.dp))
            Text("Editar perfil")

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, RectangleShape),
            horizontalArrangement = Arrangement.Start){
            Image(painter = rememberVectorPainter(image = Icons.Filled.Lock), contentDescription = "Lock")
            Spacer(modifier = Modifier.size(5.dp))
            Text("Cambiar contraseña")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, RectangleShape),
            horizontalArrangement = Arrangement.Start){
            Image(painter = rememberVectorPainter(image = Icons.Filled.Notifications), contentDescription = "Lock")
            Spacer(modifier = Modifier.size(5.dp))
            Text("Notifiaciones")

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, RectangleShape),
            horizontalArrangement = Arrangement.Start){
            Image(painter = rememberVectorPainter(image = Icons.Filled.Star), contentDescription = "Star")
            Spacer(modifier = Modifier.size(5.dp))
            Text("Favoritos")

        }


    }

}

