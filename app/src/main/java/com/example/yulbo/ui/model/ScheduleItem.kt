package com.example.yulbo.ui.model

import java.time.LocalDateTime

class ScheduleItem(
    val id: String,
    val startDatetime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val isConfirmed: Boolean
)
