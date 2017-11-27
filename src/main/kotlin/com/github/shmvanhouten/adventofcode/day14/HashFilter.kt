package com.github.shmvanhouten.adventofcode.day14

import java.util.regex.Pattern

class HashFilter(val hashUtil: HashUtil = HashUtil) {
    fun getNext(indexToStart: Int, salt: String): PadKey {
        var possiblePadKey: PadKey? = null
        var pattern = Regex("""(.)\1{2,}""")
        var index = indexToStart
        while (possiblePadKey == null){
            val md5Hash = hashUtil.hashMd5(salt + index)
            println(md5Hash)
            if(md5Hash.contains(pattern)){
                possiblePadKey = PadKey(index, md5Hash)
            }
            index++
        }
        return possiblePadKey
    }


}