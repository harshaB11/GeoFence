package com.vuedata.assettracking.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.amazonaws.regions.Regions
import com.amazonaws.services.geo.AmazonLocationClient
import com.amazonaws.services.geo.model.BatchGetDevicePositionRequest
import com.amazonaws.services.geo.model.ListGeofencesRequest
import com.google.android.material.snackbar.Snackbar
import com.google.gson.JsonParser
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.PolygonOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.module.http.HttpRequestUtil
import com.mapbox.mapboxsdk.plugins.annotation.Symbol
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions
import com.mapbox.mapboxsdk.utils.BitmapUtils
import com.vuedata.assettracking.R
import com.vuedata.assettracking.databinding.ActivityTrackSingleDeviceBinding
import com.vuedata.assettracking.okhttp.SigV4Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.Executors

private const val SERVICE_NAME = "geo"

class TrackSingleDeviceActivity : AppCompatActivity(),
    ActivityCompat.OnRequestPermissionsResultCallback,
    OnMapReadyCallback,
    MapboxMap.OnMapClickListener {
    companion object {
        private const val MARKER_TRACKER = "MARKER_"
        private const val MARKER_SELECTED_TRACKER = "MARKER_SELECTED_"
    }

    private var symbolManager: SymbolManager? = null
    private var lastSymbol: Symbol? = null
    private var mapboxMap: MapboxMap? = null
    var deviceid:String?=null
    lateinit var binding: ActivityTrackSingleDeviceBinding
    val mainHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // configuration
        val identityPoolId = getString(R.string.identityPoolId)
        val region = getString(R.string.awsRegion)
        val mapName = getString(R.string.mapName)

        // Initialize the Amazon Cognito credentials provider
        val credentialsProvider = CognitoCachingCredentialsProvider(
            applicationContext,
            identityPoolId,  // Identity pool ID
            Regions.US_EAST_1 // Region
        )
        // initialize MapLibre
        Mapbox.getInstance(this)
        HttpRequestUtil.setOkHttpClient(
            OkHttpClient.Builder()
                .addInterceptor(SigV4Interceptor(credentialsProvider, SERVICE_NAME))
                .build()
        )
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_track_single_device)

        try{
            deviceid=intent.getStringExtra("DeviceId")
        }catch (e:Exception){}
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)


    }

    fun trackDevice() {
        val list = listOf<String>(deviceid!!)

        AWSMobileClient.getInstance().initialize(applicationContext, object :
            Callback<UserStateDetails> {
            override fun onResult(userStateDetails: UserStateDetails) {

                val executorService = Executors.newFixedThreadPool(4)
                executorService.execute {
                    val client = AmazonLocationClient(AWSMobileClient.getInstance())
                    val request = BatchGetDevicePositionRequest()

                    request.trackerName = getString(R.string.awstracker)
                    request.setDeviceIds(list)
                    val response = client.batchGetDevicePosition(request)
                    Log.i("Device Position: ", response.toString())


                    var thread =
                        Thread { //what is meant by the inside code of this run(), how is this updating the UI
                            ThreadUtils.runOnUiThread {
                                symbolManager!!.deleteAll()
                                for (list in response.devicePositions) {
                                    insertTrackerIconOnMap(
                                        LatLng(
                                            list.position.get(1),
                                            list.position.get(0)
                                        ),
                                        "Device ID: " + list.deviceId,
                                        R.drawable.mapbox_marker_icon_default,
                                        "Time : " + list.receivedTime
                                    )
                                    mapboxMap?.cameraPosition = CameraPosition.Builder()
                                        .target(
                                            LatLng(
                                                response.devicePositions.get(0).position.get(1),
                                                response.devicePositions.get(0).position.get(0)
                                            )
                                        )
                                        .zoom(18.0)
                                        .build()


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

    override fun onMapReady(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap

        mapboxMap.setStyle(
            Style.Builder()
                .fromUri(
                    "https://maps.geo.${getString(R.string.awsRegion)}.amazonaws.com/maps/v0/maps/${
                        getString(
                            R.string.mapName
                        )
                    }/style-descriptor"
                )
        ) { style ->

            // Map fully loaded in this scope.
            // Update attributions position
            mapboxMap.uiSettings.setAttributionMargins(15, 0, 0, 15)
            //location tracker
            val selectedMarkerIcontraker =
                ResourcesCompat.getDrawable(
                    this.resources,
                    R.drawable.mapbox_marker_icon_default,
                    null
                )
            style.addImage(
                MARKER_TRACKER,
                BitmapUtils.getBitmapFromDrawable(selectedMarkerIcontraker)!!
            )
            val selectedMarkerIcontrakerDrawable =
                ResourcesCompat.getDrawable(
                    this.resources,
                    R.drawable.mapbox_marker_icon_default,
                    null
                )
            style.addImage(
                MARKER_SELECTED_TRACKER,
                BitmapUtils.getBitmapFromDrawable(selectedMarkerIcontrakerDrawable)!!
            )

            // Initialize SymbolManager.
            this.symbolManager = SymbolManager(binding.mapView, mapboxMap, style)
            this.symbolManager?.iconAllowOverlap = true
            this.symbolManager?.iconIgnorePlacement = true


            // Add a listener to trigger markers clicks.
            this.symbolManager?.addClickListener {
                // Put all marker information into the layout.
                binding.titleView.text = it.data?.asJsonObject?.get("title")?.asString
                binding.descriptionView.text = it.data?.asJsonObject?.get("description")?.asString
                binding.descriptionLayout.background =
                    getDrawable(it.data?.asJsonObject?.get("imageId")?.asInt!!)
                binding.descriptionLayout.background.alpha = 30
                var str = StringBuilder().append(it.data?.asJsonObject?.get("title")?.asString)
                    .append(", \n")
                    .append(it.data?.asJsonObject?.get("description")?.asString).append(", ")
                // Set the new marker as selected and toggle layout.
                setSelectedIconTracker(it)

                Snackbar.make(binding.mainLayout, str, Snackbar.LENGTH_LONG).also {
                    it.show()
                }
                true
            }


            AWSMobileClient.getInstance().initialize(applicationContext, object :
                Callback<UserStateDetails> {
                override fun onResult(userStateDetails: UserStateDetails) {

                    val executorService = Executors.newFixedThreadPool(4)
                    executorService.execute {
                        val client = AmazonLocationClient(AWSMobileClient.getInstance())
                        val request = ListGeofencesRequest()

                        request.collectionName = getString(R.string.awsgeofence)
                        val response = client.listGeofences(request)
                        Log.i("Listcollection: ", response.toString())


                        var thread =
                            Thread { //what is meant by the inside code of this run(), how is this updating the UI
                                ThreadUtils.runOnUiThread {
                                    for (geometrys in response.entries) {
                                        val options = PolygonOptions()
                                        for (list in geometrys.geometry.polygon) {
                                            for (position in list) {
                                                options.add(LatLng(position.get(1), position.get(0)))
                                            }
                                        }
                                        options.fillColor(Color.parseColor("#fcc203")) // 50% opacity red, for example
                                        mapboxMap!!.addPolygon(options)
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

            trackDevice()

            mainHandler.post(object : Runnable {
                override fun run() {
                    trackDevice()
                    mainHandler.postDelayed(this, 60000)
                }
            })


        }
    }

    private fun insertTrackerIconOnMap(
        point: LatLng,
        title: String,
        imageId: Int,
        description: String
    ) {
        // Convert datas of the marker into Json object.
        val jsonData = """
            {
                "title" : "$title",
                "imageId" : "$imageId",
                "description" : "$description"
            }
        """
        // Add symbol at specified lat/lon.
        val newSymbol = symbolManager!!.create(
            SymbolOptions()
                .withLatLng(LatLng(point.latitude, point.longitude))
                .withData(JsonParser.parseString(jsonData))
                .withIconImage("$imageId")
        )

        setTrackerIcon(newSymbol)
    }

    private fun setTrackerIcon(symbol: Symbol) {
        symbol.iconImage = MARKER_TRACKER
        symbol.iconSize = 0.90f
        symbolManager?.update(symbol)
    }

    private fun setSelectedIconTracker(symbol: Symbol) {
        symbol.iconImage = MARKER_SELECTED_TRACKER
        symbol.iconSize = 1.70f
        symbolManager?.update(symbol)

        if (this.lastSymbol != null) {
            setTrackerIcon(this.lastSymbol!!)
        }
        this.lastSymbol = symbol
    }

    override fun onMapClick(point: LatLng): Boolean {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()

    }
}