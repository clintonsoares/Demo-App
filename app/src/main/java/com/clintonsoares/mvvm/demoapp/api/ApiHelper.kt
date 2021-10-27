package com.clintonsoares.mvvm.demoapp.api

import com.clintonsoares.mvvm.demoapp.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}