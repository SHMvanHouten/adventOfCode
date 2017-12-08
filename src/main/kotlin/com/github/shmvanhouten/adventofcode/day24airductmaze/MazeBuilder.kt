package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.github.shmvanhouten.adventofcode.day13.MazeComponent
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate

class MazeBuilder {
    fun buildMazeFromRawInput(rawInput: String): AirDuctMaze {

        val grid = rawInput
                .split("\n")
                .mapIndexed { index, line -> convertLineToRowOfMazeComponents(line, index) }
                .flatMap { it.entries }
                .associateBy ({ it.key }, { it.value } )

        return AirDuctMaze(grid)
    }

    private fun convertLineToRowOfMazeComponents(line: String, yCoordinate: Int): Map<Coordinate, MazePart> {
        return line.mapIndexed { index, char ->
            var numberedCorridor: Int? = null
            val mazeComponent = when(char){
                '#' -> MazeComponent.WALL
                '.' -> MazeComponent.CORRIDOR
                else -> {
                    numberedCorridor = char.intValue()
                    MazeComponent.CORRIDOR
                }
            }
            Coordinate(index, yCoordinate) to MazePart(mazeComponent, numberedCorridor)
        }.toMap()
    }
}

private fun Char.intValue(): Int = this.toInt() - 48