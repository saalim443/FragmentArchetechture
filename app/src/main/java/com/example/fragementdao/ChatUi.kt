package com.example.fragementdao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fragementdao.databinding.FragmentChatUiBinding
import com.example.fragementdao.databinding.HomeBinding



class ChatUi : Fragment(R.layout.fragment_chat_ui) {

    private lateinit var binding: FragmentChatUiBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatUiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gotoNext.setOnClickListener {

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
