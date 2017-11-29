package com.github.shmvanhouten.adventofcode.day14


abstract class HashFilter(private val salt: String, private val hashUtil: HashUtil) {
    fun getNext(indexToStart: Int): PadKey {
        var possiblePadKey: PadKey? = null

        val regex = Regex("""(.)\1{2,}""")

        var index = indexToStart
        while (possiblePadKey == null){
            val md5Hash = hashSalt(index)
            val matchedString = regex.find(md5Hash)
            if(matchedString != null){
                possiblePadKey = PadKey(index, md5Hash, matchedString.value[0])
            }
            index++
        }
        return possiblePadKey
    }

    abstract fun hashSalt(index: Int): String


}