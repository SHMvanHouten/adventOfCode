package com.github.shmvanhouten.adventofcode.day13

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class PathFinderTest {
    @Test
    fun `it should find the quickest path to 2 2 starting from 1 1`() {
        val pathFinder = PathFinder()
        val maze = listOf(listOf(1, 1, 0),
                listOf(0, 1, 0),
                listOf(0, 1, 1))
        drawMaze(maze)
        val pathsToVisitedNodes = pathFinder.getPathsToVisitedNodes(maze)
        val nodeAtx2y2 = pathsToVisitedNodes.find { it.coordinate == Coordinate(2, 2) }
        assertThat(nodeAtx2y2?.shortestPath?.size, equalTo(2))
    }

    @Test
    fun `it should find the quickest path to 2 3`() {
        val pathFinder = PathFinder()
        val maze = listOf(
                listOf(1, 1, 0, 1),
                listOf(0, 1, 1, 0),
                listOf(0, 0, 1, 0),
                listOf(0, 1, 1, 0))
        drawMaze(maze)
        val pathsToVisitedNodes = pathFinder.getPathsToVisitedNodes(maze)
        val nodeAtx2y2 = pathsToVisitedNodes.find { it.coordinate == Coordinate(1, 3) }
        assertThat(nodeAtx2y2?.shortestPath?.size, equalTo(4))
    }

    @Test
    fun `the amount of nodes it gives back should be 10`() {
        val pathFinder = PathFinder()
        val maze = listOf(
                listOf(1, 1, 0, 1),
                listOf(1, 1, 1, 0),
                listOf(1, 0, 1, 0),
                listOf(1, 1, 1, 0))
        drawMaze(maze)
        val pathsToVisitedNodes = pathFinder.getPathsToVisitedNodes(maze)

        assertThat(pathsToVisitedNodes.size, equalTo(10))
    }

}

fun drawMaze(maze: List<List<Int>>) {
    maze
            .map { line -> line.map { if (it == 0) '#' else '.' } }
            .forEach { println(it.joinToString("")) }
}

