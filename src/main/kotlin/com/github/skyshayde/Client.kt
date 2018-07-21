package com.github.skyshayde

import com.github.kittinunf.fuel.httpPost
import com.github.skyshayde.models.*
import com.github.skyshayde.models.adapters.FleetAdapter
import com.squareup.moshi.Moshi


class Client {

    var json = """{"c":"test"}"""
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

    fun game(gamenumber: String) : Game {
        return Game(gamenumber, this)
    }


    fun cookieToMap(cookie: String): Map<String, String> {
        return(cookie.replace("[","").replace("]","").split(";").map { i -> i.split("=").zipWithNext().first()}).toMap()
    }


}