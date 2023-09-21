package com.example.yulbo.ui.navigation

import StartScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yulbo.ui.YulboViewModel
import com.example.yulbo.ui.screens.CandidatesScreen
import com.example.yulbo.ui.screens.CreateScreen
import com.example.yulbo.ui.screens.ScheduleScreen

@Composable
fun YulboNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val yulboViewModel: YulboViewModel = YulboViewModel()
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
                scheduleItems = yulboViewModel.uiState.collectAsState().value.scheduleItems,
                navigateToCreate = {
                    navController.navigate("create")
                },
                navigateToCandidates = {
                    navController.navigate("candidates")
                },
                navigateToSchedule = {
                    navController.navigate("schedule")
                }
            )
        }
        composable(route = "create") {
            CreateScreen()
        }
        composable(route = "candidates") {
            CandidatesScreen(
                candidateItems = yulboViewModel.uiState.collectAsState().value.candidateItems,
                navigateToCandidates = {
                    navController.navigate("candidates")
                },
                navigateToSchedule = {
                    navController.navigate("schedule")
                }
            )
        }
        composable(route = "confirm") {
            Text(text = "confirm")
        }
    }
}
