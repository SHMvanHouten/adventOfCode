package com.github.shmvanhouten.adventofcode.day14

class HashFilter2016HashImpl(private val salt: String, private val hashUtil: HashUtil = HashUtil): HashFilter(salt, hashUtil) {
    override fun hashSalt(index: Int): String {
        var hash = hashUtil.hashMd5(salt + index)
        0.until(2016).forEach {
            hash = hashUtil.hashMd5(hash)
        }
        return hash
    }
}