package com.example.lab5_compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import coil.compose.rememberImagePainter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Todo Eventos")
            })
        },
        content = {
            bodyContent()
        }
    )
}

@Composable
fun bodyContent() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(100) { i ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(5.dp))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Replace with your image resource
                    Image(
                        painter = rememberImagePainter(data = "https://articles-img.sftcdn.net/f_auto,t_article_cover_l/auto-mapping-folder/sites/2/2023/04/swift-5-eras-tour.jpg"),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Text(
                        text = "Hello",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    })
}

@Preview
@Composable
fun mainScreenPreview() {
    mainScreen()
}
