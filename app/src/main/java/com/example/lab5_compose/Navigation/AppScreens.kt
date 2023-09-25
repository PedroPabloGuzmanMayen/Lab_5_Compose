package com.example.lab5_compose.Navigation

sealed class AppScreens(val route: String){
    object FirsScreen: AppScreens("first screen")
    object SecondScreen: AppScreens("second screen")
    object ThirdScreen: AppScreens("third screen")
}
