// UserUi.kt
package com.example.fragementdao.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fragementdao.R
import com.example.fragementdao.UserViewModel
import com.example.fragementdao.databinding.FragmentUserUiBinding
import com.example.fragementdao.util.ToolbarUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserUi : Fragment(R.layout.fragment_user_ui) {

    private lateinit var binding: FragmentUserUiBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserUiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.fetchAllUsers()

        viewLifecycleOwner.lifecycleScope.launch {
            userViewModel.users.collect { userList ->
                // Update UI with user list
                binding.userListTextView.text = userList.joinToString("\n") { user ->
                    "Email: ${user.email}, Password: ${user.password}"
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Hide the notification ImageView using utility class
        ToolbarUtils.hideNotificationIcon(requireActivity())
        ToolbarUtils.hidetextlable(requireActivity())
        ToolbarUtils.hideSidebarIcon(requireActivity())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}
