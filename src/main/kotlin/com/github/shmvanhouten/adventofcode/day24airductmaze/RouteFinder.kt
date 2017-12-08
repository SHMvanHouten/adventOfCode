package com.github.shmvanhouten.adventofcode.day24airductmaze

class RouteFinder {

    fun getPossibleRoutes(possibleRoutesAndSizes: Map<Route, Int>, relevantLocations: Set<Int>): Set<WeightedNode> {

        return getPossibleRoutesVisitingAllLocations(possibleRoutesAndSizes, relevantLocations)
    }


    fun getPossibleRoutesReturningToZero(possibleRoutesAndSizes: Map<Route, Int>, relevantLocations: Set<Int>): Set<WeightedNode> {
        val oneWayRoutes = getPossibleRoutesVisitingAllLocations(possibleRoutesAndSizes, relevantLocations)
        return doOneMoreMoveBackToZero(oneWayRoutes, possibleRoutesAndSizes)
    }

    private fun getPossibleRoutesVisitingAllLocations(possibleRoutesAndSizes: Map<Route, Int>, relevantLocations: Set<Int>): Set<WeightedNode> {
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
        return completedRoutes
    }

    private fun getPossibleNodesStemmingFromCurrent(possibleRoutesAndSizes: Map<Route, Int>, relevantLocations: Set<Int>, currentNode: WeightedNode): List<WeightedNode> {
        val unvisitedLocations = relevantLocations.filter { location ->
            !currentNode.locationsVisited.any { it == location }
        }
        return unvisitedLocations.map {
            buildNodeWithNewLocation(possibleRoutesAndSizes, it, currentNode)
        }
    }

    private fun buildNodeWithNewLocation(possibleRoutesAndSizes: Map<Route, Int>, locationToAdd: Int, currentNode: WeightedNode): WeightedNode {
        val weightToAdd = getWeightOfNextStep(possibleRoutesAndSizes, locationToAdd, currentNode)
        return WeightedNode(locationToAdd, currentNode.locationsVisited.plus(locationToAdd), currentNode.weight + weightToAdd)
    }

    private fun getWeightOfNextStep(possibleRoutesAndSizes: Map<Route, Int>, unvisitedLocation: Int, currentNode: WeightedNode): Int {
        val currentLocationNumber = currentNode.locationNumber
        return if (unvisitedLocation > currentLocationNumber) {
            possibleRoutesAndSizes.getValue(Route(currentLocationNumber, unvisitedLocation))
        } else {
            possibleRoutesAndSizes.getValue(Route(unvisitedLocation, currentLocationNumber))
        }

    }

    private fun doOneMoreMoveBackToZero(possibleRoutesVisitingAllLocations: Set<WeightedNode>, possibleRoutesAndSizes: Map<Route, Int>): Set<WeightedNode> {
        return possibleRoutesVisitingAllLocations.map { buildNodeWithNewLocation(possibleRoutesAndSizes, 0, it) }.toSet()
    }

}