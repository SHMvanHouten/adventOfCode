package com.github.shmvanhouten.adventofcode.day13

class PathFinder {
    private val SOURCE_COORDINATE = Coordinate(1, 1)
    fun findQuickestPathLength(maze: List<List<Int>>, targetCoordinate: Coordinate): Int {

        val pathsToVisitedNodes = getPathsToVisitedNodes(maze)
        return pathsToVisitedNodes.find { it.coordinate == targetCoordinate }?.shortestPath?.size?: -1
    }

    private fun getPathsToVisitedNodes(maze: List<List<Int>>): MutableList<Node> {
        var unvisitedNodes = setOf<Node>()
        val visitedNodes = mutableListOf<Node>()

        val source = Node(SOURCE_COORDINATE, adjacentNodes = getAdjacentNodes(SOURCE_COORDINATE, maze))
        unvisitedNodes = unvisitedNodes.add(source)

        while (unvisitedNodes.isNotEmpty()) {
            val currentNode = getLowestDistanceNode(unvisitedNodes)
            currentNode.adjacentNodes = getAdjacentNodes(currentNode.coordinate, maze)
            unvisitedNodes = unvisitedNodes.remove(currentNode)
            for (adjacentNode in currentNode.adjacentNodes) {
                val possibleVisitedNode: Node? = visitedNodes.find { it.coordinate == adjacentNode.coordinate }
                val adjacentNodeWithPath = addPathToNode(currentNode, adjacentNode)

                if (possibleVisitedNode != null) {
                    // if the path in the visited node is longer than the path in the adjacentNode remove it and add adjacentNode to unvisitedNotes to be evaluated
                    if (possibleVisitedNode.shortestPath.size > adjacentNodeWithPath.shortestPath.size) {
                        visitedNodes.remove(possibleVisitedNode)
                        unvisitedNodes = unvisitedNodes.add(adjacentNodeWithPath)
                    } else {
                        unvisitedNodes = unvisitedNodes.remove(adjacentNode)
                    }
                } else {
                    unvisitedNodes = unvisitedNodes.add(adjacentNodeWithPath)
                }
            }
            visitedNodes.add(currentNode)
        }


        return visitedNodes
    }

    private fun addPathToNode(previousNode: Node, nodeToGivePathTo: Node): Node {
        val currentPath = previousNode.shortestPath.toMutableList()
        currentPath.add(nodeToGivePathTo)
        return Node(nodeToGivePathTo.coordinate, currentPath)
    }

}

private fun <Node> Set<Node>.remove(nodeToRemove: Node): Set<Node> {
    val mutableVersionOfSet = this.toMutableSet()
    mutableVersionOfSet.remove(nodeToRemove)
    return mutableVersionOfSet.toSet()
}

private fun <Node> Set<Node>.add(nodeToAdd: Node): Set<Node> {
    val mutableVersionOfSet = this.toMutableSet()
    mutableVersionOfSet.add(nodeToAdd)
    return mutableVersionOfSet.toSet()
}

private fun getAdjacentNodes(originCoordinate: Coordinate, maze: List<List<Int>>): List<Node> {
    val possibleAdjacent = listOf<Coordinate>(
            Coordinate(originCoordinate.x - 1, originCoordinate.y),
            Coordinate(originCoordinate.x + 1, originCoordinate.y),
            Coordinate(originCoordinate.x, originCoordinate.y - 1),
            Coordinate(originCoordinate.x, originCoordinate.y + 1))
    return possibleAdjacent
            .filter {
                !isItWall(maze, it)
            }
            .map { Node(it) }
}

private fun isItWall(maze: List<List<Int>>, it: Coordinate): Boolean {
    return try {
        maze[it.y][it.x] == 0
    } catch (e: IndexOutOfBoundsException) {
        true
    }
}

private fun getLowestDistanceNode(unvisitedNodes: Set<Node>): Node =
        unvisitedNodes.minBy { it.shortestPath.size } ?: unvisitedNodes.first()

