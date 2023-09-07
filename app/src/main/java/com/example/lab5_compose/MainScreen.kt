package com.example.lab5_compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
//Función que será invocada para mostrar la pantalla
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreen(information: MutableList<concertDetails>) {
    Scaffold(
        topBar = { //Appbar
            TopAppBar(title = {
                Text("Todo Eventos") //Appname
            })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            Text("Para ti")
            bodyContent(information) //This function shows the content of the screen
            Text("Todos los eventos")
            bodyContent(information)
        }
    }
}

@Composable
fun bodyContent(information: MutableList<concertDetails>) {
    //Almacenar varias tarjetas que muestren información del concierto en una cuadrícula
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(information.size) { i ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Column( //La tarjeta tendrá una columna con una imagen y un
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Mostrar la imagen, usar coil para solamente utilizar el URL de la imagen que se quiere mostrar
                    Image(
                        painter = rememberImagePainter(data = information[i].url),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp).fillMaxWidth()
                    )
                    //Indicar el nombre del evento
                    Text(
                        text = information[i].name,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    })
}

