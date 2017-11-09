package com.github.shmvanhouten.adventofcode.day2

class FingerNewImpl(override var location: Char = STARTING_LOCATION) : Finger {

    override fun moveToTheRight() {
        return when (location) {
            '1', '4', '9', 'C', 'D' -> println("invalid move, can't move to the right from $location")
            else -> location += 1
        }
    }

    override fun moveToTheLeft() {
        return when (location) {
            '1', '2', '5', 'A', 'D' -> println("invalid move, can't move to the left from $location")
            else -> location -= 1
        }
    }

    override fun moveUp() {
        return when (location) {
            '3' -> location = '1'
            '6', '7', '8' -> location -= 4
            'A' -> location = '6'
            'B' -> location = '7'
            'C' -> location = '8'
            'D' -> location = 'B'
            else -> println("invalid move, can't move up from $location")
        }
    }

    override fun moveDown() {
        return when (location) {
            '1' -> location = '3'
            '2', '3', '4' -> location += 4
            '6' -> location = 'A'
            '7' -> location = 'B'
            '8' -> location = 'C'
            'B' -> location = 'D'
            else -> println("invalid move, can't move down from $location")
        }
    }
}