package com.cxyzy.composedemo

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.material.AlertDialog
import androidx.ui.material.AlertDialogButtonLayout
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

@Composable
fun alertDialogDemo() {
    MaterialTheme {
        Column {
            val openDialog = +state { false }

            Button("Show Alert Dialog", onClick = {
                openDialog.value = true
            })

            if (openDialog.value) {
                AlertDialog(
                        onCloseRequest = {
                            openDialog.value = false
                        },
                        title = {
                            Text(text = "Alert Dialog Title")
                        },
                        text = {
                            Text("Alert Dialog content")
                        },
                        confirmButton = {
                            Button(
                                    "Confirm",
                                    onClick = {
                                        openDialog.value = false
                                    })
                        },
                        dismissButton = {
                            Button(
                                    "Cancel",
                                    onClick = {
                                        openDialog.value = false
                                    })
                        },
                        buttonLayout = AlertDialogButtonLayout.Stacked
                )
            }
        }
    }
}
