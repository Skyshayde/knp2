package com.github.skyshayde

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.github.skyshayde.models.universe.Order
import com.github.skyshayde.models.universe.Universe
import com.github.skyshayde.models.adapters.FleetAdapter
import com.github.skyshayde.models.message.MessageReport
import com.github.skyshayde.models.message.Messages
import com.github.skyshayde.models.message.UnreadReport
import com.squareup.moshi.Moshi

class Game(val gamenumber: String, val client: Client) {

    var headers = mapOf("Cookie" to "auth="+client.authKey)
    var url = "https://np.ironhelmet.com/trequest/"
    fun makeTRequest(type: String, params: List<Pair<String, String>> = emptyList()): Result<String, FuelError> {
        var endpoint = url + type
        return endpoint.httpPost(params).header(headers).responseString().third
    }

    fun universe(): Universe? {
        var params = listOf("game_number" to this.gamenumber, "order" to "full_universe_report", "type" to "order", "version" to "")
        var tRequest = makeTRequest("order", params)
        return Moshi.Builder().add(FleetAdapter()).build().adapter(Order::class.java).fromJson(tRequest.get())?.report
    }

    fun unreadCount(): Map<String, Int>? {
        var params = listOf("game_number" to this.gamenumber, "type" to "fetch_unread_count", "version" to "")
        var tRequest = makeTRequest("fetch_unread_count", params)
        return Moshi.Builder().build().adapter(UnreadReport::class.java).fromJson(tRequest.get())?.report
    }

    fun messages(count: Int): Messages? {
        var params = listOf("game_number" to this.gamenumber, "type" to "fetch_game_messages",
                "version" to "", "group" to "game_diplomacy", "count" to count.toString(), "offset" to "0")
        var tRequest = makeTRequest("fetch_unread_count", params)
        return Moshi.Builder().build().adapter(MessageReport::class.java).fromJson(tRequest.get())?.report
    }

}