package com.github.skyshayde.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Player(
        val uid: Int,
        val ai: Int,
        @Json(name = "total_economy") val economy: Int,
        @Json(name = "total_industry") val industry: Int,
        @Json(name = "total_science") val science: Int,
        val huid: Int,
        @Json(name = "total_stars") val totalStars: Int,
        @Json(name = "total_fleets") val totalFleets: Int,
        @Json(name = "total_strength") val totalShips: Int,
        @Json(name = "alias") val name: String,
//        val tech: Research,
        val avatar: Int,
        val conceded: Int,
        val ready: Int,
        val missed_turns: Int,
        val karma_to_give: Int
)