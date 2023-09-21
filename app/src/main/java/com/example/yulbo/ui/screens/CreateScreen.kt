package com.example.yulbo.ui.screens

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.widget.DatePicker
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Preview
@Composable
fun Preview() {
    CreateScreen(navigateToSchedule = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreen(
    navigateToSchedule: () -> Unit
)
{
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var text by remember { mutableStateOf("タイトル") }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "タイトル") },
            modifier = Modifier.padding(50.dp)
        )
        Text(text = "開始時刻", fontSize = 25.sp)
        Row (){
            var smonth by remember { mutableStateOf("") }
            OutlinedTextField(
                value = smonth,
                onValueChange = { smonth = it},
                label = { Text(text = "月")},
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            var sdate by remember { mutableStateOf("") }
            OutlinedTextField(
                value = sdate,
                onValueChange = { sdate = it},
                label = { Text(text = "日")},
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            var shour by remember { mutableStateOf("") }
            OutlinedTextField(
                value = shour,
                onValueChange = { shour = it},
                label = { Text(text = "時")},
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            var smini by remember { mutableStateOf("") }
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
            var emonth by remember { mutableStateOf("") }
            OutlinedTextField(
                value = emonth,
                onValueChange = { emonth = it },
                label = { Text(text = "月") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            var edate by remember { mutableStateOf("") }
            OutlinedTextField(
                value = edate,
                onValueChange = { edate = it },
                label = { Text(text = "日") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            var ehour by remember { mutableStateOf("") }
            OutlinedTextField(
                value = ehour,
                onValueChange = { emonth = it },
                label = { Text(text = "時") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
            var emini by remember { mutableStateOf("") }
            OutlinedTextField(
                value = emini,
                onValueChange = { emonth = it },
                label = { Text(text = "分") },
                modifier = Modifier
                    .width(70.dp)
                    .padding(5.dp)
            )
        }
        Button(
            onClick = {navigateToSchedule()},
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



class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        // Do something with the date chosen by the user
    }
}