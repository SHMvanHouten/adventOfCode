package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class MovePositionInstruction(private val indexOfCharToRemove: Int, private val positionToMoveTo: Int) : Instruction {

    override fun executeInstruction(password: CharArray): CharArray {
        return if(indexOfCharToRemove < positionToMoveTo){
            moveCharForward(password)
        }else{
            moveCharBack(password)
        }
    }

    private fun moveCharForward(password: CharArray): CharArray {
        val beforeRemovedChar = password.sliceArray(0.until(indexOfCharToRemove))
        val charToMove = password[indexOfCharToRemove]
        val betweenRemovedCharAndNewCharPosition = password.sliceArray((indexOfCharToRemove + 1).until(positionToMoveTo + 1))
        val afterNewCharPosition = password.sliceArray((positionToMoveTo + 1)..password.lastIndex)
        return beforeRemovedChar.plus(betweenRemovedCharAndNewCharPosition).plus(charToMove).plus(afterNewCharPosition)
    }


    private fun moveCharBack(password: CharArray): CharArray {
        val beforeIndexToMoveTo = password.sliceArray(0.until(positionToMoveTo))
        val betweenIndexToMoveToAndRemovedChar = password.sliceArray(positionToMoveTo.until(indexOfCharToRemove))
        val charToMove = password[indexOfCharToRemove]
        val afterCharToRemove = password.sliceArray((indexOfCharToRemove + 1)..password.lastIndex)
        return beforeIndexToMoveTo.plus(charToMove).plus(betweenIndexToMoveToAndRemovedChar).plus(afterCharToRemove)
    }
}