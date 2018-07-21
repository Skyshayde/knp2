package com.github.skyshayde.models

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class Star(
        val uid: Int,
        @Json(name = "n") val name: String,
        @Json(name = "puid") val player_id: Int? = null,
        @Json(name = "e") val economy: Int? = null,
        @Json(name = "i") val industry: Int? = null,
        @Json(name = "s") val science: Int? = null,
        @Json(name = "st") val ships: Int? = null,
        @Json(name = "nr") val natural_resources: Int? = null,
        @Json(name = "r") val resources: Int? = null,
        @Json(name = "ga") val warp_gate: Int? = null,
        val x: Float? = null,
        val y: Float? = null,
        @Json(name = "v") val visible: Int
)