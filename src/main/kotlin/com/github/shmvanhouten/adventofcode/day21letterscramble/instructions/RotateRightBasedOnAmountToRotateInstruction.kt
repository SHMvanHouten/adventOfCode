package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class RotateRightBasedOnAmountToRotateInstruction(private val amountToRotate: Int) : RotateRightInstruction() {

    override fun getAmountToRotate(password: CharArray): Int {
        return amountToRotate
    }
}