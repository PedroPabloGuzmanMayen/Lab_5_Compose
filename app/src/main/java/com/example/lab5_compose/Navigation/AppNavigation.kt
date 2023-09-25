package com.example.lab5_compose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab5_compose.concertDetails
import com.example.lab5_compose.mainScreen
import com.example.lab5_compose.details

@Composable
fun AppNavigation(navController: NavController){
    val hola: concertDetails = concertDetails("holA", "hola", "hola", "hola", "hola", "hola", "hola")
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.FirsScreen.route ){
        composable(route = AppScreens.FirsScreen.route){
            mainScreen()
        }
        composable(route = AppScreens.SecondScreen.route){
                details(hola)
            }
        }
    }
