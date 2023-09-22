package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yulbo.ui.model.CandidateItem
import java.time.format.DateTimeFormatter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandidatesScreen(
    modifier: Modifier = Modifier,
    candidateItems: List<CandidateItem>,
    navigateToSchedule: () -> Unit,
    navigateToCandidates: () -> Unit,
    navigateToCandidateDetails: (String, String) -> Unit
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
                    Text("マッチ候補")
                },

                )
        },
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
    ){ innerPadding ->
        val dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm")
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()).padding(innerPadding)
        ) { candidateItems.forEach{ candidateItem ->
                Row {
                    Card (modifier = Modifier
                        .weight(1f)
                        .padding(20.dp)
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = candidateItem.matchedScheduleItem.userId.toString()+"さん", fontSize = 20.sp)
                            Text(text = candidateItem.myScheduleItem.startDatetime.format(dtf)+"〜"+ candidateItem.myScheduleItem.endDateTime.format(dtf))
                            Button(
                                modifier = Modifier.padding(top = 10.dp),
                                onClick = {
                                    navigateToCandidateDetails(
                                        candidateItem.myScheduleItem.id,
                                        candidateItem.matchedScheduleItem.id
                                    )
                                }
                            ) {
                                Text(text = "詳細")
                            }
                        }
                    }
                }
            }
        }
    }
}
