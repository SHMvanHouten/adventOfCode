package com.github.shmvanhouten.adventofcode.day4

class RoomKeyDecoder {

    fun checkIfRoomsAreReal(keys: String): Int {
        return keys.split("\n").sumBy { checkIfRoomIsReal(it.trim()) }
    }

    fun checkIfRoomIsReal(key: String): Int {
        val (name: String, sectorId: Int, checkSum: String) = retrieveRoomIdentifiersFromKey(key)

        var previousCheckSumCharValue = name.length + 1
        var previousChar = '0'
        for (char in checkSum) {
            val amountOfTimesCharIsInName = name.count { it == char }
            println("previousChar = $previousChar, char = $char, previousCheckSum = $previousCheckSumCharValue, amountOfTimesCharIsInName = $amountOfTimesCharIsInName")
            if (amountOfTimesCharIsInName > previousCheckSumCharValue || (amountOfTimesCharIsInName == previousCheckSumCharValue && char < previousChar)) {
                return 0
            }
            previousCheckSumCharValue = amountOfTimesCharIsInName
            previousChar = char
        }
        return sectorId
    }

    private fun retrieveRoomIdentifiersFromKey(key: String): Triple<String, Int, String> {
        val (name, sectorIdAndCheckSum) = key.split("-").partition { it[0].isLetter() }
        val sectorId = sectorIdAndCheckSum[0].substringBefore('[').toInt()
        val checkSum = sectorIdAndCheckSum[0].substringAfter('[').substringBefore(']')
        return Triple(name.joinToString(""), sectorId, checkSum)
    }

}