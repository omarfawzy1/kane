import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import python_runner.PythonRunner

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    var text by remember { mutableStateOf("Run Python Code") }


        Row(modifier.padding(10.dp)){
            Column(Modifier.weight(0.6f)) {
                Button({
                    val p = PythonRunner("src/main/python/script1.py")
                    text = p.runCode() as String

                }){
                    Text(text)
                }
            }
            Column(Modifier.weight(0.4f), verticalArrangement = Arrangement.SpaceBetween){
                DollarWidget(Modifier.weight(0.3f))
                Spacer(Modifier.weight(0.1f))
                DollarWidget2(Modifier.weight(0.3f))
                Spacer(Modifier.weight(0.1f))
                SpeedWidget(Modifier.weight(0.3f))
            }
        }


}