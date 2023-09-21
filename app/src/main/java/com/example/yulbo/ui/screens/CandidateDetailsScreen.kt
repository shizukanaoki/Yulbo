package com.example.yulbo.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CandidateDetailsScreen(
    itemId: String,
    navigateToSchedule: () -> Unit
) {
    Text(text = itemId)
}