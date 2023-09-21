package com.example.yulbo.ui.navigation

import StartScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yulbo.ui.screens.ScheduleScreen


@Composable
fun YulboNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = "schedule",
        modifier = modifier
    ) {
        composable(route = "start") {
            StartScreen(modifier = modifier) {
                navController.navigate("schedule")
            }
        }
        composable(route = "schedule") {
            ScheduleScreen()
        }
        composable(route = "candidates") {
            Text(text = "candidates")
        }
        composable(route = "confirm") {
            Text(text = "confirm")
        }
        composable(route = "create") {
            Text(text = "create")
        }
    }
}
