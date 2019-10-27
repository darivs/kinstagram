package de.constval.kinstagram.util

import de.constval.kinstagram.api.payload.LoginPayload
import org.junit.jupiter.api.Test

class HashTest {

    @Test
    fun that_device_id_gets_generated_correctly() {
        val deviceId = generateDeviceId("USERNAME", "PASSWORD")

        assert(deviceId.equals("android-7eb57ab90e1e2c3e"))
    }

    @Test
    fun that_converting_byte_array_to_hexadecimal_is_correct() {
        val bytes = byteArrayOf(13, 3, 74, 2, 0)

        val hex = bytes.hex()

        assert(hex.equals("0d034a0200"))
    }

    @Test
    fun that_generated_signature_is_correct() {
        val payload = LoginPayload(
            phone_id = "681f1617-9d3b-490d-a635-08f7075a5f66",
            guid = "702bd670-85ce-4a5a-90be-786f5db5162c",
            username = "USERNAME",
            password = "PASSWORD"
        )

        val generatedSignature = payload.generateSignature()

        val correctSignature =
            "ig_sig_key_version=4&signed_body=4f7cd7f03868270a8ccf502f9fced538c607364e0b373e757aa52def90296e60.%7B%22" +
                    "phone_id%22%3A%22${payload.phone_id}%22%2C%22device_id%22%3A%22android-7eb57ab90e1e2c3e%22%2C%22" +
                    "guid%22%3A%22${payload.guid}%22%2C%22username%22%3A%22${payload.username}%22%2C%22password%22%3A" +
                    "%22${payload.password}%22%7D"
        assert(generatedSignature.equals(correctSignature))
    }
}