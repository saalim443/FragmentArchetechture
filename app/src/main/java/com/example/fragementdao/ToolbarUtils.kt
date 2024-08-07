package com.example.fragementdao


import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

object ToolbarUtils {

    fun hideNotificationIcon(activity: Activity) {
        val notiImageView = activity.findViewById<ImageView>(R.id.iconNoti)
        notiImageView?.visibility = View.GONE
    }
    fun hideSidebarIcon(activity: Activity) {
        val notiImageView = activity.findViewById<ImageView>(R.id.iconsidebar)
        notiImageView?.visibility = View.GONE
    }

    fun hidetextlable(activity: Activity) {
        val notiImageView = activity.findViewById<TextView>(R.id.tvLable)
        notiImageView?.visibility = View.GONE
    }

    fun showNotificationIcon(activity: Activity) {
        val notiImageView = activity.findViewById<ImageView>(R.id.iconNoti)
        notiImageView?.visibility = View.VISIBLE
    }

    fun showSidebarIcon(activity: Activity) {
        val notiImageView = activity.findViewById<ImageView>(R.id.iconsidebar)
        notiImageView?.visibility = View.VISIBLE
    }
    fun showtextlable(activity: Activity) {
        val notiImageView = activity.findViewById<TextView>(R.id.tvLable)
        notiImageView?.visibility = View.VISIBLE
    }



}
