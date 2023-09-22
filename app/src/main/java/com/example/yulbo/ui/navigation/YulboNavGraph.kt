package com.example.yulbo.ui.navigation

import StartScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yulbo.ui.YulboViewModel
import com.example.yulbo.ui.screens.CandidateDetailsScreen
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
        startDestination = "start",
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
            CreateScreen(
                navigateToSchedule = {navController.navigate("schedule")},
                createSchedule =  {smonth, sday, shour, sminute, emonth, eday, ehour, eminute, title ->
                    yulboViewModel.addSchedule(
                        smonth, sday, shour, sminute, emonth, eday, ehour, eminute, title
                    )
                }
            )
        }
        composable(route = "candidates") {
            CandidatesScreen(
                candidateItems = yulboViewModel.uiState.collectAsState().value.candidateItems,
                navigateToCandidates = {
                    navController.navigate("candidates")
                },
                navigateToSchedule = {
                    navController.navigate("schedule")
                },
                navigateToCandidateDetails = { myScheduleItemId, matchedScheduleItemId ->
                    navController.navigate("candidate_details/${myScheduleItemId}/${matchedScheduleItemId}")
                }

            )
        }
        composable(
            route = "candidate_details/{myScheduleItemId}/{matchedScheduleItemId}",
            arguments = listOf(
                navArgument("myScheduleItemId") {
                    type = NavType.StringType
                },
                navArgument("matchedScheduleItemId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val myScheduleItemId = backStackEntry.arguments?.getString("myScheduleItemId")
            val matchedScheduleItemId = backStackEntry.arguments?.getString("matchedScheduleItemId")
            if (myScheduleItemId == null || matchedScheduleItemId == null) {
                Text(text = "invalid itemId")
            } else {
                CandidateDetailsScreen(
                    candidateItem = yulboViewModel.findCandidateItem(myScheduleItemId, matchedScheduleItemId),
                    confirmSchedule = { myScheduleItemId, matchedScheduleItemId ->
                        yulboViewModel.confirmSchedule(myScheduleItemId, matchedScheduleItemId)
                        navController.navigate("schedule")
                    } ,
                    navigateToCandidates = { navController.navigate("candidates") },
                )
            }
        }
    }
}
