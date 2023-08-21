import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import code_editor.CodeEditorColorTransformation
import python_runner.PythonRunner
import ui.*
import java.io.File


@Composable
@Preview

fun App() {
    //val resourcesDir = File(System.getProperty("compose.application.resources.dir"))
    MaterialTheme {
        Column(Modifier.background(L1)) {
            NavBar(Modifier.weight(0.1f))
            CodingScreen(Modifier.weight(0.9f))
        }
    }
}

val ROUNDED = RoundedCornerShape(5)
@Composable
fun codeEditor(){
    var txt by rememberSaveable { mutableStateOf("") }
    var lines by rememberSaveable{ mutableStateOf(5) }
    Column(Modifier.fillMaxSize().clip(ROUNDED).background(Color.Gray)){
        Row(Modifier.weight(0.13f).padding(10.dp).fillMaxSize()) {
            Text("Practice.cpp")
        }
        Row(Modifier.weight(0.9f).fillMaxSize().clip(ROUNDED).background(L3)) {
//            Column(Modifier.width(20.dp).fillMaxHeight().background(Color.DarkGray)) {
//                Spacer(Modifier.size(10.dp))
//            }
            Column(Modifier.width(50.dp).fillMaxHeight().background(Color.DarkGray)) {
                Spacer(Modifier.size(10.dp))
                for (i in 1..lines){
                    Row(Modifier.height(17.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                        Spacer(Modifier.size(4.dp))
                        Box(Modifier.size(12.dp).clip(RoundedCornerShape(100)).background(Color.Red).clickable {  })
                        Spacer(Modifier.size(4.dp))
                        Text(i.toString(), color = Color.Gray)
                    }
                }

            }
            Column(Modifier.padding(start = 5.dp)) {
                Spacer(Modifier.size(10.dp))
                BasicTextField(txt, modifier = Modifier.fillMaxSize(),
                    onValueChange = { txt = it},
                    onTextLayout = {lines = it.lineCount},
//                    textStyle = TextStyle(lineHeight = 17.sp, color = Color.LightGray),
                    visualTransformation = CodeEditorColorTransformation()
                    )


            }
        }
    }
}
var screenHeight = 100.dp
var screenWidth = 100.dp

@Composable
@Preview
fun CodingScreen(modifier: Modifier = Modifier){

    Column(modifier.fillMaxSize().background(L1).padding(5.dp), verticalArrangement = Arrangement.SpaceAround){


        Row(Modifier.weight(0.7f)){
            if(screenWidth > 400.dp){
                Column(Modifier.weight(0.4f).fillMaxSize().clip(RoundedCornerShape(5)).background(L2).padding(10.dp)) {

                }
                Spacer(Modifier.weight(0.01f))
            }
            Column(Modifier.weight(0.6f).fillMaxSize().clip(RoundedCornerShape(5)).background(L2).padding(10.dp).wrapContentSize(
                Alignment.Center)) {
                codeEditor()
            }
            Spacer(Modifier.weight(0.01f))
            Column(Modifier.weight(0.4f).fillMaxSize().clip(RoundedCornerShape(5)).background(L2).padding(10.dp)) {

            }
        }
        Spacer(Modifier.weight(0.01f))
        Row(Modifier.fillMaxSize().weight(0.3f).clip(RoundedCornerShape(5)).background(L2).padding(10.dp)) {

        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {




        App()
    }
}


