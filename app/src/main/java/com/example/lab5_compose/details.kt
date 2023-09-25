package com.example.lab5_compose


import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun details(information: concertDetails){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navController = rememberNavController()
    Scaffold(

        topBar = { //Appbar
            TopAppBar(
                title = {
                    Text("Detalles") //Appname
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Yellow ),
                navigationIcon = {
                    IconButton(onClick = {val intent = Intent(navController.context, MainActivity::class.java)
                        navController.context.startActivity(intent)}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )

                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()){
            content(information)
        }
    }
}
@Composable
fun content(information: concertDetails) {
    Card(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .background(Color.LightGray) // Background color
                    .weight(1f)
            ) {
                Text(
                    text = information.date,
                    textAlign = TextAlign.Left,
                    fontSize = 25.sp, // Text size
                    color = Color.White // Text color
                )
            }
            Box(
                modifier = Modifier
                    .background(Color.LightGray) // Background color
                    .weight(1f)
            ) {
                Text(
                    text = information.hour,
                    textAlign = TextAlign.Right,
                    fontSize = 25.sp, // Text size
                    color = Color.White // Text color
                )
            }


        }
        Spacer(modifier = Modifier.size(25.dp))
        Text(information.name,
            style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
            )
        )
        Spacer(modifier = Modifier.size(25.dp))
        Text("Acerca de",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ))
        Spacer(modifier = Modifier.size(25.dp))
        Text(information.details,
            style = TextStyle(
                fontSize = 17.sp,

                color = Color.Black
        ))

    }
}
