package com.example.organize


actual class Platform actual constructor() {

    actual val osName =kotlin.native.Platform.osFamily.name
    //2
    actual val osVersion = "OSVERSION"
    //3
    actual val deviceModel: String="IOSMODEL"
    //4
    actual val cpuType = kotlin.native.Platform.cpuArchitecture.name
    //5
    actual val screen: ScreenInfo? = ScreenInfo()
    //6
    actual fun logSystemInfo() {
        print(
            "($osName; $osVersion; $deviceModel; ${screen!!.width}x${screen!!.height}@${screen!!.density}x; $cpuType)"
        )
    }
}
actual class ScreenInfo actual constructor() {
    //7
    actual val width =9
    actual val height =10
    actual val density = 11
}