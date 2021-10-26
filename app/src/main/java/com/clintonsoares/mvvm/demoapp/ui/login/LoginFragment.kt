package com.clintonsoares.mvvm.demoapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clintonsoares.mvvm.demoapp.R
import com.clintonsoares.mvvm.demoapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var loginViewModel: LoginViewModel? = null
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.lifecycleOwner = this
        binding.vm = loginViewModel
    }
}