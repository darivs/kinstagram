package de.constval.kinstagram.config

class Devices {
    companion object {
        val SAMSUNG_GALAXY_S7 = Device(
            "23",
            "6.0.1",
            "640dpi",
            "1440x2560",
            "samsung",
            "SM-G930F",
            "herolte",
            "samsungexynos8890"
        )
        val SAMSUNG_GALAXY_S7_EDGE = Device(
            "23",
            "6.0.1",
            "640dpi",
            "1440x2560",
            "samsung",
            "SM-G935F",
            "hero2lte",
            "samsungexynos8890"
        )
        val ONEPLUS_3T = Device(
            "24",
            "7.0",
            "380dpi",
            "1080x1920",
            "OnePlus",
            "ONEPLUS A3010",
            "OnePlus3T",
            "qcom"
        )
        val LG_G5 = Device(
            "24",
            "6.0.1",
            "640dpi",
            "1440x2392",
            "LGE/lge",
            "RS988",
            "h1",
            "h1"
        )
        val HUAWAI_MATE_9_PRO = Device(
            "24",
            "7.0",
            "640dpi",
            "1440x2460",
            "HUAWEI",
            "LON-L29",
            "HWLON",
            "hi3660"
        )
        val ZTE_AXON_7 = Device(
            "23",
            "6.0.1",
            "640dpi",
            "1440x2560",
            "ZTE",
            "ZTE A2017U",
            "ailsa_ii",
            "qcom"
        )
    }
}

data class Device(
    val ANDROID_VERSION: String,
    val ANDROID_RELEASE: String,
    val DPI: String,
    val RESOLUTION: String,
    val MANUFACTURER: String,
    val MODEL: String,
    val NAME: String,
    val CPU: String
)