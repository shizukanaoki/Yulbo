package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Column {
            Row() {
                Card (modifier = Modifier
                    .weight(1f)
                    .padding(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0x90e3f2fd)
                    ),
                    shape = MaterialTheme.shapes.medium
                ){
                    Text(
                        text = "9/21 9:00 ~ 20:00",
                        fontSize = 35.sp,
                        modifier =  Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
            Row() {
                Card (modifier = Modifier
                    .weight(1f)
                    .padding(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0x9082b1ff)
                    ),
                    shape = MaterialTheme.shapes.medium

                ) {
                    Text(
                        text = "9/21 21:00 ~ 22:00",
                        fontSize = 35.sp,
                        modifier =  Modifier.align(Alignment.CenterHorizontally)
                    )

                }
            }
        }
    }
}
