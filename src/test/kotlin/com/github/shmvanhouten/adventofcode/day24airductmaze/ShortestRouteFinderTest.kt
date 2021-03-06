package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ShortestRouteFinderTest {

    @Test
    fun `it should find the shortest route from 0 to 1 to be 2 steps`() {
        val routeFinder = ShortestRouteFinder()
        val rawInput = """###########
#0.1......#
#.#######.#
#.........#
###########"""
        assertThat(routeFinder.findShortestRoute(rawInput), equalTo(2))
    }

    @Test
    fun `it should find the shortest route from 0 to 1 to be 5 steps`() {
        val routeFinder = ShortestRouteFinder()
        val rawInput = """###########
#0........#
#.#######.#
#...1.....#
###########"""
        assertThat(routeFinder.findShortestRoute(rawInput), equalTo(5))
    }


    @Test
    fun `it should find the shortest route from 0 to 1 to 2 to be 6 steps`() {
        val routeFinder = ShortestRouteFinder()
        val rawInput = """###########
#0........#
#.#######.#
#...12....#
###########"""
        assertThat(routeFinder.findShortestRoute(rawInput), equalTo(6))
    }

    @Test
    fun `it should find the shortest route from the testInput to be 14 steps`() {
        val routeFinder = ShortestRouteFinder()
        val rawInput = """###########
#0.1.....2#
#.#######.#
#4.......3#
###########"""
        assertThat(routeFinder.findShortestRoute(rawInput), equalTo(14))
    }


    @Test
    fun `it should solve the challenge input`() {
        val routeFinder = ShortestRouteFinder()

        assertThat(routeFinder.findShortestRoute(day24ChallengeInputMaze), equalTo(490))
    }


    @Test
    fun `it should find the shortest route from 0 to 1 back to 0 to be 10 steps`() {
        val routeFinder = ShortestRouteFinder()
        val rawInput = """###########
#0........#
#.#######.#
#...1.....#
###########"""
        assertThat(routeFinder.findShortestRouteReturningToZeroAfter(rawInput), equalTo(10))
    }


    @Test
    fun `it should solve the challenge input for part 2`() {
        val routeFinder = ShortestRouteFinder()

        assertThat(routeFinder.findShortestRouteReturningToZeroAfter(day24ChallengeInputMaze), equalTo(744))
    }

}

val day24ChallengeInputMaze = """###################################################################################################################################################################################
#.........#...#.............#...#3#.#.....#...........#.........#.#...#.......#.#.#...#...#.................#...........#.#...#.#.......#.......#.......#...#...#.....#.....#.....#
#.#.#.#.#.#.#########.#.#.###.#.#.#.###.###.#.###.#.#.#.###.#.###.#.#.#.#.#####.#.#.#.#.#.#.###.#.#.#.#.#.#.#.###.#.#.###.#.#.#.#####.#.#.#.###.#.#.#.#.#.###.#.###.###.###.###.#.#
#...#...#...#.......#...#.#.#.....#...#.....#.........#.......#.#...#...#.#.............#...#.......#.#.#...#.#.....#.......#...#.....#...#...........#...#...#.#...............#2#
#.###.#.#.#####.###.###.#.#.#.#.###.#.#.#####.#######.#.###.###.#.#.#.#.#.#####.###.###.#.#.#####.#.###.#.###.#.#.#.#.#.#######.#######.#.#.###.###.###.#.#.#.#.#.#.###.#.###.#.###
#.......#.........#.#.#...#...#...#.....#.#.............#.....#...#.......#.#.....#...#...#.......#.............................#.#...#...#...#.....#...#.......#.......#.......#.#
#.###.#.#.#########.#.#.#.#.#.#.#.#.#.#.#.#.#.#.###.#.#.#####.#.#.#######.#.#.#.#.#.#.#####.#.###.#.#####.#.###.###.#.#.###.###.#.#.#.#####.#.###.#.#.#.#######.###.#.#.#.###.###.#
#...#.#...#...#...#...#.#...#.....#...#...........#.....#.........#.#...#...#...#.#...#.......#...#.#.....#.#.....#...#.#.......#.#.#.......#.......#...........#.#.#...#.#.......#
#.#.#.###.###.#.#.#######.#.#.#.#.#.#.###.###########.#.#.#####.###.#.#.#####.#.#.#.#####.###.#.###.#####.###.#####.#########.#.###.#.###.#.#.#.#.###.###.#.#####.#.#.#.#.#.###.#.#
#.......#.......#...........#...#.#...#.............#.#.#...#...#.....#...#...#.#...#...#.......#.#.#.#...#.....#.#.#.........#...#...#.....#.#...........#.#.......#.#.#...#...#.#
#.#.#.###.#####.#.#####.#.###.#.#.#.###.#.#.#.###.###.#.#####.###.#####.#.#.#####.#.#.#.#######.#.###.#.###.#####.#.#####.#.#.#####.#.#.#.#.###.#.#######.#.#.#.###########.#.#.#.#
#.#.#.....#.#1..........#.#...#...#.....#.........#...............#.#...#.....#...#.......#...........#.#...#.#.....#.............#.............#.....#...#.....#...#.....#.#.....#
#.#.###.#.#.#####.#.#.#.###.#####.#.#.#.###.###.#.#.#.#####.#.#.###.#.#.#####.#.#.#.#.#.#.###.#.###.#.#.#.#.#.#.###.#.#.#####.###.###.###.#.#.#.###.#.#.#.#.#.###.#.#.#####.#####.#
#...#...#.#...#.#.#.#.#.......#.....................#.#...............#.......#.#...#.#.#.....#.#.#...#...#.#.......#.....#.#...#.........#.#.#...#.........#.............#.....#.#
#.###.###.###.#.#.###.#.#####.#.#####.###.###########.###.#.#.#####.#.#.#.###.###.#.#.#.#.###.#.#.#.#.###.#.###.#.#########.#.#.#.#.###.#.#.#.#.#.#.#.#.#.###.###.#####.#.#####.###
#.....#.#.......#.#.#.....#...#.......#...#.#...#.............#.#.#.....#.........#...#.#.........#.#.#.#...#.#...#...#.......#.....#.#.....#.#.#.......#.#...#.#.....#.......#...#
#.#.###.#.#######.#.#.#.###.#.###.###.#####.#.#.#.#.###.###.###.#.#.#####.#.#####.#.#.#.#.#.#########.#.#.#.#.#.#.#.#.#.###.#.###.#.#.###.###.#.#######.#.#.#.#.#.###.#.#.#.#.###.#
#.#.#.......#...#...#.#.#.#.....#.....#...#...#.....#...#...#...#...........#...........#.........#.#.....#.....#.......#...#...#...#.#...#.#.#.........#...#.....#.#...#.#.....#.#
#.#.#.#####.#.#.#.###.###.#.#.#####.#.###.#.#.#####.#.#####.#.#.#.#####.###.#.#.#.#.###.#.#.#.#.#.#.#.###.#.#####.###.###.#.#.#.#.#.#.#.#.#.###.###.#.#######.#####.###.#.###.###.#
#.#.......#.#...#.#...#.#.#.......#...#.....#.........#.....#.#.....#...#...#.#.#...#.....#...#...#...#.....#.......#.#.#...#.#.........#...#.#..4#.#.#.#.#.....#.....#.........#.#
#.###.#.#.#.###.#.#.###.#.#######.#.#.###.#.###.#.#.#.#.#.#.###.#####.#.###.#######.#####.###.#.#.#.#.#.###.#.#####.#.#.#.#.#.#.#.#.#.#.#.#.#.#######.#.#.#.#.#.#.#.#.#.#.###.#.#.#
#0#...#.#.#.....#...#...#.#...#...#...#...#.......#.#.#.....#...#...#...#...#...#...#.........#.......#...#.......#...#...#...#.......#...#...............#.....#...#...#...#.#...#
###.#.#.###.###########.#.#####.###.###.###.###.###.#.###.#.#.#.#.#.#.#.#.#.#.###.#.###.#.#.#.#####.#.#.#.#.#.#.#.#.#.#.#.###.#####.#.#####.#.#.#.#####.#.#.#####.#####.#.#.#.#.###
#...#.#...#.......#...#...........#...#.....#...#...#.#.........#.....#.#...#.......#.....#.#.#.........#.........#...#.#.#...#.#.....#.....................#...............#.....#
###.#.#.#.#.#.###.#.#.#.#.#######.#.#.###.###.#.#.#####.###.###.###.###.#.#.#.#.#######.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.###.#.#####.###.#######.###.###.#.###.###.###.###.#.#.#
#...#.............#.#...........#.#.#.....#.....#.......#.#.....#...#.........#.....#.......#.....#...#.....#...#.......#...#...#.#.........#...#...........#.......#...#.......#.#
###.#.#########.#.#.#####.#.#.#.#.#.#.###.#.#######.#.#.#.#.#.#####.#.#.#.#####.#.#.#.#####.#######.#.#.#.#.#.#####.#.#.#.#####.#.#.###.#######.#######.#.#.###.#.#.#.#.#.#.###.#.#
#.#...............#.#.......#.....#.................#...#.#.#.......#...#.......#.#.#...#.#.......#...#.....#.....#...#.#.......#.#.#.....#.....#.....#.#...#.#...#...#.#...#.#.#.#
#.#.#.###.#.#.#.#.#.#.#.#.#.#########.#.#.#.#.#.#.#.#.#.#.#.###.#.#.#.###.#.#.#.#.#.###.#.#.###.#.#.###.###.#.#.#####.#####.#####.#.#.#.#.#.#.###.#.#.#.###.#.#.#.#.###.#.#.#.#####
#...#.#.....#...#.............#.#.#.#.........#.#...#.#.....#.......#...#.#.#.....#.......#...#...#...........#.....#.#.......#...#...#.#.........#...#...#.....#.......#...#.....#
###.#.#.#.#.#.#.###.#.###.#.###.#.#.#.#.###.#.###.#.#.#####.###.###.#.#.#.###.#.#.###.###.###.#.#.#.#.###.#####.###.#####.#.#.###.###.#####.#####.#.#.#######.###.###.###.#.#.#.#.#
#...#.#.....#.........#.......#.#...#.......#...#...#...........#.....#.......#...........#.......#...#...#.....#.....#...#.......#.#.#...#.#.....#.........#.....#...#.#...#.#...#
###.###.###.###.#.#####.###.#.#.#.#.#.###.###.###.###.#.#####.#.#.#.#.###.#.#.###.#.###.###.#.#.###.###.#.#.#.#.#.#.#.#.#.#.#.#.###.#.###.#.###.#.#.#####.#.#####.#.#.#.#####.#.#.#
#.#.#...#.#.#...................#.......#.#.#.#.#.....#.#.#.....#...#.......#.#...#.......#.....#...#.....#...#...#.#...#...#.........#...#...#...........#.........#.#..5#...#...#
#.#.#.###.#.###.#####.#.#.###.#.#####.#.#.#.#.#.#.###.#.#.#.#######.###.#.#.#.#.#.###.#.#.#.###.#.#####.#.#.#.#####.#.###.#.#.###.###.#.###.#.#.###########.#.#######.#.#.#.###.###
#...#.#.#...#.#.................#.#.....#.#.........#.....#.#.#...#.#.........#...#.#...#.#.........#...#...#.....#.#.#.#.....#...#.#.....#.#.............#.#...#.#.#.....#...#...#
#.#.###.#.#.#.#.#.#.#.#.###.###.#.#.#######.#######.###.#.#.#.###.#.#.#####.###.###.#####.#.#####.#.#.#.#.#.#.###.#.#.#.#.###.#.#.#.#.#.#.#.#####.#.#.#.#.###.#.#.#.#.#####.###.#.#
#...#.....#.....#.....#.#...#...#...............#...#...#...#.....#...#.#.....#.#.#...#...#.#...#...#.....#...#...#...................#.........#...#.........#.#...#.......#...#.#
###.#.###.#.#.#.###.#.#.#.#.#.###.###.#.###.###.#.###.#.#######.#.#.#.#.#.#####.#.#.#.#.#.###.#.#.#.#####.#.#.###.#.#######.#######.###.#######.#.#.#.#.###.###.###.#.#.#.#.#.#.#.#
#.....#7..#.#.#...........#.#...#.........#.....#.#.#...#.....#.............#...#...#...#.#.#...#.......#...#.....#.#.......#.#.....#...#...#...#...#...#...#.#.....#.#.......#.#.#
#.#.#.#.#.#.#.#.#.#.###.#####.#.#############.#.###.#.#.#.#.###.###.#######.#.#.###.#.###.#.###.#######.###.###.#.#.###.#.#.#.#.#.###.###.###.#.#.###.#.#.#.#.#.#.###.#.###.#.#.###
#...#.....#.#...#.#.....#.....#...#...#.......#6#.......#.#.......#.#.........#...#.#.....#.....#.#.......#.#.......#.......#.....#.....#.....#...#.#.#.#...#.#...#.#...#...#.#.#.#
###################################################################################################################################################################################"""