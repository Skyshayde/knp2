package com.github.skyshayde.models

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class Star(
        val uid: Int,
        @Json(name = "n") val name: String,
        @Json(name = "puid") val player_id: Int,
        @Json(name = "e") val economy: Int,
        @Json(name = "i") val industry: Int,
        @Json(name = "s") val science: Int,
        @Json(name = "st") val ships: Int,
        @Json(name = "nr") val natural_resources: Int,
        @Json(name = "r") val resources: Int,
        @Json(name = "ga") val warp_gate: Int,
        val x: Float,
        val y: Float,
        @Json(name = "v") val visible: Int
)