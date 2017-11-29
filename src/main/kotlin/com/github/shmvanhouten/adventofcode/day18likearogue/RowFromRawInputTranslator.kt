package com.github.shmvanhouten.adventofcode.day18likearogue

class RowFromRawInputTranslator {
    fun translateRawInput(rawInput: String): TileRow=
        TileRow(rawInput.map { Tile(getTrapStateFromCharRepresentation(it)) })
}