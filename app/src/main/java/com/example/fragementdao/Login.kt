// Login.kt
package com.example.fragementdao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragementdao.databinding.LoginBinding

class Login : Fragment(R.layout.login) {

    private var _binding: LoginBinding? = null
    private val binding get() = _binding!!

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
            findNavController().navigate(
                R.id.action_login_to_register,
                //bundleOf("user" to user.email)
            )
        }
    }
    override fun onResume() {
        super.onResume()
        // Hide the notification ImageView using utility class
        ToolbarUtils.hideNotificationIcon(requireActivity())
        ToolbarUtils.hidetextlable(requireActivity())
        ToolbarUtils.hideSidebarIcon(requireActivity())
    }

    override fun onPause() {
        super.onPause()
        // Show the notification ImageView using utility class
        ToolbarUtils.showNotificationIcon(requireActivity())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
