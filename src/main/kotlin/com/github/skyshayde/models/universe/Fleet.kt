package com.github.skyshayde.models.universe

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Fleet(
        val uid: Int,
        @Json(name = "ouid") val star_id: Int? = null,
        @Json(name = "st") val ships: Int,
        @Json(name = "n") val name: String,
        @Json(name = "l") val looping: Int,
        @Json(name = "o") val orders: List<FleetOrder>,
        @Json(name = "puid") val player_id: Int,
        val x: Float,
        val y: Float,
        val last_x: Float? = null,
        val last_y: Float? = null
)

@JsonClass(generateAdapter = true)
data class FleetOrder(
        @Json(name = "n") val delay: Int,
        val star_id: Int,
        val action: OrderAction,
        val ships: Int
) {
    constructor(list: List<Int>) : this(list[0], list[1], OrderAction.values()[2], list[3])
}

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