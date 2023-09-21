package com.example.yulbo.ui

import androidx.lifecycle.ViewModel
import com.example.yulbo.ui.screens.ScheduleItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime

class YulboViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(YulboUiState(
        listOf(
            ScheduleItem(
                startDatetime = LocalDateTime.of(2023, 8, 21, 12, 0),
                endDateTime = LocalDateTime.of(2023, 8, 21, 13, 0),
                isConfirmed = false
            ),
            ScheduleItem(
                startDatetime = LocalDateTime.of(2023, 8, 21, 14, 0),
                endDateTime = LocalDateTime.of(2023, 8, 21, 15, 0),
                isConfirmed = true
            ),
        )
    ))
    val uiState: StateFlow<YulboUiState> = _uiState.asStateFlow()
    
    fun addSchedule() {
        val newScheduleItem = ScheduleItem(
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
    var scheduleItems: List<ScheduleItem> = listOf()
)
