package com.example.yulbo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    var title by remember { mutableStateOf("") }
    var smonth by remember { mutableStateOf("") }
    var sday by remember { mutableStateOf("") }
    var shour by remember { mutableStateOf("") }
    var smini by remember { mutableStateOf("") }
    var emonth by remember { mutableStateOf("") }
    var eday by remember { mutableStateOf("") }
    var ehour by remember { mutableStateOf("") }
    var emini by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "タイトル") },
            modifier = Modifier.padding(50.dp)
        )
        Text(text = "開始時刻", fontSize = 25.sp)
        Row (){
            OutlinedTextField(
                value = smonth,
                onValueChange = { smonth = it},
                label = { Text(text = "月")},
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            OutlinedTextField(
                value = sday,
                onValueChange = { sday = it},
                label = { Text(text = "日")},
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            OutlinedTextField(
                value = shour,
                onValueChange = { shour = it},
                label = { Text(text = "時")},
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            OutlinedTextField(
                value = smini,
                onValueChange = { smini = it},
                label = { Text(text = "分")},
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
        }
        Text(text = "終了時刻", fontSize = 25.sp)
        Row (){
            OutlinedTextField(
                value = emonth,
                onValueChange = { emonth = it },
                label = { Text(text = "月") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            OutlinedTextField(
                value = eday,
                onValueChange = { eday = it },
                label = { Text(text = "日") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            OutlinedTextField(
                value = ehour,
                onValueChange = { ehour = it },
                label = { Text(text = "時") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            OutlinedTextField(
                value = emini,
                onValueChange = { emini = it },
                label = { Text(text = "分") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
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