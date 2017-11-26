package com.github.shmvanhouten.adventofcode.day13

class PathsForFavoriteNumberFinder(private val mazeBuilder: MazeBuilder = MazeBuilder(), private val pathFinder: PathFinder = PathFinder()) {

    fun findQuickestPathForCoordinate(numberToDrawMaze: Int, targetCoordinate: Coordinate): Set<Coordinate>? {
        val maze = mazeBuilder.build(numberToDrawMaze)

        val pathsToVisitedNodes = pathFinder.getPathsToVisitedNodes(maze)

        return pathsToVisitedNodes.find { it.coordinate == targetCoordinate }?.shortestPath
    }

    fun countHowManyCoordinatesTakeLessThan50Steps(numberToDrawMaze: Int): Int {
        val maze = mazeBuilder.build(numberToDrawMaze)

        val pathsToVisitedNodes = pathFinder.getPathsToVisitedNodes(maze)

        return pathsToVisitedNodes.count { it.shortestPath.size <= 50 }
    }
}