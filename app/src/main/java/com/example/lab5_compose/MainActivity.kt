package com.example.lab5_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab5_compose.ui.theme.Lab5_ComposeTheme
class MainActivity : ComponentActivity() {
    var taylorSwift: concertDetails = concertDetails("The eras tour", "Taylor Swift", "https://d2cx26qpfwuhvu.cloudfront.net/millstad/wp-content/uploads/2023/06/20124152/TS-CARDIFF-STADIUM-WEBSITE-EVENT-PAGE-1170px-wide-x-660px-high.jpg", "Por primera vez Taylor Swift en Guatemala", "Casa de Dios", "12/11/2023", "6:00 p.m")
    var theWeekend: concertDetails = concertDetails("After Hours until Dawn", "The Weekend", "https://www.theweeknd.com/files/2022/12/GLOBALSTADIUMTOUR_0-819x1024.jpeg", "The Weekend en Guatemalam por primera vez", "Explanada Cayala", "14/12/2023", "10.00 p.m")
    var events: MutableList<concertDetails> = mutableListOf(taylorSwift, theWeekend)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //mainScreen(events)
                    //locations(events)
                    details(events[0])
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5_ComposeTheme {
        Greeting("Android")
    }
}