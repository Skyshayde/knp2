package com.github.skyshayde.models.universe

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Order (
        val event: String,
        val report: Universe
)