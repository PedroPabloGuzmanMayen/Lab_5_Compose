package com.example.lab5_compose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab5_compose.concertDetails
import com.example.lab5_compose.details
import com.example.lab5_compose.mainScreen

@Composable
fun AppNavigaton(information: MutableList<concertDetails>){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirsScreen.route ){
        composable(route = AppScreens.FirsScreen.route){
            mainScreen(information)
        }
        composable(route = AppScreens.SecondScreen.route){
            //details()
        }
    }
}