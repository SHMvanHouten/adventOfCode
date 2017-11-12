package com.github.shmvanhouten.adventofcode.day5

class PasswordFinder(val hashUtil: HashUtil = HashUtil()) {

    fun calculatePasswordForFirstDoor(doorId: String): String {
        val passwordBuilder = StringBuilder()

        var index = 0
        while (passwordBuilder.length < 8) {
            val sixthHexaDecimal = hashUtil.hashStringIfItStartsWith00000(doorId + index)
            if (sixthHexaDecimal != null) {
                passwordBuilder.append(sixthHexaDecimal)
            }
            index++
        }

        return passwordBuilder.toString()
    }

    fun calculatePasswordForSecondDoor(doorId: String): String {
        val password = mutableMapOf<Char, Char>()

        var index = 0
        while (password.size < 8) {
            val sixthAndSeventhHexaDecimal = hashUtil.hashStringIfItStartsWith00000xWherexIs1to7inc(doorId + index)
            if(sixthAndSeventhHexaDecimal != null && !password.containsKey(sixthAndSeventhHexaDecimal.first)){
                password.put(sixthAndSeventhHexaDecimal.first, sixthAndSeventhHexaDecimal.second)
            }
            index++
        }

        return password.toSortedMap().values.joinToString("")
    }
}