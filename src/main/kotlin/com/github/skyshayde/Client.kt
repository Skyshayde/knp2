package com.github.skyshayde

import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.github.skyshayde.models.*


class Client {
    val authKey :String?
    var headers = mapOf("Cookie" to "auth=")

    constructor(authKey: String) {
        this.authKey = authKey
        this.headers = mapOf("Cookie" to "auth="+this.authKey)
    }

    constructor(username: String, password: String) {
        var params = listOf("alias" to username, "password" to password, "type" to "login")

        var data = "https://np.ironhelmet.com/arequest/login".httpPost(params).responseString()
        var cookies = data.second.headers.get("Set-Cookie").toString()
        this.authKey = cookieToMap(cookies).get("auth")
        this.headers = mapOf("Cookie" to "auth="+this.authKey)
    }

    fun makeUniverseRequest(gamenumber: String) {
        var params = listOf("game_number" to gamenumber, "order" to "full_universe_report", "type" to "order", "version" to "7")
        var data = "https://np.ironhelmet.com/trequest/order".httpPost(params).header(headers).responseString()
//        var obj = data.responseObject(moshiDeserializerOf<Universe>())
        System.out.println()

    }

    fun cookieToMap(cookie: String): Map<String, String> {
        return(cookie.replace("[","").replace("]","").split(";").map { i -> i.split("=").zipWithNext().first()}).toMap()
    }


}