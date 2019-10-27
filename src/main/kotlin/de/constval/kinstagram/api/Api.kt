package de.constval.kinstagram.api

import de.constval.kinstagram.api.payload.LoginPayload
import de.constval.kinstagram.api.response.LoginResponse
import de.constval.kinstagram.util.Constants.Companion.BASE_URL
import de.constval.kinstagram.util.Constants.Companion.USER_AGENT
import de.constval.kinstagram.util.generateDeviceId
import de.constval.kinstagram.util.generateUuid
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


class Api {
    private val service: Service

    init {
        val jacksonConverterFactory = JacksonConverterFactory.create()

        val client = OkHttpClient
            .Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        service = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(jacksonConverterFactory)
            .build()
            .create(Service::class.java)
    }

    fun login(
        username: String,
        password: String,
        guid: String = generateUuid(),
        phoneId: String = generateUuid()
    ): Response<LoginResponse> {
        return service.login(
            LoginPayload(
                username = username,
                password = password,
                guid = guid,
                phone_id = phoneId,
                device_id = generateDeviceId(username, password)
            )
        ).execute()
    }

    class HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response = chain.run {
            proceed(
                request().newBuilder()
                    .addHeader("User-Agent", USER_AGENT)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addHeader("Accept-Language", "en-US")
                    .build()
            )
        }
    }
}
