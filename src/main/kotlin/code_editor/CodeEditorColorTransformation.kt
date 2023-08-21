package code_editor

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle

class CodeEditorColorTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            buildAnnotatedStringWithColors(text.toString()),
            OffsetMapping.Identity)
    }

    private fun buildAnnotatedStringWithColors(text:String): AnnotatedString{
        val words: List<String> = text.split(" ")
        // splits by whitespace
        val colors = listOf(Color.Red,Color.Black,Color.Yellow,Color.Blue)
        var count = 0
//
//        val builder = AnnotatedString.Builder()
//        for (word in words) {
//            builder.withStyle(style = SpanStyle(color = colors[count%4])) {
//                append("$word ")
//            }
//            count ++
//        } return builder.toAnnotatedString()
//
        return buildAnnotatedString {
            for (word in words){
                if (word.isEmpty()) continue
                withStyle(style = SpanStyle(color = colors[count%4])){
                    append("$word ")
                }
                count++
            }

            while(this.length < text.length){
                append(" ")
            }
        }

    }
}