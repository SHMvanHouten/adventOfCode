package com.github.shmvanhouten.adventofcode.day6

class RepetitionCodeDecoderMostOccurringImpl : RepetitionCodeDecoder() {
    override fun buildMessageAccordingToOccurrenceOfCharacterPerColumn(columnToCharacterOccurrence: Map<Int, List<CharacterOccurrence>>): String {
        val messageBuilder = StringBuilder()
        columnToCharacterOccurrence.forEach {
            messageBuilder.append(getMostCommonCharacter(it.value))
        }
        return messageBuilder.toString()
    }


    private fun getMostCommonCharacter(characterMap: List<CharacterOccurrence>): Char? {
        return characterMap.maxBy { it.occurrence }?.char
    }
}