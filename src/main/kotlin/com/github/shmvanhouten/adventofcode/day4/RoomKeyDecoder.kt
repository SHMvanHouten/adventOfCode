package com.github.shmvanhouten.adventofcode.day4

class RoomKeyDecoder {

    fun checkIfRoomsAreReal(keys: String): Int {
        return keys.split("\n").sumBy { checkIfRoomIsReal(it.trim()) }
    }

    fun checkIfRoomIsReal(key: String): Int {
        val (name: String, sectorId: Int, checkSum: String) = retrieveRoomIdentifiersFromKey(key)

        val expectedRoomKey = getFiveCharactersMostRepresentedInTheName(name)

        return if (checkSum == expectedRoomKey) sectorId
        else 0
    }

    private fun retrieveRoomIdentifiersFromKey(key: String): Triple<String, Int, String> {
        val (name, sectorIdAndCheckSum) = key.split("-").partition { it[0].isLetter() }
        val sectorId = sectorIdAndCheckSum[0].substringBefore('[').toInt()
        val checkSum = sectorIdAndCheckSum[0].substringAfter('[').substringBefore(']')
        return Triple(name.joinToString(""), sectorId, checkSum)
    }

    private fun getFiveCharactersMostRepresentedInTheName(name: String): String {
        val sortedCharacters = sortCharactersByQuantityAndAlphabet(name)

        val roomKey = StringBuilder()

        sortedCharacters.mapIndexed { index, char -> if (index < 5) roomKey.append(char) }

        return roomKey.toString()
    }

    private fun sortCharactersByQuantityAndAlphabet(name: String): MutableSet<Char> {
        val characterToAmountMap = name.associateBy({ it }, { countHowManyCharactersAreInName(it, name) })
        return characterToAmountMap.toSortedMap(compareByDescending<Char> { characterToAmountMap[it] }.thenBy { it }).keys
    }

    private fun countHowManyCharactersAreInName(char: Char, name: String): Int {
        return name.count { it == char }
    }

}


