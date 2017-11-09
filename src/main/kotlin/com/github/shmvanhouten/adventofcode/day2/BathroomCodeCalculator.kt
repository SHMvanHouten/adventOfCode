package com.github.shmvanhouten.adventofcode.day2


class BathroomCodeCalculator (private val finger: Finger){



    fun calculateCodeFromInstructions(instructions: List<String>): String {
    val stringBuilder = StringBuilder()
        for (instructionStep in instructions) {
            for (instruction in instructionStep) {
                followInstruction(instruction)
            }
            stringBuilder.append(finger.location)
        }
        return stringBuilder.toString()
    }

    private fun followInstruction(instruction: Char) {
        when(instruction){
            'R' -> finger.moveToTheRight()
            'L' -> finger.moveToTheLeft()
            'U' -> finger.moveUp()
            'D' -> finger.moveDown()
        }
    }

}