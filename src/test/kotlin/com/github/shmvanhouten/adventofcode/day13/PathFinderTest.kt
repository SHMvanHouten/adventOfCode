package com.github.shmvanhouten.adventofcode.day13

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class PathFinderTest{
    @Test
    fun `it should find the quickest path to 2 2 starting from 1 1`() {
        val pathFinder = PathFinder()
        val maze = listOf(listOf(1,1,0),
                          listOf(0,1,0),
                          listOf(0,1,1))
        drawMaze(maze)
        assertThat(pathFinder.findQuickestPathLength(maze, Coordinate(2,2)), equalTo(2))
    }

    @Test
    fun `it should find the quickest path to 2 3`() {
        val pathFinder = PathFinder()
        val maze = listOf(listOf(1,1,0,1),
                          listOf(0,1,1,0),
                          listOf(0,0,1,0),
                          listOf(0,1,1,0))
        drawMaze(maze)
        assertThat(pathFinder.findQuickestPathLength(maze, Coordinate(1,3)), equalTo(4))
    }

    @Test
    fun `it should find the shortest path to 31,39 for the challenge maze`() {
        val pathFinder = PathFinder()
        val mazeBuilder = MazeBuilder()
        val maze = mazeBuilder.build(1352)

        assertThat(pathFinder.findQuickestPathLength(maze, Coordinate(31,39)), equalTo(90))
    }

    @Test
    fun `it should find all the points in the maze that take 50 or less steps to reach`() {
        val pathFinder = PathFinder()
        val mazeBuilder = MazeBuilder()
        val maze = mazeBuilder.build(1352)

//        assertThat()
    }

    private fun drawMaze(maze: List<List<Int>>) {
        maze
                .map { line -> line.map { if (it == 0) '#' else '.' } }
                .forEach { println(it.joinToString("")) }
    }

}