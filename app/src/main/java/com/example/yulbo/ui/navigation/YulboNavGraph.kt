package com.example.yulbo.ui.navigation

import StartScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yulbo.ui.screens.ScheduleItem
import com.example.yulbo.ui.screens.CreateScreen
import com.example.yulbo.ui.screens.ScheduleScreen
import java.time.LocalDateTime


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
            ScheduleScreen(
                scheduleItems = listOf(
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 12, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 13, 0),
                        isConfirmed = false
                    ),
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
                        isConfirmed = true
                    ),
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 12, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 13, 0),
                        isConfirmed = false
                    ),
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
                        isConfirmed = true
                    ),
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 12, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 13, 0),
                        isConfirmed = false
                    ),
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
                        isConfirmed = true
                    ),
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 12, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 13, 0),
                        isConfirmed = false
                    ),
                    ScheduleItem(
                        startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
                        endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
                        isConfirmed = true
                    ),
                )
            ){
                navController.navigate("create")
            }
        }
        composable(route = "create") {
            CreateScreen()
        }
        composable(route = "candidates") {
            Text(text = "candidates")
        }
        composable(route = "confirm") {
            Text(text = "confirm")
        }
    }
}
