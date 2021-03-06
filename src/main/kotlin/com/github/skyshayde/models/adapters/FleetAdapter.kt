package com.github.skyshayde.models.adapters

import com.github.skyshayde.models.universe.FleetOrder
import com.squareup.moshi.FromJson

class FleetAdapter {

    @FromJson fun fleetOrderFromJson(list: List<List<Int>>) : List<FleetOrder> {
        var orders = mutableListOf<FleetOrder>()
        list.forEach {i -> orders.add(FleetOrder(i))}
        return orders
    }

}