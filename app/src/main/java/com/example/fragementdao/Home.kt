package com.example.fragementdao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragementdao.databinding.HomeBinding

class Home : Fragment(R.layout.home) {

    private lateinit var binding: HomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gotoNext.setOnClickListener {
            findNavController().navigate(
                R.id.action_home2_to_login,
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
