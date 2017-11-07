package com.github.shmvanhouten.adventofcode.day1

import com.github.shmvanhouten.adventofcode.day1.Direction.*

class Walker(var x: Int = 0, var y:Int = 0, private var direction: Direction = NORTH){

    fun turnRight() {
        direction = direction.turnRight()
    }

    fun turnLeft() {
        direction = direction.turnLeft()
    }

    fun walk(amountOfSteps: Int){
        when(direction){
            NORTH -> y += amountOfSteps
            EAST -> x += amountOfSteps
            SOUTH -> y -= amountOfSteps
            WEST -> x -= amountOfSteps
        }
    }
}

