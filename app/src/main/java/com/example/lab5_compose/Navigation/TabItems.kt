package com.example.lab5_compose.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lab5_compose.favorites
import com.example.lab5_compose.locations
import com.example.lab5_compose.mainScreen
import com.example.lab5_compose.profile

typealias MyFunction = @Composable () -> Unit
sealed class TabItems(
    var Icon: ImageVector,
    var  Title: String,
    var screen: MyFunction
){
    object item_principal: TabItems(Icons.Filled.Home, "Listado", { mainScreen()})
    object item_perfil: TabItems(Icons.Filled.Person, "Perfil", {profile()})
    object item_lugares: TabItems(Icons.Filled.LocationOn, "Lugares", { locations()})
    object item_favoritos: TabItems(Icons.Filled.Star, "Favoritos", {favorites()})
}
