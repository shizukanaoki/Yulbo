import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yulbo.R

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navigateToSchedule: () -> Unit,
) {
    Box(){
    //Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.spacekoala),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Button(
            onClick = { navigateToSchedule() },
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(top = 20.dp,bottom = 20.dp,start = 20.dp, end = 20.dp),
            modifier = Modifier.offset(x = 140.dp, y = 530.dp)
            //modifier = Modifier.padding(30.dp)
        ){
            Text(
                text = "Start",
                fontSize = 30.sp
            )
        }

    }
}
