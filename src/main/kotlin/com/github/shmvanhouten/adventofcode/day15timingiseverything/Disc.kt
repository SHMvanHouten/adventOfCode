package com.github.shmvanhouten.adventofcode.day15timingiseverything

data class Disc(val amountOfPossiblePositions: Int, val currentPosition: Int) {
    fun move(amount: Int = 1): Disc {
        return Disc(this.amountOfPossiblePositions, getPosition(amount))
    }

    private fun getPosition(amountOfMoves: Int): Int {
        return (currentPosition + amountOfMoves) % amountOfPossiblePositions
    }
}