package com.github.shmvanhouten.adventofcode.day13

import com.github.shmvanhouten.adventofcode.day13.MazeComponent.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class MazeTest {

    @Test
    fun `it should abstract the mazeRepresentation into a maze`() {
        val mazeRepresentation = listOf(
                "..#.",
                "...#",
                ".#.#",
                "...#"
        )
        val maze = buildMazeFromMazeRepresentation(mazeRepresentation)
        maze.draw()
        assertThat(maze.getCoordinate(2,0), equalTo(WALL))
        assertThat(maze.getCoordinate(1,1), equalTo(CORRIDOR))
    }

    @Test
    fun `draw maze`() {
        val mazeRepresentation = listOf(
                "....",
                "....",
                "...#",
                "...#"
        )
        val maze = buildMazeFromMazeRepresentation(mazeRepresentation)
        maze.draw()
    }
}