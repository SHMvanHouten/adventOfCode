package com.github.shmvanhouten.adventofcode.day18likearogue

import com.github.shmvanhouten.adventofcode.day18likearogue.TrapState.*

class SafeTileCounter(val tileFloorBuilder: TileFloorBuilder = TileFloorBuilder()) {
    fun countForRawInput(firstRow: String, amountOfRows: Int): Int {
        val tileFloor = tileFloorBuilder.buildFloorFromFirstRow(firstRow, amountOfRows)
        return tileFloor.countTilesWithState(SAFE)
    }
}