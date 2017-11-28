package com.github.shmvanhouten.adventofcode.day8

import com.github.shmvanhouten.adventofcode.day8.PixelState.OFF
import com.github.shmvanhouten.adventofcode.day8.PixelState.ON

class Screen(private val width: Int, private val height: Int) {

    private var grid: Map<Int, Map<Int, PixelState>> = initializeGrid()

    private fun initializeGrid(): Map<Int, Map<Int, PixelState>> {
        val row = 0.until(width).associateBy({ it }, { OFF })
        return 0.until(height).associateBy({it}, {row})
    }

    fun turnOnPixelsTopLeft(width: Int, height: Int) {
        val xRange = 0.until(width)
        val yRange = 0.until(height)

        for (y in yRange) {
            if(grid.containsKey(y)) {
                var newRow = grid.getValue(y)
                for (x in xRange) {
                    newRow = newRow.minus(x).plus(x to ON)
                }
                grid = grid.minus(y).plus(y to newRow)
            }

        }
    }

    fun rotateRowByAmount(row: Int, amount: Int) {

        val oldRow = grid.getValue(row)
        val rotatedRow = oldRow.entries.associateBy ({ calculateIndex(it.key + amount, width)}, {it.value })
        grid = grid.minus(row).plus(row to rotatedRow)
    }

    fun rotateColumnByAmount(column: Int, amount: Int) {
        val mutableGrid = grid.toMutableMap()
        val mapOfNewPixelStateAtColumnForEachRow = grid.entries
                .associateBy({ calculateIndex(it.key + amount, height) }, { it.value.getValue(column) })
        mapOfNewPixelStateAtColumnForEachRow.forEach { mutableGrid.put(it.key, mutableGrid.getValue(it.key).minus(column).plus(column to it.value)) }

        grid = mutableGrid
    }

    fun getPixel(x: Int, y: Int): PixelState {
        return grid.getValue(y).getValue(x)
    }

    fun amountOfPixelsLit(): Int = grid.values.sumBy { it.values.count { it == ON } }

    fun display() {
        for (row in grid.toSortedMap().values) {
            println(row.toSortedMap().values.map { if(it == ON) 'X' else ' ' }.joinToString(""))
        }
    }

    private fun calculateIndex(newIndex: Int, size: Int): Int {
        return if (newIndex < size) newIndex
        else newIndex - size
    }
}

enum class PixelState{
    ON,
    OFF
}