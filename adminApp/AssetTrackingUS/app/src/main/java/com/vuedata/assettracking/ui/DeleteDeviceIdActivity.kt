package com.vuedata.assettracking.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.amazonaws.services.geo.AmazonLocationClient
import com.amazonaws.services.geo.model.BatchDeleteDevicePositionHistoryRequest
import com.amazonaws.services.geo.model.ListDevicePositionsRequest
import com.amazonaws.services.geo.model.ListDevicePositionsResponseEntry
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.vuedata.assettracking.R
import com.vuedata.assettracking.adepter.DeviceListAdepter
import com.vuedata.assettracking.databinding.ActivityDeleteDeviceIdBinding
import com.vuedata.assettracking.databinding.ActivityRegistrationBinding
import java.util.concurrent.Executors

class DeleteDeviceIdActivity : AppCompatActivity() {
    lateinit var binding: ActivityDeleteDeviceIdBinding
    lateinit var adepter: DeviceListAdepter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=
            DataBindingUtil.setContentView(this, R.layout.activity_delete_device_id)

        getAllTrackerDevice()

    }

    fun getAllTrackerDevice(){
        AWSMobileClient.getInstance().initialize(applicationContext, object :
            Callback<UserStateDetails> {
            override fun onResult(userStateDetails: UserStateDetails) {

                val executorService = Executors.newFixedThreadPool(4)
                executorService.execute {
                    val client = AmazonLocationClient(AWSMobileClient.getInstance())
                    val request = ListDevicePositionsRequest()

                    request.trackerName = getString(R.string.awstracker)
                    val response = client.listDevicePositions(request)
                    Log.i("ListDevicePosition: ", response.toString())
                     val listofDevices=response.entries
                    // this creates a vertical layout Manager
                    adepter= DeviceListAdepter(applicationContext,
                        listofDevices as ArrayList<ListDevicePositionsResponseEntry>,
                        { item,position->adapterOnClick(item,position)},
                        { item,position->onClickOpenMap(item,position)}
                    )
                    var thread =
                        Thread { //what is meant by the inside code of this run(), how is this updating the UI
                            ThreadUtils.runOnUiThread {
                                binding.recyclerview.setLayoutManager(
                                    LinearLayoutManager(
                                        applicationContext,
                                        RecyclerView.VERTICAL,
                                        false
                                    )
                                )

                                binding.recyclerview.adapter = adepter
                            }
                        }
                    thread.start()
                }
            }

            override fun onError(error: Exception) {
                Log.e("QuickStart", "Initialization error: ", error)
            }
        })
    }

    private fun onClickOpenMap(item:ListDevicePositionsResponseEntry,position:Int) {
        val intent = Intent(applicationContext, TrackSingleDeviceActivity::class.java)
        // start your next activity
        intent.putExtra("DeviceId",item.deviceId)
        startActivity(intent)
    }

    private fun adapterOnClick(item:ListDevicePositionsResponseEntry,position:Int) {
        val list = listOf<String>(item.deviceId)
        AWSMobileClient.getInstance().initialize(applicationContext, object :
            Callback<UserStateDetails> {
            override fun onResult(userStateDetails: UserStateDetails) {

                val executorService = Executors.newFixedThreadPool(2)
                executorService.execute {
                    val client = AmazonLocationClient(AWSMobileClient.getInstance())
                    val request = BatchDeleteDevicePositionHistoryRequest()

                    request.trackerName = getString(R.string.awstracker)
                    request.setDeviceIds(list)
                    val response = client.batchDeleteDevicePositionHistory(request)
                    Log.i("batchDeleteDevice: ", response.toString())
                    var thread =
                        Thread { //what is meant by the inside code of this run(), how is this updating the UI
                            ThreadUtils.runOnUiThread {
                                if(adepter!=null) {
                                    adepter.mList.removeAt(position)
                                    adepter.notifyDataSetChanged()
                                }
                            }
                        }
                    thread.start()
                }
            }

            override fun onError(error: Exception) {
                Log.e("QuickStart", "Initialization error: ", error)
            }
        })
    }
}