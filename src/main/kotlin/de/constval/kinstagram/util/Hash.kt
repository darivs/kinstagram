package de.constval.kinstagram.util

import de.constval.kinstagram.util.Constants.Companion.HEX_CHARS
import java.security.MessageDigest
import java.util.*

fun generateUuid(): String {
    return UUID.randomUUID().toString()
}

fun generateDeviceId(username: String, password: String): String {
    val hash = digest("MD5", username + password)
    val volatileSeed = "12345"

    return "android-" + digest("MD5", hash + volatileSeed).substring(0, 16)
}

fun digest(type: String, input: String): String {
    return MessageDigest
        .getInstance(type)
        .digest(input.toByteArray())
        .hex()
}

fun ByteArray.hex(): String {
    val result = StringBuilder(this.size * 2)

    this.map {
        result.append(HEX_CHARS[it.toInt() shr 4 and 0x0f])
        result.append(HEX_CHARS[it.toInt() and 0x0f])
    }

    return result.toString()
}
