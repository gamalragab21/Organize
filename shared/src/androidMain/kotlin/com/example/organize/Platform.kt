package com.example.organize

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

//1
actual class Platform actual constructor() {
    //2
    actual val osName = "Android"
    //3
    actual val osVersion = "${Build.VERSION.SDK_INT}"
    //4
    actual val deviceModel = "${Build.MANUFACTURER} ${Build.MODEL}"
    //5
    actual val cpuType = Build.SUPPORTED_ABIS.firstOrNull() ?: "---"
    //6
    actual val screen: ScreenInfo? = ScreenInfo()
    //7
    actual fun logSystemInfo() {
        Log.d(
            "Platform",
            "($osName; $osVersion; $deviceModel; ${screen!!.width}x${screen!!.height}@${screen!!.density}x; $cpuType)"
        )
    }
}
// 8
actual class ScreenInfo actual constructor() {
    //9
    private val metrics = Resources.getSystem().displayMetrics
    //10
    actual val width = metrics.widthPixels
    actual val height = metrics.heightPixels
    actual val density = round(metrics.density).toInt()
}