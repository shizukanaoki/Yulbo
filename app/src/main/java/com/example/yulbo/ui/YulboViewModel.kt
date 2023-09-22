package com.example.yulbo.ui

import android.util.Log
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
    private val scheduleItems = mutableListOf(
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
        scheduleItems = findMyScheduleItems(),
        candidateItems = calculateCandidateItems()
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
            endDateTime = LocalDateTime.of(2023, emonth ,eday, ehour, eminute),
            title = title,
            isConfirmed = false
        )
        scheduleItems.add(newScheduleItem)
        _uiState.value.scheduleItems = findMyScheduleItems()
    }

    fun confirmSchedule(myScheduleItemId: String, matchedScheduleItemId: String) {
        Log.d("confirmSchedule", "myScheduleItemId: ${myScheduleItemId}, matchedScheduleItemId: ${matchedScheduleItemId}")
    }

    fun findCandidateItem(myScheduleItemId: String, matchedScheduleItemId: String): CandidateItem {
        val myScheduleItem = scheduleItems.find { scheduleItem -> scheduleItem.id ==  myScheduleItemId}
        val matchedScheduleItem = scheduleItems.find { scheduleItem -> scheduleItem.id ==  matchedScheduleItemId}
        if (myScheduleItem == null || matchedScheduleItem == null) {
            throw IllegalArgumentException("myScheduleItem or matchedScheduleItem is not found")
        } else {
            return CandidateItem(
                myScheduleItem = myScheduleItem,
                matchedScheduleItem = matchedScheduleItem,
            )
        }
    }

    private fun findMyScheduleItems(): List<ScheduleItem> {
        return scheduleItems.filter { scheduleItem -> scheduleItem.userId == 1 }
    }

    private fun calculateCandidateItems(): List<CandidateItem> {
        val othersScheduleItems = scheduleItems.filter { scheduleItem -> scheduleItem.userId ==2 }
        val myScheduleItems = scheduleItems.filter { scheduleItem -> scheduleItem.userId == 1 }
        val result = mutableListOf<CandidateItem>();
        othersScheduleItems.forEach { othersScheduleItem ->
            myScheduleItems.forEach {myScheduleItem ->
                if (
                    othersScheduleItem.startDatetime == myScheduleItem.startDatetime &&
                    othersScheduleItem.endDateTime == myScheduleItem.endDateTime
                ) {
                    val candidateItem = CandidateItem(
                        myScheduleItem = myScheduleItem,
                        matchedScheduleItem = othersScheduleItem
                    )
                    result.add(candidateItem)
                }
            }
            return result
        }

        return listOf(
            CandidateItem(
                myScheduleItem = scheduleItems[0],
                matchedScheduleItem = scheduleItems[2]
            )
        )
    }
}

data class YulboUiState(
    var scheduleItems: List<ScheduleItem> = listOf(),
    var candidateItems: List<CandidateItem> = listOf()
)
