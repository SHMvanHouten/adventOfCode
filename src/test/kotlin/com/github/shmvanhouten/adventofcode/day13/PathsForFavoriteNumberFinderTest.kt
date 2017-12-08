package com.github.shmvanhouten.adventofcode.day13

import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.assertion.assertThat
import org.junit.Test
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate

class PathsForFavoriteNumberFinderTest {

    @Test
    fun `it should find the shortest path to 31,39 for the challenge maze`() {
        val pathsFinder = PathsForFavoriteNumberFinder()

        val quickestPath = pathsFinder.findQuickestPathForCoordinate(1352, Coordinate(31, 39))

        assertThat(quickestPath?.size, equalTo(90))

        val mazeBuilder = MazeBuilder()
        val maze = mazeBuilder.build(1352)
        maze.draw(quickestPath!!)
    }



    @Test
    fun `it should find all the points in the maze that take 50 or less steps to reach`() {
        val pathsFinder = PathsForFavoriteNumberFinder()

        val amountOfSteps = pathsFinder.countHowManyCoordinatesTakeLessThan50Steps(1352)
        assertThat(amountOfSteps, equalTo(135))
    }
}