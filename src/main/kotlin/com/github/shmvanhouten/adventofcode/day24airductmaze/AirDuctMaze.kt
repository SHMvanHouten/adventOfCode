package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.github.shmvanhouten.adventofcode.day13.MazeComponent
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate

class AirDuctMaze(val grid: Map<Coordinate, MazePart>) {
}

data class MazePart(val mazeComponent: MazeComponent, val number: Int?)