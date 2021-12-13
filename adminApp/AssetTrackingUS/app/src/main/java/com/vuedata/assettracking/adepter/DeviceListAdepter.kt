package com.vuedata.assettracking.adepter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.amazonaws.services.geo.AmazonLocationClient
import com.amazonaws.services.geo.model.BatchDeleteDevicePositionHistoryRequest
import com.amazonaws.services.geo.model.ListDevicePositionsRequest
import com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry
import com.vuedata.assettracking.R
import java.util.concurrent.Executors

class DeviceListAdepter (val mcontext:Context,
                         val mList: ArrayList<ListDevicePositionsResponseEntry>,
                         val adapterOnClick : (ListDevicePositionsResponseEntry,Int) -> Unit,
                         val onClickOpenMap : (ListDevicePositionsResponseEntry,Int) -> Unit) : RecyclerView.Adapter<DeviceListAdepter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deviceid_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item:ListDevicePositionsResponseEntry = mList[position]

        holder.deviceName.setText(item.deviceId)
        holder.registeredTime.setText(""+item.sampleTime)
        holder.removeDeviceIcon.setOnClickListener {
            adapterOnClick(item,position)

        }
        holder.mainlayout.setOnClickListener {
            onClickOpenMap(item,position)

        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val deviceName: TextView = itemView.findViewById(R.id.deviceName)
        val registeredTime: TextView = itemView.findViewById(R.id.registeredTime)
        val removeDeviceIcon: ImageView = itemView.findViewById(R.id.removeDeviceIcon)
        val mainlayout = itemView.findViewById(R.id.main_layout) as ConstraintLayout
    }
}