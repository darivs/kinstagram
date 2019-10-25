package de.constval.kinstagram

import de.constval.kinstagram.request.Api
import okhttp3.FormBody
import okhttp3.RequestBody

class Client(
    private val username: String,
    private val password: String
) {
    private val api = Api()

    fun login(): String? {
        val requestBody: RequestBody = FormBody.Builder()
            .add("phone_id", "#####")
            .add("device_id", "#####")
            .add("guid", "#####")
            .add("username", username)
            .add("password", password)
            .build()

        val response = api.post(url = "accounts/login/", data = requestBody)

        return response.body?.string()
    }
}