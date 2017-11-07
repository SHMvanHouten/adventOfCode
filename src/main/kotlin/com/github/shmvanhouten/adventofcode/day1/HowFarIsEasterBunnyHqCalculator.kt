package com.github.shmvanhouten.adventofcode.day1

import java.lang.Math.abs


class HowFarIsEasterBunnyHqCalculator(private val walker: Walker = Walker()){

    fun calculateDistanceToHq(instructions: String): Int {
        val instructionsList: List<String> = instructions.split(", ")
        for (instruction in instructionsList) {
            followInstructions(instruction)
        }
        return determineDistanceTraveled(walker.x, walker.y)
    }

    private fun determineDistanceTraveled(x: Int, y: Int): Int {
        return abs(x) + abs(y)
    }

    private fun followInstructions(instruction: String) {
        val wayToTurn: Char = instruction[0]
        when (wayToTurn) {
            'L' -> walker.turnLeft()
            'R' -> walker.turnRight()
        }
        val amountOfSteps: Int = instruction.substring(1).toInt()
        walker.walk(amountOfSteps)
    }

}