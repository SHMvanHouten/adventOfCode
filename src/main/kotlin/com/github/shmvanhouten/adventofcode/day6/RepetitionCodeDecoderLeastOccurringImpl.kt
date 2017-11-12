package com.github.shmvanhouten.adventofcode.day6

class RepetitionCodeDecoderLeastOccurringImpl : RepetitionCodeDecoder() {
    override fun buildMessageAccordingToOccurrenceOfCharacterPerColumn(columnToCharacterOccurrence: Map<Int, MutableMap<Char, Int>>): String {
        val messageBuilder = StringBuilder()
        columnToCharacterOccurrence.forEach {
            messageBuilder.append(getLeastCommonCharacter(it.value))
        }
        return messageBuilder.toString()
    }



    private fun getLeastCommonCharacter (characterMap: Map<Char, Int>): Char? {
        return characterMap.filter { it.value > 0 }.minBy { it.value }?.key
    }
}