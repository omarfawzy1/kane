import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.*

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Column(Modifier.background(L1)) {
            Row(Modifier.weight(0.1f)){
                NavBar()
            }
            Row(Modifier.weight(0.9f).padding(10.dp)){
                Spacer(Modifier.weight(0.5f))
                Column(Modifier.weight(0.4f)){
                    Row(Modifier.weight(0.5f)){
                        WidgetMedium(Modifier.weight(0.5f))
                        Spacer(Modifier.weight(0.05f))
                        WidgetMedium(Modifier.weight(0.5f))
                    }
                    Row(Modifier.weight(0.5f)){
                        WidgetMedium(Modifier.weight(0.3f))
                        Spacer(Modifier.weight(0.3f))
                        WidgetMedium(Modifier.weight(0.3f))
                    }
                }
            }
        }
    }
}

@Composable
fun NavBar(){
    Row(Modifier.fillMaxSize().background(Color.DarkGray)){
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
        Row(Modifier.weight(0.5f)){

        }

    }
}
@Composable
@Preview
fun WidgetMedium(modifier: Modifier = Modifier){
    Row(modifier = modifier.aspectRatio(1.618f).clip(RoundedCornerShape(15.dp)).background(L2).padding(10.dp) ){
        Column(modifier = Modifier.fillMaxSize()) {
            Text("Hiiii", color = Color.White, fontSize = 0.7.em)
        }
    }
}
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}


