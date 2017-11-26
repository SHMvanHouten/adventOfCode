package com.github.shmvanhouten.adventofcode.day13

class PathsForFavoriteNumberFinder(private val mazeBuilder: MazeBuilder = MazeBuilder(), private val pathFinder: PathFinder = PathFinder()) {

    fun findQuickestPathLengthForCoordinate(numberToDrawMaze: Int, targetCoordinate: Coordinate): Int {
        val maze = mazeBuilder.build(numberToDrawMaze)

        val pathsToVisitedNodes = pathFinder.getPathsToVisitedNodes(emptyList())

        return pathsToVisitedNodes.find { it.coordinate == targetCoordinate }?.shortestPath?.size ?: -1
    }

    fun countHowManyCoordinatesTakeLessThan50Steps(numberToDrawMaze: Int): Int {
        val maze = mazeBuilder.build(numberToDrawMaze)

        val pathsToVisitedNodes = pathFinder.getPathsToVisitedNodes(emptyList())

        return pathsToVisitedNodes.count { it.shortestPath.size <= 50 }
    }
}