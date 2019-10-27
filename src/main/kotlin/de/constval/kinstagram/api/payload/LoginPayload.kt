package de.constval.kinstagram.api.payload

import de.constval.kinstagram.util.generateDeviceId
import de.constval.kinstagram.util.generateUuid

data class LoginPayload(
    val phone_id: String,
    val device_id: String,
    val guid: String,
    val username: String,
    val password: String
) {
    constructor(username: String, password: String) : this(
        phone_id = generateUuid(),
        device_id = generateDeviceId(username, password),
        guid = generateUuid(),
        username = username,
        password = password
    )
}
