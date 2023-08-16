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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import python_runner.PythonRunner
import ui.*
import java.io.File


@Composable
@Preview
fun App() {
    //val resourcesDir = File(System.getProperty("compose.application.resources.dir"))

    var text by remember { mutableStateOf("Run Python Code") }

    MaterialTheme {
        Column(Modifier.background(L1)) {
            Row(Modifier.weight(0.1f)){
                NavBar()
            }
            Row(Modifier.weight(0.9f).padding(10.dp)){
                Column(Modifier.weight(0.6f)) {
                    Button({
                        val p = PythonRunner("app/resources/script1.py")
                        text = p.runCode() as String

                    }){
                        Text(text)
                    }
                }
                Column(Modifier.weight(0.4f), verticalArrangement = Arrangement.SpaceBetween){
                    DollarWidget(Modifier.weight(0.3f))
                    Spacer(Modifier.weight(0.2f))
                    DollarWidget2(Modifier.weight(0.3f))
                    Spacer(Modifier.weight(0.2f))
                    SpeedWidget(Modifier.weight(0.3f))
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
        Row(Modifier.weight(0.5f).fillMaxHeight(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
            Spacer(Modifier.weight(1f))
            Box(Modifier.size(Dp(35f)).clip(RoundedCornerShape(100)).background(Color.White))
            Spacer(Modifier.weight(0.05f))
        }

    }
}

@Composable
fun SpeedWidget(modifier: Modifier = Modifier){
    WidgetMedium(modifier) {
        val mod = Modifier.fillMaxSize()
        val circle = Modifier.fillMaxHeight().clip(RoundedCornerShape(100)).background(Color.White).aspectRatio(1f)
        val circle2 = Modifier.fillMaxWidth(0.8f).clip(RoundedCornerShape(100)).background(L2).aspectRatio(1f)
        Row(mod.wrapContentSize(Alignment.Center)){
            Column(circle.wrapContentSize(Alignment.Center)) {
                Row(circle2.wrapContentSize(Alignment.Center)){

                }
            }
        }
    }
}
@Composable
fun DollarWidget2(modifier: Modifier = Modifier){
    WidgetMedium(modifier){
        Column(Modifier.fillMaxSize()) {
            Row(Modifier.weight(0.2f)){
                Text("Dollar Price", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Medium, letterSpacing = 1.2.sp)
            }
            Row(Modifier.weight(0.9f)){
                Column(Modifier.fillMaxWidth(0.5f).fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
                    Spacer(Modifier.size(2.dp))
                    Row(Modifier){
                        Text("20.24", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 1.1.sp)
                    }
                    Row(Modifier){
                        Text("Last 7 Days",color = Color.LightGray, fontSize = 7.sp, letterSpacing = 1.1.sp)
                    }
                    Spacer(Modifier.size(4.dp))
                    Row(Modifier){
                        Text("20.24", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 1.1.sp)
                    }
                    Row(Modifier){
                        Text("Last 7 Days",color = Color.LightGray, fontSize = 7.sp, letterSpacing = 1.1.sp)
                    }
                    Spacer(Modifier.size(2.dp))
                }
                Column(Modifier.fillMaxWidth().fillMaxHeight()
                    .clip(RoundedCornerShape(15.dp)).background(L3).wrapContentSize(Alignment.Center)) {
                    Text("2%", color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

    }
}



@Composable
fun DollarWidget(modifier: Modifier = Modifier){
    WidgetMedium(modifier){
        Row(Modifier){
            Text("Dollar Price", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Medium, letterSpacing = 1.2.sp)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text("20.24", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text("20.21",color = Color.Green, fontSize = 9.sp)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text("Last 7 Days",color = Color.LightGray, fontSize = 7.sp)
        }
    }
}



@Composable
fun WidgetMedium(modifier: Modifier = Modifier, content: @Composable() () -> Unit){
    Row(modifier = modifier.aspectRatio(1.5f).clip(RoundedCornerShape(15.dp)).background(L2).padding(10.dp) ){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
            content()
        }
    }
}




fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}


