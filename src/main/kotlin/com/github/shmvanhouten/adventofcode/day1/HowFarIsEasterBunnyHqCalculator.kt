package com.github.shmvanhouten.adventofcode.day1

import java.lang.Math.abs


class HowFarIsEasterBunnyHqCalculator(private val walker: Walker = Walker(), private val coordinateStorage:CoordinateStorage = CoordinateStorage()){

    fun calculateDistanceToHq(instructions: String): Int {
        val instructionsList: List<String> = instructions.split(", ")
        for (instruction in instructionsList) {
            val possibleHqCoordinates = followInstructions(instruction)
            if (possibleHqCoordinates != null){
                return determineDistanceTraveled(possibleHqCoordinates.x, possibleHqCoordinates.y)
            }
        }
        return determineDistanceTraveled(walker.x, walker.y)
    }

    private fun determineDistanceTraveled(x: Int, y: Int): Int {
        return abs(x) + abs(y)
    }

    private fun followInstructions(instruction: String): Coordinates? {
        val xStart = walker.x
        val yStart = walker.y

        doTurn(instruction)

        takeSteps(instruction)

        val xEnd = walker.x
        val yEnd = walker.y

        val xCoordinates: IntRange = getRangeFromCoordinatesExcludingStartingCoordinate(xStart, xEnd)
        val yCoordinates: IntRange = getRangeFromCoordinatesExcludingStartingCoordinate(yStart, yEnd)

        for (xCoordinate in xCoordinates) {
            for (yCoordinate in yCoordinates) {
                val coordinatesHaveBeenVisited:Boolean = coordinateStorage.checkAndAddCoordinates(xCoordinate, yCoordinate)
                if(coordinatesHaveBeenVisited){
                    return Coordinates(xCoordinate, yCoordinate)
                }
            }
        }
        return null
    }


    private fun takeSteps(instruction: String) {
        val amountOfSteps: Int = instruction.substring(1).toInt()
        walker.walk(amountOfSteps)
    }

    private fun doTurn(instruction: String) {
        val wayToTurn: Char = instruction[0]
        when (wayToTurn) {
            'L' -> walker.turnLeft()
            'R' -> walker.turnRight()
        }
    }

    private fun getRangeFromCoordinatesExcludingStartingCoordinate(start: Int, end: Int): IntRange {
        if(end == start) return end..start

        return if(end > start) start + 1..end
        else end until start
    }

}