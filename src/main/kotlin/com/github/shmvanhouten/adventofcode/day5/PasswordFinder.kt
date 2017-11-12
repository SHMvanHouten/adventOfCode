package com.github.shmvanhouten.adventofcode.day5

class PasswordFinder(val hashUtil: HashUtil = HashUtil()) {

    fun calculatePasswordForFirstDoor(doorId: String): String {
        val zeroToMax = 0..Int.MAX_VALUE
        val passwordBuilder = StringBuilder()

        for (index in zeroToMax) {
            val sixthHexaDecimal = hashUtil.get00000xHashMd5(doorId + index)
            if (sixthHexaDecimal != null) {
                passwordBuilder.append(sixthHexaDecimal)
                if (passwordBuilder.length >= 8) break
            }
        }

        return passwordBuilder.toString()
    }

    fun calculatePasswordForSecondDoor(doorId: String): String {
        val password = mutableMapOf<Char, Char>()

        var i = 0
        while (password.size < 8) {
            val sixthAndSeventhHexaDecimal = hashUtil.get00000xHashMd5Wherexis1to7incl(doorId + i)
            if(sixthAndSeventhHexaDecimal != null && !password.containsKey(sixthAndSeventhHexaDecimal.first)){
                password.put(sixthAndSeventhHexaDecimal.first, sixthAndSeventhHexaDecimal.second)
            }
            i++
        }

        return password.toSortedMap().values.joinToString("")
    }
}