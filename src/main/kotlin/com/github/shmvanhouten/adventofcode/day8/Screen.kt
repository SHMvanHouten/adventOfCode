package com.github.shmvanhouten.adventofcode.day8

class Screen(width: Int, height: Int, private val grid: MutableList<MutableList<Boolean>> = MutableList(width) { MutableList(height) { false } }) {

    fun turnOnPixelsTopLeft(width: Int, height: Int) {
        val xRange = 0.until(width)
        val yRange = 0.until(height)

        for (x in xRange) {
            for (y in yRange) {
                grid[x][y] = true
            }
        }
    }

    fun rotateRowByAmount(row: Int, amount: Int) {

        val oldRow = grid.map { it[row] }

        grid.forEachIndexed { index, column -> column[row] = oldRow[calculateIndex(index - amount, oldRow.size)] }

    }

    fun rotateColumnByAmount(column: Int, amount: Int) {

        val oldColumn = grid[column].map { it }
        val columnToRotate = grid[column]

        grid[column].forEachIndexed { index, _ -> columnToRotate[index] = oldColumn[calculateIndex(index - amount, oldColumn.size)] }

    }

    fun getPixel(x: Int, y: Int): Boolean = grid[x][y]

    fun amountOfPixelsLit(): Int = grid.sumBy { it.count { it } }

    fun display() {
        for (index in 0..grid[0].lastIndex) {
            println(grid.map { it[index] }.joinToString("") { if (it) "X" else " " })
        }
    }

    private fun calculateIndex(oldRowIndex: Int, size: Int): Int {
        return if (oldRowIndex >= 0) oldRowIndex
        else oldRowIndex + size
    }
}