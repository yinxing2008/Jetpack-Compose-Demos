package com.cxyzy.composedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                myViews()
            }
        }
    }

    private fun myViews() {
        VerticalScroller() {
            //"modifier = Spacing(10.dp)" set space with parent
            Column(modifier = Spacing(10.dp)) {
                buttonAndTextRow()
                //set space for up and down
                HeightSpacer(height = 10.dp)
                textFieldDemo()
                buttonRow()
                imageDemo(super.getApplication())
                longTextRows()
                alertDialogDemo()
                switchDemo()
                checkBoxDemo()
                radioButtonDemo()
                radioGroupDemo()
            }
        }
    }
}









