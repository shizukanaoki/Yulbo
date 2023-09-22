package com.example.yulbo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.yulbo.ui.model.CandidateItem

@Composable
fun CandidateDetailsScreen(
    candidateItem: CandidateItem,
    confirmSchedule: () -> Unit,
    navigateToCandidates: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = candidateItem.myScheduleItem.title)
        Button(onClick = {confirmSchedule}) {
            Text(text = "確定")
        }
        Button(onClick = {navigateToCandidates()}) {
            Text(text = "戻る")
        }
    }
}
