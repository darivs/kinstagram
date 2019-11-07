package de.constval.kinstagram.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import de.constval.kinstagram.util.Constants.Companion.HEX_CHARS
import de.constval.kinstagram.util.Constants.Companion.SIG_KEY
import de.constval.kinstagram.util.Constants.Companion.SIG_KEY_VERSION
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

private val mapper = jacksonObjectMapper()

fun generateUuid(): String = UUID.randomUUID().toString()

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

fun Any.generateSignature(): String {
    val objectAsJson = mapper.writeValueAsString(this)

    val parsed = URLEncoder.encode(objectAsJson, StandardCharsets.UTF_8)
    val signedBody = hmacSHA256(objectAsJson)

    return "ig_sig_key_version=$SIG_KEY_VERSION&signed_body=$signedBody.$parsed"
}

fun hmacSHA256(payload: String): String? {
    val algorithm = "HmacSHA256"

    return Mac
        .getInstance(algorithm)
        .run {
            init(SecretKeySpec(SIG_KEY.toByteArray(), algorithm))
            doFinal(payload.toByteArray(StandardCharsets.UTF_8))
        }.hex()
}
