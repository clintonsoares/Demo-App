package com.clintonsoares.mvvm.demoapp.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var email: String = ""
    var pass: String = ""

    fun onHomeActivityOpened(emailAddress: String, password: String) {
        email = emailAddress
        pass = password
    }
}