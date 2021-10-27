package com.clintonsoares.mvvm.demoapp.api

import com.clintonsoares.mvvm.demoapp.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}