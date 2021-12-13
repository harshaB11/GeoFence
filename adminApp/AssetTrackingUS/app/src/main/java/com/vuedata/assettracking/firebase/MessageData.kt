package com.vuedata.assettracking.firebase

data class MessageData(
    @JvmField
    var body: String? = null,
    var notify_id: String? = null,
    @JvmField
    var title: String? = null,
    var type: String? = null
)