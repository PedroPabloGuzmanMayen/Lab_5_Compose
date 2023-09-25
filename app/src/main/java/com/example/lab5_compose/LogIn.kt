package com.example.lab5_compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab5_compose.Navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn(navController: NavController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = { //Appbar
            TopAppBar(
                title = {
                    Text("LogIn") //Appname
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
            logIn_content(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun logIn_content(navController: NavController){

    var obj by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }


    Column(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Bienvenido",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        TextField(value = obj, onValueChange = { obj = it }, label = { Text("Nombre de usuario ") })
        TextField(value = url, onValueChange = { url = it }, label = { Text("Contraseña ") })
        Button(onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route)
        }) {
            Text("LogIn")
        }



    }


}

