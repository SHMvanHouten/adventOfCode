package com.github.shmvanhouten.adventofcode.day13

class PathFinder {
    fun findQuickestPathLength(maze: List<List<Int>>, targetCoordinate: Coordinate): Int {
        val mazeWidth = maze.size
        val mazeLength = maze[0].size
        val unvisitedCoordinates = mutableSetOf<Coordinate>()

        for (x in 0.until(mazeWidth)) {
            for (y in 0.until(mazeLength)) {
                unvisitedCoordinates.add(Coordinate(x, y))
            }
        }


    }
}
