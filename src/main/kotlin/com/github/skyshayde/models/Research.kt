package com.github.skyshayde.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Research(
        val scanning: Pair<Int, Int>,
        val range: Pair<Int, Int>,
        val terraforming: Pair<Int, Int>,
        val experimentation: Pair<Int, Int>,
        val weapons: Pair<Int, Int>,
        val banking: Pair<Int, Int>,
        val manufacturing: Pair<Int, Int>
)