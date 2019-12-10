package com.cxyzy.composedemo

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.material.*

@Composable
fun switchDemo() {
    MaterialTheme {
        val checkedState = +state { true }
        Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
        )
    }
}

@Composable
fun checkBoxDemo() {
    MaterialTheme {
        val checkedState = +state { true }
        Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
        )
    }
}

@Composable
fun radioButtonDemo() {
    MaterialTheme {
        RadioButton(selected = true,
                onSelect = { }
        )
    }
}

@Composable
fun radioGroupDemo() {
    MaterialTheme {
        val radioOptions = listOf("A", "B", "C")
        val (selectedOption, onOptionSelected) = +state { radioOptions[0] }
        RadioGroup(
                options = radioOptions,
                selectedOption = selectedOption,
                onSelectedChange = onOptionSelected
        )
    }
}


