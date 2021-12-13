package com.vuedata.assettracking.firebase

import com.google.gson.annotations.SerializedName


data class Detail (

  @SerializedName("EventType"  ) var EventType  : String?      = null,
  @SerializedName("GeofenceId" ) var GeofenceId : String?      = null,
  @SerializedName("DeviceId"   ) var DeviceId   : String?      = null,
  @SerializedName("SampleTime" ) var SampleTime : String?      = null,
  @SerializedName("Position"   ) var Position   : List<Double> = arrayListOf()

)