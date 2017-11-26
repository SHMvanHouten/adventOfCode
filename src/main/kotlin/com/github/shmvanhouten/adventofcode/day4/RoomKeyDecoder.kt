package com.github.shmvanhouten.adventofcode.day4

class RoomKeyDecoder {

    fun checkIfRoomsAreReal(keys: String): Int {
        return keys
                .split("\n")
                .sumBy { checkIfRoomIsReal(it.trim()) }
    }

    fun getListOfValidRooms(encodedRoomNames: String): List<Room> {
        return encodedRoomNames.split("\n").mapNotNull { getRealRoom(it.trim()) }
    }

    fun checkIfRoomIsReal(key: String): Int {
        val (name:List<String>, sectorId: Int, checkSum: String) = retrieveRoomIdentifiersFromKey(key)

        val expectedRoomKey = getFiveCharactersMostRepresentedInTheName(name)

        return if (checkSum == expectedRoomKey) sectorId
        else 0
    }

    private fun getRealRoom(key: String): Room? {
        val (name:List<String>,
                sectorId: Int,
                checkSum: String) = retrieveRoomIdentifiersFromKey(key)

        val expectedRoomKey = getFiveCharactersMostRepresentedInTheName(name)

        return if (checkSum == expectedRoomKey) Room(name, sectorId)
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

        for (indexedChar in sortedCharacters.withIndex()) {
            roomKey.append(indexedChar.value)
            if(indexedChar.index >= 4) break
        }
//        run breaker@{sortedCharacters.forEachIndexed { index, char -> roomKey.append(char); if (index == 4) return@breaker}}

        return roomKey.toString()
    }

    private fun sortCharactersByQuantityAndAlphabet(roomName: String): MutableSet<Char> {
        val characterToAmountMap = roomName.associateBy({ it }, { countTimesCharacterIsInRoomName(it, roomName) })
        return characterToAmountMap
                .toSortedMap(compareByDescending<Char> { characterToAmountMap.getValue(it) }.thenBy { it })
                .keys
    }

    private fun countTimesCharacterIsInRoomName(char: Char, name: String): Int {
        return name.count { it == char }
    }
}


