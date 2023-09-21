package com.example.yulbo.ui.model

import java.time.LocalDateTime

class OthersScheduleItem(
    val id: String,
    val username: String,
    val startDatetime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val isConfirmed: Boolean
)
