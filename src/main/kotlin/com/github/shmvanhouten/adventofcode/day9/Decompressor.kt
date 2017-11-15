package com.github.shmvanhouten.adventofcode.day9

class Decompressor {

    fun getSizeOfDecompressedString(compressedInput: String): Int = decompress(compressedInput).length

    fun decompress(compressedInput: String): String {
        val startOfMarker = compressedInput.indexOf('(')
        if(startOfMarker == -1) return compressedInput


        val decompressedString = StringBuilder(compressedInput.substring(0, startOfMarker))

        val endOfMarker = compressedInput.indexOf(')')
        val (indexOfLastCompressedCharacter, factor) = getIndexOfLastCompressedCharacterAndFactor(compressedInput, startOfMarker, endOfMarker)

        val compressedChars = compressedInput.subSequence((endOfMarker + 1)..indexOfLastCompressedCharacter)
        for(times in 1..factor){
            compressedChars.forEach { decompressedString.append(it) }
        }


        decompressedString.append(decompress(compressedInput.substring(indexOfLastCompressedCharacter + 1)))

        return decompressedString.toString()
    }

    private fun getIndexOfLastCompressedCharacterAndFactor(compressedInput: String, startOfMarker: Int, endOfMarker: Int): Pair<Int, Int> {
        val marker = compressedInput.substring(startOfMarker + 1, endOfMarker).split('x')
        val amountOfCharactersToMultiply = marker[0].toInt()
        val factor = marker[1].toInt()
        val indexOfLastCompressedCharacter = endOfMarker + amountOfCharactersToMultiply
        return Pair(indexOfLastCompressedCharacter, factor)
    }
}