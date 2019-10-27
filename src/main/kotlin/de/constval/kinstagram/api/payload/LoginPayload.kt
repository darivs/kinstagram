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
    constructor(username: String, password: String, phone_id: String, guid: String) : this(
        device_id = generateDeviceId(username, password),
        phone_id = phone_id,
        guid = guid,
        username = username,
        password = password
    )

    constructor(username: String, password: String) : this(
        device_id = generateDeviceId(username, password),
        phone_id = generateUuid(),
        guid = generateUuid(),
        username = username,
        password = password
    )
}