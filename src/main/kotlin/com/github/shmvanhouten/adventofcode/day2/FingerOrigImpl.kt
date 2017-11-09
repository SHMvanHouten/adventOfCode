package com.github.shmvanhouten.adventofcode.day2

const val STARTING_LOCATION: Char = '5'

class FingerOrigImpl: Finger {
    override var location: Char = STARTING_LOCATION

    override fun moveToTheRight(){
        return when(location){
            '3', '6', '9' -> println("invalid move, can't move to the right from $location")
            else -> location += 1
        }
    }

    override fun moveToTheLeft() {
        return when(location){
            '1', '4', '7' -> println("invalid move, can't move to the left from $location")
            else -> location -= 1
        }
    }

    override fun moveUp() {
        return when(location){
            '1', '2', '3' -> println("invalid move, can't move up from $location")
            else -> location -= 3
        }
    }

    override fun moveDown() {
        return when(location){
            '7', '8', '9' -> println("invalid move, can't move down from $location")
            else -> location += 3
        }
    }

}