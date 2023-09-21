package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun YulboBottomAppBar(
    navigateToSchedule: () -> Unit,
    navigateToCandidates: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(selected = true, onClick = { navigateToSchedule() }, icon = { /*TODO*/ }, label = { Text(text = "schedule") })
        NavigationBarItem(selected = true, onClick = { navigateToCandidates() }, icon = { /*TODO*/ }, label = { Text(text = "candidates") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScheduleScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },
        bottomBar = {
            YulboBottomAppBar(
                navigateToCandidates = {},
                navigateToSchedule = {}
            )
        }
    ) { innerPadding ->
        Text(text = "schedule screen")
    }
}
