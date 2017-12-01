package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

abstract class RotateInstruction : Instruction {

    override fun executeInstruction(password: CharArray): CharArray {
        var amountsLeftToRotate = getAmountToRotate(password)
        var shiftedPassword = password
        while (amountsLeftToRotate > 0) {
            shiftedPassword = shiftChars(password)
            amountsLeftToRotate--
        }
        return shiftedPassword
    }

    abstract fun getAmountToRotate(password: CharArray): Int

    abstract fun shiftChars(password: CharArray): CharArray
}