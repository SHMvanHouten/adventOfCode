package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.github.shmvanhouten.adventofcode.day13.MazeComponent.CORRIDOR
import com.github.shmvanhouten.adventofcode.day13.MazeComponent.WALL
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class MazeBuilderTest {

    @Test
    fun `it should build a maze from the raw input`() {
        val mazeBuilder = MazeBuilder()
        val rawInput = """###########
#0.1.....2#
#.#######.#
#4.......3#
###########"""
        val maze: AirDuctMaze = mazeBuilder.buildMazeFromRawInput(rawInput)

        assertThat(maze.grid.getValue(Coordinate(1,1)), equalTo(CORRIDOR))
        assertThat(maze.grid.getValue(Coordinate(0,0)), equalTo(WALL))
        assertThat(maze.coordinatesOfRelevantLocations.getValue(4), equalTo(Coordinate(1, 3)))
        for (entry in maze.grid) {
            println("${entry.key} is a ${entry.value}")
        }
    }
}