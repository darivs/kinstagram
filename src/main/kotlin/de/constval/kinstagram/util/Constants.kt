package de.constval.kinstagram.util

class Constants {
    companion object {
        const val BASE_URL = "https://i.instagram.com/api/v1/"
        const val SIG_KEY = "f372b2a5f14d1bebedaaa4ac6f8d506db30ffdd6185b8e0cdfa7dab42f5a9cc6"
        const val SIG_KEY_VERSION = "4"
        const val HEX_CHARS = "0123456789ABCDEF"
        const val APP_VERSION = "22.0.0.15.68"
        const val LOCALE = "de_DE"

        val SAMSUNG_GALAXY_S7_EDGE = Device(
            "23", "6.0.1", "640dpi", "1440x2560", "samsung", "SM-G935F", "hero2lte", "samsungexynos8890"
        )
        val SAMSUNG_GALAXY_S7 = Device(
            "23", "6.0.1", "640dpi", "1440x2560", "samsung", "SM-G930F", "herolte", "samsungexynos8890"
        )
        val ONEPLUS_3T = Device(
            "24", "7.0", "380dpi", "1080x1920", "OnePlus", "ONEPLUS A3010", "OnePlus3T", "qcom"
        )
        val LG_G5 = Device(
            "24", "6.0.1", "640dpi", "1440x2392", "LGE/lge", "RS988", "h1", "h1"
        )
        val HUAWAI_MATE_9_PRO = Device(
            "24", "7.0", "640dpi", "1440x2460", "HUAWEI", "LON-L29", "HWLON", "hi3660"
        )
        val ZTE_AXON_7 = Device(
            "23", "6.0.1", "640dpi", "1440x2560", "ZTE", "ZTE A2017U", "ailsa_ii", "qcom"
        )

        var device = SAMSUNG_GALAXY_S7_EDGE
        val USER_AGENT = "Instagram $APP_VERSION Android (${device.ANDROID_VERSION}/" +
                "${device.ANDROID_RELEASE}; ${device.DPI}; ${device.RESOLUTION}; ${device.MANUFACTURER}; " +
                "${device.MODEL}; ${device.NAME}; ${device.CPU}; $LOCALE)"
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
}