package com.skytech.data

import com.skytech.model.AuthResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface ApiService {
    @POST("auth")
    fun auth(@Body auth: RequestBody?): Call<AuthResponse>

    @POST("logout")
    suspend fun logout(@HeaderMap headers: Map<String, String>)

}
