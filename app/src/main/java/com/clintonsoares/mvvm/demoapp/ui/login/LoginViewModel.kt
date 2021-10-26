package com.clintonsoares.mvvm.demoapp.ui.login

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clintonsoares.mvvm.demoapp.model.LoginUser

class LoginViewModel : ViewModel() {
    var emailAddress: MutableLiveData<String> = MutableLiveData("")
    var password: MutableLiveData<String> = MutableLiveData("")
    private var userMutableLiveData: MutableLiveData<LoginUser> = MutableLiveData()

    fun getUser(): MutableLiveData<LoginUser> {
        return userMutableLiveData
    }

    fun onLoginClicked() {
        val emailAddr: String? = emailAddress.getValue()
        val pass: String? = password.getValue()
        val loginUser = LoginUser(emailAddr, pass)
        userMutableLiveData.value = loginUser
    }

    fun isEmailValid(emailAddress: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()
    }

    fun isPasswordLengthGreaterThan5(passwrd: String): Boolean {
        return passwrd.length > 5
    }
}