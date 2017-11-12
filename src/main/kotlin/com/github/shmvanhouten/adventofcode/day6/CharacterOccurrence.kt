package com.github.shmvanhouten.adventofcode.day6

data class CharacterOccurrence (val char: Char, var occurrence: Int = 0){
    fun addOne(){
        occurrence++
    }
}