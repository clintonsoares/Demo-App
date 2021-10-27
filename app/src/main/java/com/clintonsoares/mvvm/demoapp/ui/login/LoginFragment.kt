package com.clintonsoares.mvvm.demoapp.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clintonsoares.mvvm.demoapp.R
import com.clintonsoares.mvvm.demoapp.databinding.FragmentLoginBinding
import java.util.*

class LoginFragment : Fragment() {
    private var loginViewModel: LoginViewModel? = null
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        onObservingLoginChanges()
    }

    private fun initView() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.lifecycleOwner = this
        binding.vm = loginViewModel
    }

    private fun onObservingLoginChanges() {
        loginViewModel!!.getUser().observe(
            viewLifecycleOwner,
            { loginUser ->
                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).emailAddress)) {
                    binding.txtEmailAddress.error = "Enter an E-Mail Address"
                    binding.txtEmailAddress.requestFocus()
                } else if (!loginViewModel!!.isEmailValid(loginUser.emailAddress!!)) {
                    binding.txtEmailAddress.error = "Enter a Valid E-mail Address"
                    binding.txtEmailAddress.requestFocus()
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).password)) {
                    binding.txtPassword.error = "Enter a Password"
                    binding.txtPassword.requestFocus()
                } else if (!loginViewModel!!.isPasswordLengthGreaterThan5(loginUser.password!!)) {
                    binding.txtPassword.error = "Enter at least 6 Digit password"
                    binding.txtPassword.requestFocus()
                } else {
                    val loggedInUserData =
                        LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                            email = loginUser.emailAddress,
                            password = loginUser.password
                        )
                    findNavController().navigate(loggedInUserData)
                }
            })
    }
}