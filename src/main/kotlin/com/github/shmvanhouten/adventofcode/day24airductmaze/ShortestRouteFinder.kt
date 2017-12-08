package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate


class ShortestRouteFinder(private val mazeBuilder: MazeBuilder = MazeBuilder(),
                          private val pathFinder: PathFinder = PathFinder(),
                          private val routeFinder: RouteFinder = RouteFinder()) {

    fun findShortestRoute(rawInput: String): Int? {

        val airDuctMaze = mazeBuilder.buildMazeFromRawInput(rawInput)

        val possibleRoutesAndSizes = getPossibleRoutesAndSizes(airDuctMaze)

        return routeFinder.getFastestRoute(possibleRoutesAndSizes, airDuctMaze.coordinatesOfRelevantLocations.keys)
    }


    private fun getPossibleRoutesAndSizes(airDuctMaze: AirDuctMaze): Map<Route, Int> {
        var handledCoordinatesOfRelevantLocations = airDuctMaze.coordinatesOfRelevantLocations

        return airDuctMaze.coordinatesOfRelevantLocations
                .flatMap { entry ->
                    handledCoordinatesOfRelevantLocations -= entry.key
                    handledCoordinatesOfRelevantLocations.map { buildRoute(entry, it) to pathFinder.getShortestRouteFromPointToPoint(entry.value, it.value, airDuctMaze) }
                }
                .toMap()
    }

    private fun buildRoute(startPoint: Map.Entry<Int, Coordinate>, endPoint: Map.Entry<Int, Coordinate>): Route {

        val startPointNumber = startPoint.key
        val endpointNumber = endPoint.key
        return if(endpointNumber > startPointNumber){
            Route(startPointNumber, endpointNumber)
        }else {
            Route(endpointNumber, startPointNumber)
        }
    }


}