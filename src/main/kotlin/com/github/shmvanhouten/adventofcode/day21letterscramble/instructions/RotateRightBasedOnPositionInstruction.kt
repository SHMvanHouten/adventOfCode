package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class RotateRightBasedOnPositionInstruction(private val charToBaseAmountToMoveOn: Char) : RotateRightInstruction() {
    override fun getAmountToRotate(password: CharArray): Int {
        val indexOfChar = password.indexOf(charToBaseAmountToMoveOn)
        return if(indexOfChar >= 4){
            indexOfChar + 2
        }else{
            indexOfChar + 1
        }
    }
}