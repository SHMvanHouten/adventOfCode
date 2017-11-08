package com.github.shmvanhouten.adventofcode.day1

class CoordinateStorage(private val xToYMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()) {

    fun checkAndAddCoordinates(currentX: Int, currentY: Int): Boolean {

        if (xToYMap.containsKey(currentX)) {
            val listOfYCoordinatesVisitedForThisX = xToYMap[currentX]

            val coordinatesHaveBeenVisited: Boolean = haveCoordinatesBeenVisited(listOfYCoordinatesVisitedForThisX, currentY)

            if(coordinatesHaveBeenVisited) return true
            else listOfYCoordinatesVisitedForThisX?.add(currentY); return false

        } else {
            xToYMap.put(currentX, mutableListOf(currentY))
            return false
        }
    }

    private fun haveCoordinatesBeenVisited(listOfYCoordinates: MutableList<Int>?, currentY: Int): Boolean {
        return listOfYCoordinates?.contains(currentY) ?: false
    }
}