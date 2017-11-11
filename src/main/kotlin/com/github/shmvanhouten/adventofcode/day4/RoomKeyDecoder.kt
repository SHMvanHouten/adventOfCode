package com.github.shmvanhouten.adventofcode.day4

class RoomKeyDecoder {

    fun checkIfRoomsAreReal(keys: String): Int {
        return keys.split("\n").sumBy { checkIfRoomIsReal(it.trim()) }
    }

    fun getListOfValidRooms(encodedRoomNames: String): List<Pair<List<String>, Int>> {
        return encodedRoomNames.split("\n").mapNotNull { getRealRoom(it.trim()) }
    }

    fun checkIfRoomIsReal(key: String): Int {
        val (name:List<String>, sectorId: Int, checkSum: String) = retrieveRoomIdentifiersFromKey(key)

        val expectedRoomKey = getFiveCharactersMostRepresentedInTheName(name)

        return if (checkSum == expectedRoomKey) sectorId
        else 0
    }

    private fun getRealRoom(key: String): Pair<List<String>, Int>? {
        val (name:List<String>, sectorId: Int, checkSum: String) = retrieveRoomIdentifiersFromKey(key)

        val expectedRoomKey = getFiveCharactersMostRepresentedInTheName(name)

        return if (checkSum == expectedRoomKey) Pair(name, sectorId)
        else null
    }

    private fun retrieveRoomIdentifiersFromKey(key: String): Triple<List<String>, Int, String> {
        val (name, sectorIdAndCheckSum) = key.split("-").partition { it[0].isLetter() }
        val sectorId = sectorIdAndCheckSum[0].substringBefore('[').toInt()
        val checkSum = sectorIdAndCheckSum[0].substringAfter('[').substringBefore(']')
        return Triple(name, sectorId, checkSum)
    }

    private fun getFiveCharactersMostRepresentedInTheName(name: List<String>): String {
        val sortedCharacters = sortCharactersByQuantityAndAlphabet(name.joinToString(""))

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


