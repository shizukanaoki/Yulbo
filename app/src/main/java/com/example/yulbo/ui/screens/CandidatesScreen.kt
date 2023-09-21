package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandidatesScreen(
    modifier: Modifier = Modifier,
    navigateToSchedule: () -> Unit,
    navigateToCandidates: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            YulboBottomAppBar(
                navigateToCandidates = {
                    navigateToCandidates()
                },
                navigateToSchedule = {
                    navigateToSchedule()
                },
                activeItem = "candidates"
            )
        }
    ){ paddingContext ->
        Text(text = "aaa")
    }
}
