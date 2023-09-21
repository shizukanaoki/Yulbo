package com.example.yulbo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.yulbo.ui.model.CandidateItem

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
        Column {
            candidateItems.forEach{ candidateItem ->  
                Row {
                    Card {
                        Text(text = candidateItem.matchedScheduleItem.title)
                        Text(text = candidateItem.myScheduleItem.title)
                        Button(onClick = {navigateToCandidateDetails(candidateItem.matchedScheduleItem.id)}) {
                            Text(text = "詳細")
                        }
                    }
                }
            }
        }
    }
}
