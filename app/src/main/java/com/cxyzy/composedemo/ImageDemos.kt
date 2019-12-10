package com.cxyzy.composedemo

import android.content.Context
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Container
import androidx.ui.layout.Expanded
import androidx.ui.layout.Height
import androidx.ui.res.imageResource
import java.security.SecureRandom

@Composable
fun imageDemo(context: Context) {
    val imgId = getRandomImg(context)
    var image = +imageResource(imgId)
    Container(modifier = Height(300.dp) wraps Expanded) {
        Clip(shape = RoundedCornerShape(4.dp)) {
            DrawImage(image)
        }
    }
}

private fun getRandomImg(context: Context): Int {
    var secureRandom: SecureRandom = SecureRandom()
    val imgIndex = kotlin.math.abs(secureRandom.nextInt()) % 5
    return context.resources.getIdentifier("img_$imgIndex", "drawable", context.packageName)
}
