package com.github.shmvanhouten.adventofcode.day5

class PasswordFinder(private val hashUtil: HashUtil = HashUtil()) {

    fun calculatePasswordForFirstDoor(doorId: String): String {
        val passwordBuilder = StringBuilder()

        var index = 0
        while (passwordBuilder.length < 8) {
            val sixthHexadecimal = hashUtil.hashStringIfItStartsWith00000(doorId + index)
            if (sixthHexadecimal != null) {
                passwordBuilder.append(sixthHexadecimal)
            }
            index++
        }

        return passwordBuilder.toString()
    }

    fun calculatePasswordForSecondDoor(doorId: String): String {
        val password = mutableMapOf<Char, Char>()

        var index = 0
        while (password.size < 8) {
            val sixthAndSeventhHexadecimal = hashUtil.hashStringIfItStartsWith00000xWherexIs1to7inc(doorId + index)
            if(sixthAndSeventhHexadecimal != null && !password.containsKey(sixthAndSeventhHexadecimal.first)){
                password.put(sixthAndSeventhHexadecimal.first, sixthAndSeventhHexadecimal.second)
            }
            index++
        }

        return password.toSortedMap().values.joinToString("")
    }
}