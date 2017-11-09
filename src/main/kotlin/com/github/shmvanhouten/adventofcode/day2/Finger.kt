package com.github.shmvanhouten.adventofcode.day2

interface Finger {
    var location: Char

    fun moveToTheRight()

    fun moveToTheLeft()

    fun moveUp()

    fun moveDown()
}