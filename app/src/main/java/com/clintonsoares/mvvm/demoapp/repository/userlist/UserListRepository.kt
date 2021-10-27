package com.clintonsoares.mvvm.demoapp.repository.userlist

import com.clintonsoares.mvvm.demoapp.api.ApiHelper
import javax.inject.Inject

class UserListRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}