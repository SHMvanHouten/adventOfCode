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
        assertThat(maze.getComponent(2,0), equalTo(WALL))
        assertThat(maze.getComponent(1,1), equalTo(CORRIDOR))
    }

    @Test
    fun `it should give the adjacent corridors for 1,1`() {
        val mazeRepresentation = listOf(
                ".#..",
                "..#.",
                "...#",
                "...#"
        )

        val maze = buildMazeFromMazeRepresentation(mazeRepresentation)
        val adjacentCorridors: List<Coordinate> = maze.getAdjacentCorridors(Coordinate(1,1))
        maze.draw()
        assertThat(adjacentCorridors.size, equalTo(2))
        assertThat(adjacentCorridors[0], equalTo(Coordinate(0,1)))
    }
}