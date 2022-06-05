
package com.example.organize

actual class Platform actual constructor() {
    //1
    actual val osName = System.getProperty("os.name") ?: "Desktop"
    //2
    actual val osVersion = System.getProperty("os.version") ?: "---"
    //3
    actual val deviceModel = "Desktop"
    //4
    actual val cpuType = System.getProperty("os.arch") ?: "---"
    //5
    actual val screen: ScreenInfo? = null
    //6
    actual fun logSystemInfo() {
        print("($osName; $osVersion; $deviceModel; $cpuType)")
    }
}
actual class ScreenInfo actual constructor() {
    //7
    actual val width = 0
    actual val height = 0
    actual val density = 0
}