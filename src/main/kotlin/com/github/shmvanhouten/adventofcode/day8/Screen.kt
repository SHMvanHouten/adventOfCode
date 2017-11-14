package com.github.shmvanhouten.adventofcode.day8

class Screen(width: Int, height: Int, private val grid: Array<Array<Boolean>> = Array(width) { Array(height) { false } }) {

    fun getPixel(x: Int, y: Int): Boolean = grid[x][y]

    fun flipPixel(x: Int, y: Int) {
        grid[x][y] = grid[x][y].not()
    }

    fun turnOnPixelsTopLeft(width: Int, height: Int) {
        val yRange = 0.until(height)
        val xRange = 0.until(width)
        for (x in xRange) {
            for (y in yRange) {
                grid[x][y] = true
            }
        }
    }

    fun amountOfPixelsLit(): Int = grid.sumBy { it.count { it } }

    fun rotateRowByAmount(row: Int, amount: Int) {

        val oldRow = grid.map { it[row] }

        grid.forEachIndexed { index, column -> column[row] = oldRow[getOldRowIndex(index - amount, oldRow.size)] }

//        for (xIndex in 0.until(grid.size)) {
//
//            var indexMovedFrom = xIndex - amount
//            if(indexMovedFrom < 0){
//                indexMovedFrom += oldRow.size
//            }
//            grid[xIndex][row] = oldRow[indexMovedFrom]
//
//        }
    }

    private fun getOldRowIndex(oldRowIndex: Int, size: Int): Int {
        return if(oldRowIndex >= 0) oldRowIndex
        else oldRowIndex + size
    }
}