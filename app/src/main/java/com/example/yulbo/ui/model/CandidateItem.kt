package com.example.yulbo.ui.model

import java.time.LocalDateTime

data class CandidateItem(
    val id: String,
    val partnerUsername: String,
    val startDatetime: LocalDateTime,
    val endDatetime: LocalDateTime
)
