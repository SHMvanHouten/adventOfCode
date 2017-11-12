package com.github.shmvanhouten.adventofcode.day6

abstract class RepetitionCodeDecoder {
    fun decodeRepetitiveCode(repetitionCode: String): String {

        val repetitionCodeList = repetitionCode.split("\n")
        val columnToCharacterOccurrence = buildColumnToCharOccurrenceMap(repetitionCodeList)

        repetitionCodeList.forEach {
            it.forEachIndexed { index, char -> columnToCharacterOccurrence[index]?.find { it.char == char }?.addOne()
            }
        }

        return buildMessageAccordingToOccurrenceOfCharacterPerColumn(columnToCharacterOccurrence)
    }

    private fun buildColumnToCharOccurrenceMap(repetitionCodeList: List<String>): Map<Int, List<CharacterOccurrence>> {

        val columnRange = 0.until(repetitionCodeList[0].length)
        return columnRange.associateBy({ it }, { createCharOccurrenceList() })
    }

    private fun createCharOccurrenceList(): List<CharacterOccurrence> {
        val alphabet = 'a'..'z'
        return alphabet.map { CharacterOccurrence(it) }
    }

    abstract fun buildMessageAccordingToOccurrenceOfCharacterPerColumn(columnToCharacterOccurrence: Map<Int, List<CharacterOccurrence>>): String

}
