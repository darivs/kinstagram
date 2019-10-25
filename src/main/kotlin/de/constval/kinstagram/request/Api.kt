package de.constval.kinstagram.request

import de.constval.kinstagram.util.Constants.Companion.BASE_URL
import de.constval.kinstagram.util.Constants.Companion.USER_AGENT
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

class Api {
    private val client = OkHttpClient()

    fun post(url: String, data: RequestBody): Response {
        val request = Request.Builder()
            .instagramHeaders()
            .url(BASE_URL + url)
            .post(data)
            .build()

        return client.newCall(request).execute()
    }

    private fun Request.Builder.instagramHeaders(): Request.Builder {
        return this
            .addHeader("User-Agent", USER_AGENT)
            .addHeader("Connection", "close")
            .addHeader("Accept", "*/*")
            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
            .addHeader("Cookie2", "\$Version=1")
            .addHeader("Accept-Language", "en-US")
    }
}