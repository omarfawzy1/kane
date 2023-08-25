import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
@Composable
fun CodeActionBar(modifier: Modifier){
    Row(modifier){
        RunStopButton()
    }
}
@Composable
fun RunStopButton(){
    Box{
        FloatingActionButton({}, ){

        }
    }
}

@Composable
fun NavBar(modifier: Modifier){
    Row(modifier.fillMaxSize().background(Color.DarkGray)){
        Row(Modifier.weight(0.5f).fillMaxHeight(), verticalAlignment = Alignment.CenterVertically){
            Spacer(Modifier.weight(0.05f))
            Box(Modifier.size(Dp(35f)).clip(RoundedCornerShape(100)).background(Color.White))
            Spacer(Modifier.weight(0.5f))
            Text("Home", color = Color.White)
            Spacer(Modifier.weight(0.1f))
            Text("Settings", color = Color.White)
            Spacer(Modifier.weight(0.1f))
            Text("Help", color = Color.White)
        }
        Row(Modifier.weight(0.5f).fillMaxHeight(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
            Column(Modifier.weight(1f)) {

            }
            Box(Modifier.size(Dp(35f)).clip(RoundedCornerShape(100)).background(Color.White))
            Spacer(Modifier.weight(0.05f))
        }
    }
}