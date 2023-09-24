package com.example.lab5_compose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab5_compose.concertDetails
import com.example.lab5_compose.mainScreen
import com.example.lab5_compose.details

@Composable
fun AppNavigation(information: MutableList<concertDetails>, index: Int = 0){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.FirsScreen.route ){
        composable(route = AppScreens.FirsScreen.route){
            mainScreen(information, navController)
        }
        composable(route = AppScreens.SecondScreen.route,
        arguments = listOf(navArgument(name = "index"){
            type = NavType.IntType
        })){
            val details = information[index]
            details(details, navController)
        }
    }
}