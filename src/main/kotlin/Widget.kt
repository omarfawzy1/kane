import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.L2
import ui.L3


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
                        Text("20.24", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 1.1.sp)
                    }
                    Row(Modifier){
                        Text("Last 7 Days",color = Color.LightGray, fontSize = 7.sp, letterSpacing = 1.1.sp)
                    }
                    Spacer(Modifier.size(4.dp))
                    Row(Modifier){
                        Text("20.24", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 1.1.sp)
                    }
                    Row(Modifier){
                        Text(modifier = Modifier.fillMaxWidth(0.9f), text = "Last 7 Days",color = Color.LightGray, fontSize = 7.sp, letterSpacing = 1.1.sp)
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