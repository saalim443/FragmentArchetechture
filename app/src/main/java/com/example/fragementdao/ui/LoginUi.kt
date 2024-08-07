// Login.kt
package com.example.fragementdao.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragementdao.R
import com.example.fragementdao.util.ToolbarUtils
import com.example.fragementdao.databinding.LoginBinding


import androidx.fragment.app.viewModels
import com.example.fragementdao.UserViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginUi : Fragment(R.layout.login) {

    private var _binding: LoginBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gotoNext.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            userViewModel.loginUser(email, password) { user ->
                if (user != null) {
                    findNavController().navigate(R.id.action_login_to_userUi)
                } else {
                    // Show error message
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

