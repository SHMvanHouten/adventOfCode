package com.github.shmvanhouten.adventofcode.day13

class MazeBuilder {

    fun build(inputNumber: Int, sizeOfMazeSides: IntRange = 0..50): List<List<Int>> {
        val coordinates = mutableListOf<MutableList<Int>>()
        for (y in sizeOfMazeSides) {
            coordinates.add(mutableListOf())
            for (x in sizeOfMazeSides) {
                coordinates[y].add(isCoordinateOpenSpaceOrWall(x, y, inputNumber).toInt())
            }
        }
        return coordinates
    }

    private fun isCoordinateOpenSpaceOrWall(x: Int, y: Int, inputNumber: Int): Boolean {
        val decimalRepresentation = x * x + 3 * x + 2 * x * y + y + y * y + inputNumber
        val binaryRepresentation = decimalRepresentation.toBinary()
        val amountOf1sInBinary = binaryRepresentation.count { it == '1' }
        return amountOf1sInBinary % 2 == 0
    }
}

private fun Boolean.toInt(): Int = if (this) 1 else 0


private fun Int.toBinary(): String {
    val binaryBuilder = StringBuilder()
    var remaining = this
    while (remaining > 0) {
        binaryBuilder.append(remaining % 2)
        remaining /= 2
    }
    return binaryBuilder.reversed().toString()
}

