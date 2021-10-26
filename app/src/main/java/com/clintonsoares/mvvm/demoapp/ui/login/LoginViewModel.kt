package com.clintonsoares.mvvm.demoapp.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clintonsoares.mvvm.demoapp.model.LoginUser

class LoginViewModel : ViewModel() {
    var emailAddress: MutableLiveData<String> = MutableLiveData("")
    var password: MutableLiveData<String> = MutableLiveData("")
    private var userMutableLiveData: MutableLiveData<LoginUser> = MutableLiveData()

    fun getUser(): MutableLiveData<LoginUser> {
        if (userMutableLiveData == null) {
            userMutableLiveData = MutableLiveData()
        }
        return userMutableLiveData
    }

    fun onLoginClicked() {
        var emailAddr: String? = emailAddress.getValue()
        var pass: String? = password.getValue()
        val loginUser = LoginUser(emailAddr, pass)
        userMutableLiveData.setValue(loginUser)
    }
}