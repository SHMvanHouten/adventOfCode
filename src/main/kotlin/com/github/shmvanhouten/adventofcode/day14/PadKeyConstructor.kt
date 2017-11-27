package com.github.shmvanhouten.adventofcode.day14

class PadKeyConstructor() {
    fun getKeys(amount: Int, salt: String): List<PadKey> {
        val hashFilter = HashFilter(salt)

        var possiblePadKeys = setOf<PadKey>()
        var foundPadKeys = setOf<PadKey>()

        var index = 0
        val regex = Regex("""(.)\1{4,}""")
        while (foundPadKeys.size < amount){
            val possiblePadKey = hashFilter.getNext(index)

            val possible5CharStrings: MatchResult? = regex.find(possiblePadKey.md5Hash)

            if (possible5CharStrings != null) {
                possiblePadKeys = possiblePadKeys.filter { it.index >= possiblePadKey.index - 1000 }.toSet()

                val charThatIsRepeated5Times = possible5CharStrings.value[0]

                val elements = possiblePadKeys.filter { it.firstTripletChar == charThatIsRepeated5Times }
                foundPadKeys = foundPadKeys.plus(elements)
                possiblePadKeys = possiblePadKeys.minus(elements)
            }

            possiblePadKeys += possiblePadKey
            index = possiblePadKey.index + 1
        }
        return foundPadKeys.sortedBy { it.index }
    }
}