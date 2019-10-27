package de.constval.kinstagram

import de.constval.kinstagram.api.Api
import de.constval.kinstagram.api.response.LoginResponse
import retrofit2.Response

class Client(
    private val api: Api = Api()
) {
    fun login(username: String, password: String): Response<LoginResponse> {
        val response = api.login(username, password)

        return response
    }
}