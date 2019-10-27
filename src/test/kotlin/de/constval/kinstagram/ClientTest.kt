package de.constval.kinstagram

import org.junit.jupiter.api.Test

class ClientTest {
    @Test
    fun that_login_with_invalid_credentials_throws_400() {
        val client = Client()

        val response = client.login(username = "", password = "")

        assert(response.code() == 400)
    }
}