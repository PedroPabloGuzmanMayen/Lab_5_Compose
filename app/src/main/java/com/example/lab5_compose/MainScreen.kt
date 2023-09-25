package com.example.lab5_compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.lab5_compose.Navigation.AppScreens


var taylorSwift: concertDetails = concertDetails("The eras tour", "Taylor Swift", "https://d2cx26qpfwuhvu.cloudfront.net/millstad/wp-content/uploads/2023/06/20124152/TS-CARDIFF-STADIUM-WEBSITE-EVENT-PAGE-1170px-wide-x-660px-high.jpg", "Por primera vez Taylor Swift en Guatemala", "Casa de Dios", "12/11/2023", "6:00 p.m")
var theWeekend: concertDetails = concertDetails("After Hours until Dawn", "The Weekend", "https://www.theweeknd.com/files/2022/12/GLOBALSTADIUMTOUR_0-819x1024.jpeg", "The Weekend en Guatemalam por primera vez", "Explanada Cayala", "14/12/2023", "10.00 p.m")
var events: MutableList<concertDetails> = mutableListOf(taylorSwift, theWeekend)

//Función que será invocada para mostrar la pantalla
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreen() {
    Scaffold(
        topBar = { //Appbar
            TopAppBar(title = {
                Text("Todo Eventos") //Appname
            })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            Text("Para ti")
            bodyContent(events) //This function shows the content of the screen
            Text("Todos los eventos")
            bodyContent(events)
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
                    .clickable( onClick = {})
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

