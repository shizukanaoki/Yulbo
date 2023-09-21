package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime

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
    scheduleItems: List<ScheduleItem>,
    navigateToCreate: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToCreate() },
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
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){
            scheduleItems.forEach { scheduleItem ->
                var cardColor: Color
                if (scheduleItem.isConfirmed) {
                    cardColor = Color(0x9082b1ff)
                } else {
                    cardColor = Color(0x90e3f2fd)
                }
                Row {
                    Card (modifier = Modifier
                        .weight(1f)
                        .padding(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = cardColor
                        ),
                        shape = MaterialTheme.shapes.medium
                    ){
                        val startMonth = scheduleItem.startDatetime.monthValue.toString().padStart(2, '0')
                        val startDay = scheduleItem.startDatetime.dayOfMonth.toString().padStart(2, '0')
                        val startHour = scheduleItem.startDatetime.hour.toString().padStart(2, '0')
                        val startMin = scheduleItem.startDatetime.minute.toString().padStart(2, '0')
                        Text(
                            text = "$startMonth" + "/" + "$startDay" + " " +"$startHour" + ":" + "$startMin",
                            fontSize = 35.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        val endMonth = scheduleItem.endDateTime.monthValue.toString().padStart(2, '0')
                        val endDay = scheduleItem.endDateTime.dayOfMonth.toString().padStart(2, '0')
                        val endHour = scheduleItem.endDateTime.hour.toString().padStart(2, '0')
                        val endMin = scheduleItem.endDateTime.minute.toString().padStart(2, '0')
                        Text(text = "〜"+"$endMonth"+"/"+"$endDay"+" "+"$endHour"+":"+"$endMin",
                            fontSize = 35.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}

class ScheduleItem(
    val startDatetime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val isConfirmed: Boolean
)

