package com.example.lab5_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun details(information: concertDetails){
    content(information)
}

@Composable
fun content(information: concertDetails){
    Card(){
        Row(){
            Text(information.date)
            Text(information.hour)

        }

        Text(information.details)

    }
}
