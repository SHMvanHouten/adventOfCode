package com.github.shmvanhouten.adventofcode.day24airductmaze

class RouteFinder {

    fun getFastestRoute(possibleRoutesAndSizes: Map<Route, Int>, relevantLocations: Set<Int>): Int? {

        var unVisitedRoutes = setOf(WeightedNode(0, listOf(0)))
        var completedRoutes = setOf<WeightedNode>()

        while (unVisitedRoutes.isNotEmpty()) {
            val currentNode = unVisitedRoutes.first()
            unVisitedRoutes -= currentNode

            val newNodes = getPossibleNodesStemmingFromCurrent(possibleRoutesAndSizes, relevantLocations, currentNode)

            unVisitedRoutes += newNodes

            if (currentNode.locationsVisited.size == relevantLocations.size) {
                completedRoutes += currentNode
            }
        }
        return completedRoutes.minBy { it.weight }?.weight
    }

    private fun getPossibleNodesStemmingFromCurrent(possibleRoutesAndSizes: Map<Route, Int>, relevantLocations: Set<Int>, currentNode: WeightedNode): List<WeightedNode> {
        val unvisitedLocations = relevantLocations.filter { location ->
            !currentNode.locationsVisited.any { it == location }
        }
        return unvisitedLocations.map {
            val weightToAdd = getWeightOfNextStep(possibleRoutesAndSizes, it, currentNode)
            WeightedNode(it, currentNode.locationsVisited.plus(it), currentNode.weight + weightToAdd)
        }
    }

    private fun getWeightOfNextStep(possibleRoutesAndSizes: Map<Route, Int>, unvisitedLocation: Int, currentNode: WeightedNode): Int {
        val currentLocationNumber = currentNode.locationNumber
        return if (unvisitedLocation > currentLocationNumber) {
            possibleRoutesAndSizes.getValue(Route(currentLocationNumber, unvisitedLocation))
        } else {
            possibleRoutesAndSizes.getValue(Route(unvisitedLocation, currentLocationNumber))
        }

    }
}