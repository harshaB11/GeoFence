package com.vuedata.assettracking.firebase

import com.google.gson.annotations.SerializedName


data class NotificationData (

  @SerializedName("version"     ) var version     : String?      = "",
  @SerializedName("id"          ) var id          : String?      = "",
  @SerializedName("detail-type" ) var detail_type : String?      = "",
  @SerializedName("source"      ) var source      : String?      = "",
  @SerializedName("account"     ) var account     : String?      = "",
  @SerializedName("time"        ) var time        : String?      = "",
  @SerializedName("region"      ) var region      : String?      = "",
  @SerializedName("resources"   ) var resources   : List<String> = arrayListOf(),
  @SerializedName("detail"      ) var detail      : Detail?      = Detail()

)