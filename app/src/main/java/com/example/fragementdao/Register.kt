// Home.kt
package com.example.fragementdao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragementdao.databinding.RegisterBinding

class Register : Fragment(R.layout.register) {

    private var _binding: RegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gotoNext.setOnClickListener {
            findNavController().navigate(
                R.id.action_register_to_userUi,
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
