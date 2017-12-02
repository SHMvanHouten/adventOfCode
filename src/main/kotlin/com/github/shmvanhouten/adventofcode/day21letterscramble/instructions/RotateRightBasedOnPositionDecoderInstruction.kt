package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class RotateRightBasedOnPositionDecoderInstruction(private val charToBaseAmountToMoveOn: Char) : RotateRightInstruction() {
    override fun getAmountToRotate(password: CharArray): Int {
        return when (password.indexOf(charToBaseAmountToMoveOn)) {
            2 -> 2
            3 -> 6
            4 -> 1
            5 -> 5
            6 -> 0
            7 -> 4
            else -> 7
        }
    }
}