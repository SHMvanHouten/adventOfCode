package com.github.shmvanhouten.adventofcode.day6

class RepetitionCodeDecoderLeastOccurringImpl : RepetitionCodeDecoder() {
    override fun buildMessageAccordingToOccurrenceOfCharacterPerColumn(columnToCharacterOccurrence: Map<Int, List<CharacterOccurrence>>): String {
        val messageBuilder = StringBuilder()
        columnToCharacterOccurrence.forEach {
            messageBuilder.append(getLeastCommonCharacter(it.value))
        }
        return messageBuilder.toString()
    }



    private fun getLeastCommonCharacter (characterMap: List<CharacterOccurrence>): Char? {
        return characterMap.filter { it.occurrence > 0 }.minBy { it.occurrence }?.char
    }
}