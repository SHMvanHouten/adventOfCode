package com.github.shmvanhouten.adventofcode.day18likearogue

import com.github.shmvanhouten.adventofcode.day18likearogue.TrapState.*

class TileFloorBuilder(private val rowTranslator: RowFromRawInputTranslator = RowFromRawInputTranslator()) {
    fun buildFloorFromFirstRow(firstRowRawInput: String, amountOfRows: Int): TileFloor {
        val firstRow = rowTranslator.translateRawInput(firstRowRawInput)
        var rows = listOf(firstRow)
        for (index in 1.until(amountOfRows)) {
            rows += buildRowFromPreviousRow(rows.last())
        }

        return TileFloor(rows)
    }

    private fun buildRowFromPreviousRow(lastRow: TileRow): TileRow {
        var newRow = listOf<Tile>()
        for (index in 0.until(lastRow.size)) {
            newRow += Tile(getNewTileTrapState(index, lastRow))
        }
        return TileRow(newRow)
    }

    private fun getNewTileTrapState(index: Int, lastRow: TileRow): TrapState {
        val leftTile = if (index > 0) lastRow.tiles[index - 1].trapState else SAFE
        val rightTile = if (index < lastRow.tiles.lastIndex) lastRow.tiles[index + 1].trapState else SAFE
        val tilesAboveNewTile = Triple(leftTile, lastRow.tiles[index].trapState, rightTile)
        return when (tilesAboveNewTile) {
            Triple(TRAP, TRAP, SAFE),
            Triple(SAFE, TRAP, TRAP),
            Triple(TRAP, SAFE, SAFE),
            Triple(SAFE, SAFE, TRAP) -> TRAP
            else -> SAFE
        }
    }
}