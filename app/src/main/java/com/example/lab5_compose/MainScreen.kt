package com.example.lab5_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun mainScreen(){
    LazyVerticalGrid(columns = GridCells.Fixed(2), content ={
        items(100){ i->
            Box(modifier = Modifier
                .padding(8.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(5.dp))){
                Text("Hola")
            }
        }
    } )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    mainScreen()
}



