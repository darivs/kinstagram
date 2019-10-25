package de.constval.kinstagram

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test

internal class ClientTest {
    private val mapper = jacksonObjectMapper()

    @Test
    fun that_login_fails_with_wrong_password() {
        val client = Client("bar", "foo")

        val response = client.login()
        val body = mapper.readValue(response, Map::class.java)

        assert(body["error_type"] == "bad_password")
    }
}