package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class RotateLeftInstruction(private val amountToRotate: Int): RotateInstruction() {

    override fun getAmountToRotate(password: CharArray): Int {
        return amountToRotate
    }

    override fun shiftChars(password: CharArray): CharArray {
        val originalFirstChar = password[0]
        for (index in 0 until password.lastIndex) {
            password[index] = password[index + 1]
        }
        password[password.lastIndex] = originalFirstChar
        return password
    }
}