package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

abstract class RotateRightInstruction(): RotateInstruction() {


    override fun shiftChars(password: CharArray): CharArray {
        var previousChar = password[password.lastIndex]
        for(index in 0..password.lastIndex){
            val tempStoredChar = previousChar
            previousChar = password[index]
            password[index] = tempStoredChar
        }
        return password
    }
}