package de.constval.kinstagram.api.payload

data class LoginPayload(
    val phone_id: String,
    val device_id: String,
    val guid: String,
    val username: String,
    val password: String
)