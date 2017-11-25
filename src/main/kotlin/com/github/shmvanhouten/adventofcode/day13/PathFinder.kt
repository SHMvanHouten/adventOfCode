package com.github.shmvanhouten.adventofcode.day13

class PathFinder {
    private val SOURCE_COORDINATE = Coordinate(1, 1)

    fun getPathsToVisitedNodes(maze: List<List<Int>>): Set<Node> {
        var unvisitedNodes = setOf<Node>()
        var visitedNodes = setOf<Node>()

        val sourceNode = Node(SOURCE_COORDINATE, adjacentNodes = findAdjacentNodes(SOURCE_COORDINATE, maze))
        unvisitedNodes += sourceNode

        while (unvisitedNodes.isNotEmpty()) {
            val currentNode = getLowestDistanceNode(unvisitedNodes)
            currentNode.adjacentNodes = findAdjacentNodes(currentNode.coordinate, maze)

            unvisitedNodes -= currentNode
            for (adjacentNode in currentNode.adjacentNodes) {
                val possibleVisitedNode: Node? = visitedNodes.find { it.coordinate == adjacentNode.coordinate }
                val adjacentNodeWithPath = calculatePathToNode(currentNode, adjacentNode)

                if (possibleVisitedNode != null) {

                    if (possibleVisitedNode.shortestPath.size > adjacentNodeWithPath.shortestPath.size) {
                        visitedNodes -= possibleVisitedNode
                        unvisitedNodes += adjacentNodeWithPath
                    }

                } else {
                    unvisitedNodes += adjacentNodeWithPath
                }
            }
            val possibleVisitedNode: Node? = visitedNodes.find { it.coordinate == currentNode.coordinate }
            if (possibleVisitedNode != null) {
                if (possibleVisitedNode.shortestPath.size > currentNode.shortestPath.size){
                    visitedNodes -= possibleVisitedNode
                    visitedNodes += currentNode
                }
            } else {
                visitedNodes += currentNode
            }
        }


        return visitedNodes
    }

    private fun calculatePathToNode(previousNode: Node, nodeToGivePathTo: Node): Node {
        val currentPath = previousNode.shortestPath.toMutableList()
        currentPath.add(nodeToGivePathTo)
        return Node(nodeToGivePathTo.coordinate, currentPath)
    }

    private fun findAdjacentNodes(originCoordinate: Coordinate, maze: List<List<Int>>): List<Node> {
        val possibleAdjacent = listOf(
                Coordinate(originCoordinate.x - 1, originCoordinate.y),
                Coordinate(originCoordinate.x + 1, originCoordinate.y),
                Coordinate(originCoordinate.x, originCoordinate.y - 1),
                Coordinate(originCoordinate.x, originCoordinate.y + 1))
        return possibleAdjacent
                .filter {
                    !isItAWall(maze, it)
                }
                .map { Node(it) }
    }

    private fun isItAWall(maze: List<List<Int>>, it: Coordinate): Boolean {
        return try {
            maze[it.y][it.x] == 0
        } catch (e: IndexOutOfBoundsException) {
            true
        }
    }

    private fun getLowestDistanceNode(unvisitedNodes: Set<Node>): Node =
            unvisitedNodes.minBy { it.shortestPath.size } ?: unvisitedNodes.first()

}
