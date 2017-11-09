package com.github.shmvanhouten.adventofcode.day2


class BathroomCodeCalculator {
    private val finger = Finger()


    fun calculateCodeFromInstructions(instructions: List<String>): MutableList<Int> {
    val listOfDigitsToPress = mutableListOf<Int>()
        for (instructionStep in instructions) {
            for (instruction in instructionStep) {
                followInstruction(instruction)
            }
            listOfDigitsToPress.add(finger.location)
        }
        return listOfDigitsToPress
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