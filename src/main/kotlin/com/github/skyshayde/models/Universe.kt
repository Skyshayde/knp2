package com.github.skyshayde.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Universe (
    val fleets: List<Fleet>,
    val paused: Boolean,
    val productions: Int,
    val now: Int,
    val tick_rate: Int,
    val production_rate: Int,
    val stars: List<Star>,
    val stars_for_victory: Int,
    val game_over: Int,
    val started: Boolean,
    val start_time: Int,
    val total_stars: Int,
    val production_counter: Int,
    val trade_scanned: Int,
    val tick: Int,
    val trade_cost: Int,
    val name: String,
    val player_uid: Int,
    val admin: Int,
    val turn_based: Int,
    val war: Int,
    val players: List<Player>,
    val turn_based_time_out: Int
)