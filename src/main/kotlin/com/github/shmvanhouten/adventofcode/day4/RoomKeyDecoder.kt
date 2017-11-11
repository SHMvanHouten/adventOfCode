package com.github.shmvanhouten.adventofcode.day4

class RoomKeyDecoder {
    fun checkIfRoomIsReal(key: String): Boolean {
        val (name: List<String>, sectorId: Int, checkSum: String) = retrieveRoomIdentifiersFromKey(key)
        return true
    }

    private fun retrieveRoomIdentifiersFromKey(key: String): Triple<List<String>, Int, String> {
        val (name, sectorIdAndCheckSum) = key.split("-").partition { it[0].isLetter() }
        val sectorId = sectorIdAndCheckSum[0].substringBefore('[').toInt()
        val checkSum = sectorIdAndCheckSum[0].substringAfter('[').substringBefore(']')
        return Triple(name, sectorId, checkSum)
    }
}