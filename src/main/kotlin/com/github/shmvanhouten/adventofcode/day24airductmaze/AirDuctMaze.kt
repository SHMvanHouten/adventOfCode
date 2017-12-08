package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.github.shmvanhouten.adventofcode.day13.MazeComponent
import com.github.shmvanhouten.adventofcode.day13.MazeComponent.CORRIDOR
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate
import com.github.shmvanhouten.adventofcode.day22gridcomputing.RelativePosition

class AirDuctMaze(val grid: Map<Coordinate, MazeComponent>, val coordinatesOfRelevantLocations: Map<Int, Coordinate>){

    fun getAdjacentNodes(coordinate: Coordinate): Collection<Coordinate> {
       return RelativePosition.values()
               .map { coordinate + it.coordinate }
               .filter { grid.getValue(it) == CORRIDOR }
    }
}
