package com.github.shmvanhouten.adventofcode.day18likearogue

import com.github.shmvanhouten.adventofcode.day18likearogue.TrapState.*

data class Tile(val trapState: TrapState)


data class TileRow(val tiles: List<Tile>) {
    val size: Int = tiles.size
}


data class TileFloor(val rows: List<TileRow>) {
    fun countTilesWithState(trapState: TrapState): Int {
        return rows.sumBy { it.tiles.count { tile -> tile.trapState == trapState } }
    }
}


enum class TrapState(val charRepresentation: Char) {
    TRAP('^'),
    SAFE('.')
}

fun getTrapStateFromCharRepresentation(char: Char): TrapState {
    return when (char) {
        TRAP.charRepresentation -> TRAP
        else -> SAFE
    }
}