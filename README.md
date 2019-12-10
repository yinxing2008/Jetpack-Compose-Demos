# Jetpack-Compose-Demos
demos for jetpack compose
# Blog
https://blog.csdn.net/yinxing2008/article/details/103477567
# Jetpack Compose是什么?
Jetpack Compose 是安卓用于构建UI的一种新方式,采用代码而非xml文件方式，写法与Flutter非常相似。
官方主页：[https://developer.android.google.cn/jetpack/compose](https://developer.android.google.cn/jetpack/compose)
官方Demo：[https://github.com/android/compose-samples/tree/master/JetNews](https://github.com/android/compose-samples/tree/master/JetNews)
官方入门指导: [https://developer.android.google.cn/jetpack/compose/tutorial](https://developer.android.google.cn/jetpack/compose/tutorial)


# 约束条件
1. Android Studio: 4.0及以上
2. 支持安卓版本:Android API 21(即5.0)及以上
3. 必须使用kotlin语言
# 优点
1. 代码更少
少了xml,少了activity和xml之间的关联.
2. 双向绑定
数据变化了,UI就自动变化.
# 缺点
1. 含有参数的Composable函数不能直接预览.
2. Composable函数必须添加@Preview注解才能预览.
3. 代码修改后,需要重新编译才能预览.
4. 目前还不完善,相比于Flutter,还处于幼儿园水平.
5. 相比于xml画页面布局,效率会有降低.
# 常见控件使用样例
## 1. 文本显示
```
Text(text = "众鸟高飞尽，孤云独去闲。相看两不厌，只有敬亭山。")
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee13041489?w=264&h=78&f=png&s=14041)
## 2. 文本输入框
```
val state = +state { "Text Field to input" }
TextField(
        value = state.value,
        onValueChange = { state.value = it }
)
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee131fc621?w=317&h=237&f=png&s=30556)
## 3. 按钮
```
Button(text = "咬我啊", onClick = { Log.v("test", "被咬了") })
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee127b32d6?w=105&h=47&f=png&s=3864)
## 4.弹出框
```
MaterialTheme {
    Column {
        val openDialog = +state { false }

        Button("Click me", onClick = {
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
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee17a40dc3?w=258&h=203&f=png&s=11600)
## 5. 开关
```
MaterialTheme {
    val checkedState = +state { true }
    Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
    )
}
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee180fdd55?w=101&h=64&f=png&s=3094)
## 6. 单选框
```
MaterialTheme {
    RadioButton(selected = true,
            onSelect = { }
    )
}
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee16bff2a3?w=34&h=34&f=png&s=1615)
## 7. 复选框
```
MaterialTheme {
    val checkedState = +state { true }
    Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
    )
}
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee3cc7e245?w=41&h=36&f=png&s=942)
## 8. 单选框组
```
MaterialTheme {
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = +state { radioOptions[0] }
    RadioGroup(
            options = radioOptions,
            selectedOption = selectedOption,
            onSelectedChange = onOptionSelected
    )
}
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee3f07bdfc?w=86&h=122&f=png&s=3983)
## 9.图片
```
Container(modifier = Height(300.dp) wraps Expanded) {
    Clip(shape = RoundedCornerShape(4.dp)) {
        DrawImage(+imageResource(R.drawable.img_0))
    }
}
```
![](https://user-gold-cdn.xitu.io/2019/12/10/16eeeeee3f07d9a5?w=316&h=279&f=png&s=146975)

# 源代码
[https://github.com/cxyzy1/Jetpack-Compose-Demos](https://github.com/cxyzy1/Jetpack-Compose-Demos)


