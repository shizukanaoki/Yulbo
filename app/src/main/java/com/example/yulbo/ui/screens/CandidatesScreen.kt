package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
    navigateToCandidateDetails: (String) -> Unit
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
        val dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm")
        Column { candidateItems.forEach{ candidateItem ->
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
                                onClick = {navigateToCandidateDetails(candidateItem.matchedScheduleItem.id)}) {
                                Text(text = "詳細")
                            }
                        }
                    }
                }
            }
        }
    }
}
