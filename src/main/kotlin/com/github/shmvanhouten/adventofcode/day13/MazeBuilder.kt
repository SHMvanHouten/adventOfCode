package com.github.shmvanhouten.adventofcode.day13

class MazeBuilder {

    fun build(inputNumber: Int): List<List<Int>> {
        val range = 0..50
        val coordinates = mutableListOf<MutableList<Int>>()
        for (x in range) {
            coordinates.add(mutableListOf())
            for (y in range) {
                coordinates[x].add(isCoordinateOpenSpaceOrWall(x, y, inputNumber).toInt())
            }
        }
        return coordinates
    }

    private fun isCoordinateOpenSpaceOrWall(x: Int, y: Int, inputNumber: Int): Boolean {
        val  decimalRepresentation = x * x + 3 * x + 2 * x * y + y + y * y + inputNumber
        val binaryRepresentation = decimalRepresentation.toBinary()
        val amountOf1sInBinary = binaryRepresentation.count { it == '1' }
        return amountOf1sInBinary % 2 == 0
    }
}

private fun Boolean.toInt(): Int = if(this) 1 else 0


private fun Int.toBinary(): String {
    val binaryBuilder = StringBuilder()
    var remaining = this
    while (remaining >0){
        binaryBuilder.append(remaining % 2)
        remaining /= 2
    }
    return binaryBuilder.reversed().toString()
}

