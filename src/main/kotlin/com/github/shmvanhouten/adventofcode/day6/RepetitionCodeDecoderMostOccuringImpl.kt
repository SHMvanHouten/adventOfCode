package com.github.shmvanhouten.adventofcode.day6

class RepetitionCodeDecoderMostOccuringImpl : RepetitionCodeDecoder() {
    override fun buildMessageFromMostOccurringCharacterPerColumn(columnToCharacterOccurrence: MutableMap<Int, MutableMap<Char, Int>>): String {
        val messageBuilder = StringBuilder()
        columnToCharacterOccurrence.forEach {
            messageBuilder.append(getMostCommonCharacter(it.value))
        }
        return messageBuilder.toString()
    }


    private fun getMostCommonCharacter(characterMap: MutableMap<Char, Int>): Char {
        return characterMap.maxBy { it.value }!!.key
    }
}