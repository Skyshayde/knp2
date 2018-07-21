package com.github.skyshayde.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Order (
        val event: String,
        val report: Universe
)