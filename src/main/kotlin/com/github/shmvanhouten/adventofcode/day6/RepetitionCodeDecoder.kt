package com.github.shmvanhouten.adventofcode.day6

class RepetitionCodeDecoder {
    fun decodeRepetitiveCode(repetitionCode: String): String {
        val repetitionCodeList = repetitionCode.split("\n")
        val columnRange = 0.until(repetitionCodeList[0].length)

        val columnToCharacterOccurrence = mutableMapOf<Int, MutableMap<Char, Int>>()
        columnRange.associateByTo (columnToCharacterOccurrence, { it }, { createCharList() })

        repetitionCodeList.forEach {
            it.forEachIndexed {
                index, char -> val characterMap = columnToCharacterOccurrence[index]
                characterMap?.put(char, characterMap[char]!! + 1)
            }
        }

        return buildMessageFromMostOccurringCharacterPerColumn(columnToCharacterOccurrence)
    }

    private fun createCharList(): MutableMap<Char, Int> {
        val alphabet = 'a'..'z'
        val mutableMapOf = mutableMapOf<Char, Int>()
        return alphabet.associateByTo ( mutableMapOf, {it}, {0} )
    }

    private fun buildMessageFromMostOccurringCharacterPerColumn(columnToCharacterOccurrence: MutableMap<Int, MutableMap<Char, Int>>): String {
        val messageBuilder = StringBuilder()
        columnToCharacterOccurrence.forEach {
            messageBuilder.append(getMostCommonCharacter(it.value))
        }
        return messageBuilder.toString()
    }

    private fun getMostCommonCharacter(characterMap: MutableMap<Char, Int>): Char {
        println(characterMap)
        return characterMap.maxBy { it.value }!!.key
    }
}
