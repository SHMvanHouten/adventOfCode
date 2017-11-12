package com.github.shmvanhouten.adventofcode.day6

class RepetitionCodeDecoderMostOccurringImpl : RepetitionCodeDecoder() {
    override fun buildMessageAccordingToOccurrenceOfCharacterPerColumn(columnToCharacterOccurrence: Map<Int, MutableMap<Char, Int>>): String {
        val messageBuilder = StringBuilder()
        columnToCharacterOccurrence.forEach {
            messageBuilder.append(getMostCommonCharacter(it.value))
        }
        return messageBuilder.toString()
    }


    private fun getMostCommonCharacter(characterMap: Map<Char, Int>): Char? {
        return characterMap.maxBy { it.value }?.key
    }
}