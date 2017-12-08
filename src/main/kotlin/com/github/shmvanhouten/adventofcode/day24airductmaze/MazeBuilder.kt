package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.github.shmvanhouten.adventofcode.day13.MazeComponent
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate

class MazeBuilder {
    private val coordinatesOfRelevantLocations = mutableMapOf<Int, Coordinate>()

    fun buildMazeFromRawInput(rawInput: String): AirDuctMaze {

        val grid = rawInput
                .split("\n")
                .mapIndexed { index, line -> convertLineToRowOfMazeComponents(line, index) }
                .flatMap { it.entries }
                .associateBy ({ it.key }, { it.value } )

        return AirDuctMaze(grid, coordinatesOfRelevantLocations)
    }

    private fun convertLineToRowOfMazeComponents(line: String, yCoordinate: Int): Map<Coordinate, MazeComponent> {
        return line.mapIndexed { index, char ->
            var numberedCorridor: Int? = null
            val currentCoordinate = Coordinate(index, yCoordinate)
            val mazeComponent = when(char){
                '#' -> MazeComponent.WALL
                '.' -> MazeComponent.CORRIDOR
                else -> {
                    coordinatesOfRelevantLocations.put(char.intValue(), currentCoordinate)
                    MazeComponent.CORRIDOR
                }
            }
            currentCoordinate to mazeComponent
        }.toMap()
    }
}

private fun Char.intValue(): Int = this.toInt() - 48