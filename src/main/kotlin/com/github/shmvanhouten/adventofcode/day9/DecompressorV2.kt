package com.github.shmvanhouten.adventofcode.day9

class DecompressorV2 {
    fun getSizeOfDecompressedString(compressedInput: String): Int = decompress(compressedInput).length

    fun decompress(compressedInput: String): String {
        val startOfMarker = compressedInput.indexOf('(')
        if (startOfMarker == -1) return compressedInput


        val decompressedBuilder = StringBuilder(compressedInput.substring(0, startOfMarker))

        val indexOfLastCompressedCharacter = handleCompression(compressedInput, startOfMarker,  decompressedBuilder)

        decompressedBuilder.append(decompress(compressedInput.substring(indexOfLastCompressedCharacter + 1)))

        return decompressedBuilder.toString()
    }

    private fun handleCompression(compressedInput: String, startOfMarker: Int,decompressedBuilder: StringBuilder, parentFactor: Int = 1): Int {
        val endOfMarker = compressedInput.indexOf(')')
        val (indexOfLastCompressedCharacter, factor) = getIndexOfLastCompressedCharacterAndFactor(compressedInput, startOfMarker, endOfMarker, parentFactor)

        var compressedSection = compressedInput.substring(endOfMarker + 1, indexOfLastCompressedCharacter + 1)
        var startOfMarkerInsideSection = compressedSection.indexOf('(')
        while (startOfMarkerInsideSection != -1){
            val indexOfLastCharInSubSection = handleCompression(compressedSection, startOfMarkerInsideSection, decompressedBuilder, factor)
            compressedSection = compressedSection.substring(indexOfLastCharInSubSection + 1)
            startOfMarkerInsideSection = compressedSection.indexOf('(')
        }

        for (times in 1..factor) {
            compressedSection.forEach { decompressedBuilder.append(it) }
        }
        return indexOfLastCompressedCharacter
    }

    private fun getIndexOfLastCompressedCharacterAndFactor(compressedInput: String, startOfMarker: Int, endOfMarker: Int, parentFactor: Int): Pair<Int, Int> {
        val marker = compressedInput.substring(startOfMarker + 1, endOfMarker).split('x')
        val amountOfCharactersToMultiply = marker[0].toInt()
        val factor = marker[1].toInt() * parentFactor
        val indexOfLastCompressedCharacter = endOfMarker + amountOfCharactersToMultiply
        return Pair(indexOfLastCompressedCharacter, factor)
    }
}
//        val startOfMarkerInsideMarker = compressedSection.indexOf('(')

//        if(startOfMarkerInsideMarker != -1) {
//            val indexOfLastCompressedCharacterInsideSection = handleCompression(compressedSection, startOfMarkerInsideMarker, decompressedBuilder, factor)
//            var subSection = compressedSection.substring(indexOfLastCompressedCharacterInsideSection)
//            var startOfSecondMarkerInsideMarker = subSection.indexOf('(')
//            while(startOfSecondMarkerInsideMarker != -1){
//                var indexOfLastCharInSubSection = handleCompression(subSection, startOfSecondMarkerInsideMarker, decompressedBuilder, factor)
//                subSection = subSection.substring(indexOfLastCharInSubSection)
//                startOfSecondMarkerInsideMarker = subSection.indexOf('(')
//            }
//            return indexOfLastCompressedCharacterInsideSection + endOfMarker + 1
//        }