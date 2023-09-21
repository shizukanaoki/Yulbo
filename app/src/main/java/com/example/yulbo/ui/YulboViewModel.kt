package com.example.yulbo.ui

import androidx.lifecycle.ViewModel
import com.example.yulbo.ui.model.CandidateItem
import com.example.yulbo.ui.model.ScheduleItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import java.util.UUID

class YulboViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(YulboUiState(
        scheduleItems = listOf(
            ScheduleItem(
                id = UUID.randomUUID().toString(),
                startDatetime = LocalDateTime.of(2023, 8, 21, 12, 0),
                endDateTime = LocalDateTime.of(2023, 8, 21, 13, 0),
                isConfirmed = false
            ),
            ScheduleItem(
                id = UUID.randomUUID().toString(),
                startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
                endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
                isConfirmed = true
            ),
        ),
        candidateItems = listOf(
            CandidateItem(
                id = UUID.randomUUID().toString(),
                partnerUsername = "佐藤さん",
                startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
                endDatetime = LocalDateTime.of(2023, 8, 21, 15, 0)
            )
        )
    ))
    val uiState: StateFlow<YulboUiState> = _uiState.asStateFlow()
    
    fun addSchedule() {
        val newScheduleItem = ScheduleItem(
            id = UUID.randomUUID().toString(),
            startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
            endDateTime = LocalDateTime.of(2023, 8, 21, 14, 30),
            isConfirmed = false
        )
        _uiState.update { currentState ->
            currentState.copy(
                scheduleItems = currentState.scheduleItems.plus(newScheduleItem)
            )
        }
    }
}

data class YulboUiState(
    var scheduleItems: List<ScheduleItem> = listOf(),
    var candidateItems: List<CandidateItem> = listOf()
)
