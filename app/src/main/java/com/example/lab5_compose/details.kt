package com.example.lab5_compose


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun details(information: concertDetails, navController: NavController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = { //Appbar
            TopAppBar(
                title = {
                    Text("Detalles") //Appname
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Yellow ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
            content(information, navController)
        }
    }
}

@Composable
fun content(information: concertDetails, navController: NavController){

    Card(modifier = Modifier
        .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Row(){
            Text(information.date)
            Spacer(modifier = Modifier.width(8.dp))
            Text(information.hour)

        }



    }
}
