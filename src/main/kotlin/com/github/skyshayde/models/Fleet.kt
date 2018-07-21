package com.github.skyshayde.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Fleet(
        val uid: Int,
        @Json(name = "ouid") val star_id: Int,
        @Json(name = "st") val ships: Int,
        @Json(name = "n") val name: String,
        @Json(name = "l") val looping: Int,
        @Json(name = "o") val orders: List<FleetOrder>,
        @Json(name = "puid") val player_id: Int,
        val x: Float,
        val y: Float,
        val last_x: Float,
        val last_y: Float
)

@JsonClass(generateAdapter = true)
data class FleetOrder(
        @Json(name = "n") val delay: Int,
        val star_id: Int,
        val action: OrderAction,
        val ships: Int
)

enum class OrderAction(action: Int) {
    DoNothing(0),
    CollectAll(1),
    DropAll(2),
    Collect(3),
    Drop(4),
    CollectAllBut(5),
    DropAllBut(6),
    Garrison(7)
}