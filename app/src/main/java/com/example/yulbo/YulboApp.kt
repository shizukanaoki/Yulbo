package com.example.yulbo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.yulbo.ui.navigation.YulboNavHost

@Composable
fun YulboApp(navController: NavHostController = rememberNavController()) {
    YulboNavHost(navController = navController)
}
