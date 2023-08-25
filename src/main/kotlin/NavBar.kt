import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CodeActionBar(modifier: Modifier){
    Column(modifier, verticalArrangement = Arrangement.SpaceAround){
        Row{
            RunStopButton(CodeStatus.Stopped)
            Spacer(Modifier.size(10.dp))
            DebugButton(CodeStatus.Stopped)
        }
    }
}
@Composable
fun RunStopButton(status: CodeStatus){
    FloatingActionButton({}, shape = RoundedCornerShape(100),
        modifier = Modifier.size(35.dp),
        backgroundColor = Color.White){
        when(status){
            CodeStatus.Running -> Icon(Rounded.Home,"")
            CodeStatus.Paused -> Icon(Rounded.Add,"")
            CodeStatus.Debugging -> Icon(Rounded.Share,"")
            CodeStatus.Stopped -> Icon(Rounded.Notifications,"")
        }

    }
}

@Composable
fun DebugButton(status: CodeStatus){
    FloatingActionButton({}, shape = RoundedCornerShape(100),
        modifier = Modifier.size(35.dp),
        backgroundColor = Color.White){
        when(status){
            CodeStatus.Running -> Icon(Rounded.Home,"")
            CodeStatus.Paused -> Icon(Rounded.Add,"")
            CodeStatus.Debugging -> Icon(Rounded.Share,"")
            CodeStatus.Stopped -> Icon(Rounded.Notifications,"")
        }

    }
}

@Composable
fun NavBar(modifier: Modifier){
    Row(modifier.fillMaxSize().background(Color.DarkGray)){
        Row(Modifier.weight(0.6f).fillMaxHeight(), verticalAlignment = Alignment.CenterVertically){
            Spacer(Modifier.weight(0.05f))
            Box(Modifier.size(Dp(35f)).clip(RoundedCornerShape(100)).background(Color.White))
            Spacer(Modifier.weight(0.5f))
            Text("Home", color = Color.White)
            Spacer(Modifier.weight(0.1f))
            Text("Settings", color = Color.White)
            Spacer(Modifier.weight(0.1f))
            Text("Help", color = Color.White)
        }
        Spacer(Modifier.weight(0.1f))
        Row(Modifier.weight(0.4f).fillMaxHeight(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
            CodeActionBar(Modifier.weight(1f))
            Box(Modifier.size(Dp(35f)).clip(RoundedCornerShape(100)).background(Color.White))
            Spacer(Modifier.weight(0.05f))
        }
    }
}