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
        val amountsOfCharactersInName = getMapOfAmountsOfCharactersInName(name)

        return sort5CharactersAppropriate(amountsOfCharactersInName)
    }

    private fun getMapOfAmountsOfCharactersInName(name: String): MutableMap<Int, MutableList<Char>> {
        val amountsOfCharactersInName = mutableMapOf<Int, MutableList<Char>>()

        for (char in name) {
            val amountOfThisCharInName = name.count { it == char }
            if (!amountsOfCharactersInName.containsKey(amountOfThisCharInName)) {
                amountsOfCharactersInName.put(amountOfThisCharInName, mutableListOf(char))
            }
            if (!amountsOfCharactersInName[amountOfThisCharInName]!!.contains(char)) {
                amountsOfCharactersInName[amountOfThisCharInName]!!.add(char)
            }
        }
        return amountsOfCharactersInName
    }

    private fun sort5CharactersAppropriate(amountsOfCharactersInName: MutableMap<Int, MutableList<Char>>): String {
        val sortedBySizeMap = amountsOfCharactersInName.toSortedMap()
        val fiveMostCommonCharactersBuilder = StringBuilder()

        for (key in sortedBySizeMap.keys.reversed()) {
            val listOfCharacters = sortedBySizeMap[key]!!
            listOfCharacters.sort()
            for (char in listOfCharacters) {
                if (fiveMostCommonCharactersBuilder.length < 5) fiveMostCommonCharactersBuilder.append(char)
                else return fiveMostCommonCharactersBuilder.toString()
            }
        }
        return fiveMostCommonCharactersBuilder.toString()
    }
}


