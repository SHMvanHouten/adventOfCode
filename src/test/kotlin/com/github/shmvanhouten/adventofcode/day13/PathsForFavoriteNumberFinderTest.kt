package com.github.shmvanhouten.adventofcode.day13

import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.assertion.assertThat
import org.junit.Test

class PathsForFavoriteNumberFinderTest {

    @Test
    fun `it should find the shortest path to 31,39 for the challenge maze`() {
        val pathsFinder = PathsForFavoriteNumberFinder()

        assertThat(pathsFinder.findQuickestPathLengthForCoordinate(1352, Coordinate(31, 39)), equalTo(90))
    }



    @Test
    fun `it should find all the points in the maze that take 50 or less steps to reach`() {
        val pathsFinder = PathsForFavoriteNumberFinder()

        val amountOfSteps = pathsFinder.countHowManyCoordinatesTakeLessThan50Steps(1352)
        println(amountOfSteps)

    }
}