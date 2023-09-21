package com.example.yulbo.ui

import androidx.lifecycle.ViewModel
import com.example.yulbo.ui.model.ScheduleItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import java.util.UUID

class YulboViewModel : ViewModel() {
    private val scheduleItems = mutableListOf<ScheduleItem>(
        ScheduleItem(
            id = UUID.randomUUID().toString(),
            userId = 1,
            startDatetime = LocalDateTime.of(2023, 8, 21, 12, 0),
            endDateTime = LocalDateTime.of(2023, 8, 21, 13, 0),
            title = "飲み募",
            isConfirmed = false
        ),
        ScheduleItem(
            id = UUID.randomUUID().toString(),
            userId = 1,
            startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
            endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
            title = "沖縄行きたい",
            isConfirmed = false
        ),
        ScheduleItem(
            id = UUID.randomUUID().toString(),
            userId = 2,
            startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
            endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
            title = "南の島に行きたい",
            isConfirmed = false
        )
    )

    private val _uiState = MutableStateFlow(YulboUiState(
        scheduleItems = findMyScheduleItems()
    ))
    val uiState: StateFlow<YulboUiState> = _uiState.asStateFlow()

    fun addSchedule(
        smonth: Int,
        sday: Int,
        shour: Int,
        sminute: Int,
        emonth: Int,
        eday: Int,
        ehour: Int,
        eminute: Int,
        title: String
    ) {
        val newScheduleItem = ScheduleItem(
            id = UUID.randomUUID().toString(),
            userId = 1,
            startDatetime = LocalDateTime.of(2023, smonth, sday, shour, sminute),
            endDateTime = LocalDateTime.of(2023, emonth, eday, ehour, eminute),
            title = title,
            isConfirmed = false
        )
        scheduleItems.add(newScheduleItem)
        _uiState.update { currentState ->
            currentState.copy(
                scheduleItems = findMyScheduleItems()
            )
        }
    }

    private fun findMyScheduleItems(): List<ScheduleItem> {
        return scheduleItems.filter { scheduleItem -> scheduleItem.userId == 1 }
    }
}

data class YulboUiState(
    var scheduleItems: List<ScheduleItem> = listOf(),
    var candidateItems: List<ScheduleItem> = listOf()
)
