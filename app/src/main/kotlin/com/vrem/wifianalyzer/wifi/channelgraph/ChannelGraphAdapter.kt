/*
 * WiFiAnalyzer
 * Copyright (C) 2015 - 2023 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.vrem.wifianalyzer.wifi.channelgraph

import com.vrem.annotation.OpenClass
import com.vrem.wifianalyzer.wifi.band.WiFiBand
import com.vrem.wifianalyzer.wifi.graphutils.GraphAdapter
import com.vrem.wifianalyzer.wifi.model.WiFiData

private fun channelGraphViews(): List<ChannelGraphView> =
    WiFiBand.values().flatMap { wiFiBand ->
        wiFiBand.wiFiChannels.wiFiChannelPairs().map { ChannelGraphView(wiFiBand, it) }
    }

@OpenClass
class ChannelGraphAdapter(private val channelGraphNavigation: ChannelGraphNavigation) : GraphAdapter(channelGraphViews()) {
    override fun update(wiFiData: WiFiData) {
        super.update(wiFiData)
        channelGraphNavigation.update()
    }
}

