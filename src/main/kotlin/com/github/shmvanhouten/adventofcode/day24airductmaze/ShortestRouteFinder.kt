package com.github.shmvanhouten.adventofcode.day24airductmaze

import com.github.shmvanhouten.adventofcode.day13.Node
import com.github.shmvanhouten.adventofcode.day22gridcomputing.Coordinate


class ShortestRouteFinder(private val mazeBuilder: MazeBuilder = MazeBuilder()) {

    fun findShortestRoute(rawInput: String): Int {

        val airDuctMaze = mazeBuilder.buildMazeFromRawInput(rawInput)

        val startingPoint = airDuctMaze.coordinatesOfRelevantLocations.getValue(0)

        val endPoint = airDuctMaze.coordinatesOfRelevantLocations.getValue(1)

        return getShortestRouteFromPointToPoint(startingPoint, endPoint, airDuctMaze)
    }

    private fun getShortestRouteFromPointToPoint(startingPoint: Coordinate, endPoint: Coordinate, airDuctMaze: AirDuctMaze): Int {

        var unvisitedNodes = setOf(Node(startingPoint))
        var visitedNodes = setOf<Node>()

        while (unvisitedNodes.isNotEmpty()){
            val currentNode = getLowestDistanceNode(unvisitedNodes)
            unvisitedNodes -= currentNode

            if(currentNode.coordinate == endPoint){
                return currentNode.shortestPath.size
            }

            val adjacentNodes = buildAdjacentNodes(currentNode, airDuctMaze)
                    .filter { !visitedNodes.contains(it) }

            unvisitedNodes += adjacentNodes

            if (visitedNodes.contains(currentNode)){
                println("this should not happen")
                // do nothing, visitedNodes will have a shorter or equal path-size node
            } else{
                visitedNodes += currentNode
            }

        }

        return -1
    }

    private fun buildAdjacentNodes(currentNode: Node, airDuctMaze: AirDuctMaze): Set<Node> {
        return airDuctMaze.getAdjacentNodes(currentNode.coordinate)
                .map { Node(it, currentNode.shortestPath.plus(it)) }
                .toSet()
    }

    private fun getLowestDistanceNode(unvisitedNodes: Set<Node>): Node {
        return unvisitedNodes.minBy { it.shortestPath.size } ?: unvisitedNodes.first()
    }
}