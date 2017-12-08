package com.github.shmvanhouten.adventofcode.day13

import com.github.shmvanhouten.adventofcode.day13.MazeComponent.*
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate

class Maze(val height: Int = 50, val width: Int = 50) {

    private var mazeGrid: Map<Int, Map<Int, MazeComponent>> = initializeMap()

    private fun initializeMap(): Map<Int, Map<Int, MazeComponent>> {
        val row = 0.until(width).associateBy({ it }, { CORRIDOR })
        return 0.until(height).associateBy({it}, {row})
    }

    fun buildWall(x: Int, y: Int) {
        if(mazeGrid.containsKey(y)) {
            val row = mazeGrid.getValue(y)
            if (row.containsKey(x)){
                val newRow = row.minus(x).plus(x to WALL)
                mazeGrid = mazeGrid.minus(y).plus(y to newRow)
            }else {
                println("x: $x not found")
            }
        } else {
            println("y: $y not found")
        }

    }

    fun getComponent(x: Int, y: Int): MazeComponent {
        if(mazeGrid.containsKey(y)){
            val row = mazeGrid.getValue(y)
            if (row.containsKey(x)){
                return row.getValue(x)
            }
        }
        return WALL
    }

    fun getComponent(coordinate: Coordinate): MazeComponent {
        if(mazeGrid.containsKey(coordinate.y)){
            val row = mazeGrid.getValue(coordinate.y)
            if (row.containsKey(coordinate.x)){
                return row.getValue(coordinate.x)
            }
        }
        return WALL
    }

    fun getAdjacentCorridors(originCoordinate: Coordinate): List<Coordinate> {
        val x = originCoordinate.x
        val y = originCoordinate.y
        val possibleAdjacent = listOf(
                Coordinate(x - 1, y),
                Coordinate(x + 1, y),
                Coordinate(x, y - 1),
                Coordinate(x, y + 1))
        return possibleAdjacent
                .filter { this.getComponent(it) == CORRIDOR }
    }

}

fun buildMazeFromMazeRepresentation(mazeRepresentation: List<String>): Maze {
    val maze = Maze(mazeRepresentation.size, mazeRepresentation[0].length)
    mazeRepresentation.forEachIndexed { y, row -> row.forEachIndexed{ x, char -> if (char == '#') maze.buildWall(x,y)} }
    return maze
}

enum class MazeComponent {
    WALL,
    CORRIDOR
}