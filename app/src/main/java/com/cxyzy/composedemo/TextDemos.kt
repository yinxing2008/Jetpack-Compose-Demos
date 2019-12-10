package com.cxyzy.composedemo

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.TextField
import androidx.ui.core.dp
import androidx.ui.layout.Row
import androidx.ui.layout.WidthSpacer
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButtonStyle
import androidx.ui.material.withOpacity
import androidx.ui.text.style.TextOverflow
import java.security.SecureRandom

@Composable
fun buttonAndTextRow() {
    var secureRandom: SecureRandom = SecureRandom()
    val textStr = +state { "" }
    Row() {
        Button(
                text = "Click me",
                onClick = { textStr.value = secureRandom.nextInt().toString() }
        )
        //set space for left and right
        WidthSpacer(width = 10.dp)
        Text(text = "Random: ${textStr.value}")
    }
}

@Composable
fun buttonRow() {
    val count = +state { 0 }
    Button(
            text = "Click count: ${count.value}",
            onClick = { count.value += 1 },
            style = TextButtonStyle()
    )
}

@Composable
fun longTextRows() {
    Text(text = "long text test,long text test,long text test,long text test,",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = (+MaterialTheme.typography()).h4)
    Text(text = "long text test,long text test,long text test,long text test,",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = (+MaterialTheme.typography()).h5.withOpacity(0.6f))
}

@Composable
fun textFieldDemo() {
    val state = +state { "Text Field to input" }
    TextField(
            value = state.value,
            onValueChange = { state.value = it }
    )
}

