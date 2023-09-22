package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yulbo.R
import com.example.yulbo.ui.model.ScheduleItem
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun YulboBottomAppBar(
    navigateToSchedule: () -> Unit,
    navigateToCandidates: () -> Unit,
    activeItem: String
) {
    NavigationBar {
        NavigationBarItem(
            selected = activeItem == "schedule",
            onClick = { navigateToSchedule() },
            icon = { Icon(Icons.Filled.DateRange, null)},
            label = { Text(text = "schedule") })
        NavigationBarItem(
            selected = activeItem == "candidates",
            onClick = { navigateToCandidates() },
            icon = { Icon(Icons.Filled.Notifications, null)},
            label = { Text(text = "candidates") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScheduleScreen(
    modifier: Modifier = Modifier,
    scheduleItems: List<ScheduleItem>,
    navigateToCreate: () -> Unit,
    navigateToCandidates: () -> Unit,
    navigateToSchedule: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("登録中のスケジュール")
                },

            )
        },
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
                navigateToCandidates = {
                    navigateToCandidates()
                },
                navigateToSchedule = {
                    navigateToSchedule()
                },
                activeItem = "schedule"
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ){
            scheduleItems.forEach { scheduleItem ->
                val cardColor: Color = if (scheduleItem.isConfirmed) {
                    MaterialTheme.colorScheme.secondaryContainer
                } else {
                    Color(0x00000000)
                }
                Row {
                    Card (modifier = Modifier
                        .weight(1f)
                        .padding(top = 20.dp, start = 10.dp, end = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = cardColor
                        ),
                        border = BorderStroke(3.dp, MaterialTheme.colorScheme.secondaryContainer),
                        shape = MaterialTheme.shapes.medium
                    ){
                        Row {
                            val image = if (scheduleItem.isConfirmed) {
                                Image(
                                    painter = painterResource(id = R.drawable.iconkoala), contentDescription = null,
                                    modifier = Modifier
                                        .padding(
                                            top = 45.dp,
                                            start = 20.dp
                                        )
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Filled.AccountCircle,
                                    contentDescription = "Localized description",
                                    modifier = Modifier.padding(
                                        top = 45.dp,
                                        start = 20.dp
                                    )
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )
                            }

                            Column(
                                modifier = Modifier.weight(4f)
                            ) {
                                Text(
                                    text = scheduleItem.title,
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(10.dp)
                                )

                                val startMonth = scheduleItem.startDatetime.monthValue.toString().padStart(2, '0')
                                val startDay = scheduleItem.startDatetime.dayOfMonth.toString().padStart(2, '0')
                                val startHour = scheduleItem.startDatetime.hour.toString().padStart(2, '0')
                                val startMin = scheduleItem.startDatetime.minute.toString().padStart(2, '0')
                                Text(
                                    text = "$startMonth/$startDay $startHour:$startMin",
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                )
                                val endMonth = scheduleItem.endDateTime.monthValue.toString().padStart(2, '0')
                                val endDay = scheduleItem.endDateTime.dayOfMonth.toString().padStart(2, '0')
                                val endHour = scheduleItem.endDateTime.hour.toString().padStart(2, '0')
                                val endMin = scheduleItem.endDateTime.minute.toString().padStart(2, '0')
                                Text(text = "〜$endMonth/$endDay $endHour:$endMin",
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(bottom = 10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
