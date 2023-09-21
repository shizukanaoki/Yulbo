package com.example.yulbo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yulbo.ui.theme.YulboTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YulboTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    YulboApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Yulbo",
            modifier = modifier.padding(60.dp),
            fontSize = 50.sp
        )
        Image(painter = painterResource(id = R.drawable.spacekoara), contentDescription = null,modifier = Modifier.padding(20.dp))
        Button(
            onClick = { /* Do something */ },
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(top = 20.dp,bottom = 20.dp,start = 20.dp, end = 20.dp),
            modifier = Modifier.padding(30.dp)
        ){
            Text(
                text = "Start",
                fontSize = 30.sp
            )
        }

    }
}