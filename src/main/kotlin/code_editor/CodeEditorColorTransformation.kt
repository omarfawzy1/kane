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
            tokenizer(text.toString()),
            OffsetMapping.Identity)
    }

    var keywords = arrayOf(
        "if",
        "for",
        "while",
        "switch",
        "case"
    ).map{
        it.toRegex()
    }
    var built_types = arrayOf(
        "int\\[?]?".toRegex(),
        "float\\[?]?".toRegex(),
        "double\\[?]?".toRegex(),
        "string\\[?]?".toRegex(),
        "(unordered_)?map<.*>".toRegex(),
        "(unordered_)?set<.*>".toRegex(),
    )
    var comments = arrayOf("/\\*.*\\*/".toRegex())

    data class Token(
        val start : Int,
        val end : Int,
        val color : Color ,
        val priority : Int
    ){

    }
    private fun tokenizer(code : String): AnnotatedString {
        val intervals =  ArrayList<Token>()
        for(regex : Regex in keywords){
            val matches = regex.findAll(code)
            for(match in matches){
                intervals.add(
                    Token(match.range.first,
                        match.range.last + 1,
                        Color.Yellow,
                        1
                    )
                )
            }
        }
        for(regex : Regex in built_types){
            val matches = regex.findAll(code)
            for(match in matches){
                intervals.add(
                    Token(match.range.first,
                        match.range.last + 1,
                        Color.Blue,
                        2
                    )
                )
            }
        }
        for(regex : Regex in comments){
            val matches = regex.findAll(code)
            for(match in matches){
                intervals.add(
                    Token(match.range.first,
                        match.range.last + 1,
                        Color.Gray,
                        3
                    )
                )
            }
        }
        intervals.sortBy { it.priority }
        return buildAnnotatedString{
            append(code)
            intervals.forEach{
                addStyle(SpanStyle(color = it.color),
                    it.start,
                    it.end
                )
            }
        }
    }
}