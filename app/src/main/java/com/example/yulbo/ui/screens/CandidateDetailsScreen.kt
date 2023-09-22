package com.example.yulbo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yulbo.R
import com.example.yulbo.ui.model.CandidateItem
import java.time.format.DateTimeFormatter

@Composable
fun CandidateDetailsScreen(
    candidateItem: CandidateItem,
    confirmSchedule: (String, String) -> Unit,
    navigateToCandidates: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.confiermedkoara),
            contentDescription = null,

            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(30.dp)
                .size(180.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        val dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm")
        Text(text = "候補日時："+candidateItem.myScheduleItem.startDatetime.format(dtf)+" 〜 "+candidateItem.myScheduleItem.endDateTime.format(dtf), fontSize = 20.sp, modifier = Modifier.padding(10.dp))
        Text(text = candidateItem.myScheduleItem.userId.toString()+"さん : "+ candidateItem.myScheduleItem.title, fontSize = 20.sp, modifier = Modifier.padding(10.dp))
        Text(text = candidateItem.matchedScheduleItem.userId.toString()+"さん : "+candidateItem.matchedScheduleItem.title, fontSize = 20.sp, modifier = Modifier.padding(10.dp))

        Button(
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
            modifier = Modifier.padding(10.dp),
            onClick = {
            confirmSchedule(
                candidateItem.myScheduleItem.id,
                candidateItem.matchedScheduleItem.id
            )
        }) {
            Text(text = "確定", fontSize = 20.sp)
        }
        Button(
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
            modifier = Modifier.padding(10.dp),
            onClick = {navigateToCandidates()
            }) {
            Text(text = "戻る", fontSize = 20.sp)


        }
    }
}
