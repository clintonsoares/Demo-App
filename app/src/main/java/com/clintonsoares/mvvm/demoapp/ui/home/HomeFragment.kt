package com.clintonsoares.mvvm.demoapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.clintonsoares.mvvm.demoapp.R
import com.clintonsoares.mvvm.demoapp.databinding.FragmentHomeBinding
import com.clintonsoares.mvvm.demoapp.ui.userlist.UserListActivity

class HomeFragment : Fragment() {
    private var homeViewModel: HomeViewModel? = null
    private lateinit var binding: FragmentHomeBinding
    private val safeArgs: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.btnToUserList.setOnClickListener {
            goToUserListActivity()
        }
    }

    private fun initView() {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.vm = homeViewModel

        val emailId = safeArgs.email
        val password = safeArgs.password
        homeViewModel!!.onHomeActivityOpened(emailId, password)
    }

    private fun goToUserListActivity() {
        val intent = Intent(activity,UserListActivity::class.java)
        startActivity(intent)
    }
}