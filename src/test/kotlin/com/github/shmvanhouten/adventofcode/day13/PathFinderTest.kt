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
        assertThat(pathFinder.findQuickestPathLength(maze, Coordinate(2,3)), equalTo(4))
    }

    private fun drawMaze(maze: List<List<Int>>) {
        maze
                .map { line -> line.map { if (it == 0) '#' else '.' } }
                .forEach { println(it.joinToString("")) }
    }

}