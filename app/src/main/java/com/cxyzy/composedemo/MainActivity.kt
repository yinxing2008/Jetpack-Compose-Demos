package com.cxyzy.composedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButtonStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                myViews()
            }
        }
    }

    @Composable
    fun myViews() {
        //下面的"modifier = Spacing(10.dp)"用于设置当前控件相对于父控件的间隔
        Column(modifier = Spacing(10.dp)) {
            testRow1()
            //设置上下控件间的间隔
            HeightSpacer(height = 10.dp)
            buttonRow()
            HeightSpacer(height = 10.dp)
            imageRow()
            HeightSpacer(height = 10.dp)
            longTextRows()
        }
    }

    @Composable
    fun testRow1() {
        var secureRandom: SecureRandom = SecureRandom()
        val textStr = +state { "" }
        Row() {
            Button(
                    text = "点我吧",
                    //添加点击事件，动态修改上面Text控件的内容
                    onClick = { textStr.value = secureRandom.nextInt().toString() }
            )
            //设置左右控件间的间隔
            WidthSpacer(width = 10.dp)
            Text(text = "随机数: ${textStr.value}")
        }
    }

    @Composable
    fun buttonRow() {
        val count = +state { 0 }
        Button(
                text = "我是按钮，被点击次数: ${count.value}",
                //动态修改Button里的显示文本内容
                onClick = { count.value += 1 },
                style = TextButtonStyle()
        )
    }

    @Composable
    fun imageRow() {
        val imgId = getRandomImg()
        var image = +imageResource(imgId)
        Container(modifier = Height(300.dp) wraps Expanded) {
            Clip(shape = RoundedCornerShape(4.dp)) {
                DrawImage(image)
            }
        }
    }

    private fun getRandomImg(): Int {
        var secureRandom: SecureRandom = SecureRandom()
        val imgIndex = kotlin.math.abs(secureRandom.nextInt()) % 5
        return resources.getIdentifier("img_$imgIndex", "drawable", packageName)
    }

    @Composable
    fun longTextRows() {
        Text(text = "独坐幽篁里，弹琴复长啸.深林人不知，明月来相照。",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = (+MaterialTheme.typography()).h4)
        Text(text = "葡萄美酒夜光杯，欲饮琵琶马上催。醉卧沙场君莫笑，古来征战几人回？",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = (+MaterialTheme.typography()).h5.withOpacity(0.6f))

    }
}





