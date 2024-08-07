package com.example.fragementdao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fragementdao.databinding.FragmentChatUiBinding
import com.example.fragementdao.databinding.FragmentUserUiBinding

class UserUi : Fragment(R.layout.fragment_user_ui) {

    private lateinit var binding: FragmentUserUiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserUiBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gotoNext.setOnClickListener {
            findNavController().navigate(
                R.id.action_userUi_to_chatUi,
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
        binding
    }
}