import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yulbo.R

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navigateToSchedule: () -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Yulbo",
            modifier = modifier.padding(60.dp),
            fontSize = 50.sp
        )
        Image(painter = painterResource(id = R.drawable.spacekoara), contentDescription = null,modifier = Modifier.padding(20.dp))
        Button(
            onClick = { navigateToSchedule() },
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(top = 20.dp,bottom = 20.dp,start = 20.dp, end = 20.dp),
            modifier = Modifier.padding(30.dp)
        ){
            Text(
                text = "Start",
                fontSize = 30.sp
            )
        }

    }
}
