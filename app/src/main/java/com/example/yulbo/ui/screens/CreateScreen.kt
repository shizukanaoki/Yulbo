package com.example.yulbo.ui.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreen(
    navigateToSchedule: () -> Unit,
    createSchedule: (
        smonth: Int,
        sday: Int,
        shour: Int,
        sminute: Int,
        emonth: Int,
        eday: Int,
        ehour: Int,
        eminute: Int,
        title: String
    ) -> Unit
)
{
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var smonth by remember { mutableStateOf(0) }
    var sday by remember { mutableStateOf(0) }
    var shour by remember { mutableStateOf(0) }
    var smini by remember { mutableStateOf(0) }
    var emonth by remember { mutableStateOf(0) }
    var eday by remember { mutableStateOf(0) }
    var ehour by remember { mutableStateOf(0) }
    var emini by remember { mutableStateOf(0) }

    // timePicker
    val startTimePicker = TimePickerDialog(
        context,
        { _, selectedHour: Int, selectedMinute: Int ->
            shour = selectedHour
            smini = selectedMinute
        }, calendar[Calendar.HOUR_OF_DAY], calendar[Calendar.MINUTE], false
    )
    val endTimePicker = TimePickerDialog(
        context,
        { _, selectedHour: Int, selectedMinute: Int ->
            ehour = selectedHour
            emini = selectedMinute
        }, calendar[Calendar.HOUR_OF_DAY], calendar[Calendar.MINUTE], false
    )
    // datePicker
    val startDatePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            smonth = selectedMonth
            sday = selectedDayOfMonth
            startTimePicker.show()
        }, calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH]
    )
    startDatePicker.datePicker.minDate = calendar.timeInMillis
    val endDatePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            emonth = selectedMonth
            eday = selectedDayOfMonth
            endTimePicker.show()
        }, calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH]
    )
    endDatePicker.datePicker.minDate = calendar.timeInMillis

    var title by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("スケジュールを作成")
                },
                navigationIcon = {
                    IconButton(onClick = { navigateToSchedule() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
    )
    { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "タイトル") },
                modifier = Modifier.padding(50.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "開始日時", fontSize = 25.sp)
                Row {
                    Text(
                        text = if (
                            smonth != 0 && sday != 0
                        ) {
                            "$smonth/$sday"
                        } else {
                            "00/00"
                        },
                        modifier = Modifier.padding(end = 10.dp),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "$shour:$smini",
                        fontSize = 20.sp,
                    )
                }
                Button(
                    onClick = {
                        startDatePicker.show()
                    }
                ) {
                    Text(text = "Select a start datetime")
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "終了日時",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Row(

                ) {
                    Text(
                        text = if (
                            emonth != 0 && eday != 0
                        ) {
                            "$emonth/$eday"
                        } else {
                            "00/00"
                        },
                        fontSize = 20.sp,
                        modifier = Modifier.padding(end = 10.dp),
                    )
                    Text(
                        text = "$ehour:$emini",
                        fontSize = 20.sp
                    )
                }
                Button(
                    onClick = {
                        endDatePicker.show()
                    }
                ) {
                    Text(text = "Select a end datetime")
                }
            }

            Button(
                onClick = {
                    createSchedule(
                        smonth.toInt(),
                        sday.toInt(),
                        shour.toInt(),
                        smini.toInt(),
                        emonth.toInt(),
                        eday.toInt(),
                        ehour.toInt(),
                        emini.toInt(),
                        title
                    )
                    navigateToSchedule()
                },
                shape = MaterialTheme.shapes.small,
                contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                modifier = Modifier.padding(100.dp)
            ) {
                Text(
                    text = "作成",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}