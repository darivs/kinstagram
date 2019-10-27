package de.constval.kinstagram.api

import de.constval.kinstagram.api.payload.LoginPayload
import de.constval.kinstagram.api.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Service {

    @POST("accounts/login/")
    fun login(@Body data: LoginPayload): Call<LoginResponse>

}
