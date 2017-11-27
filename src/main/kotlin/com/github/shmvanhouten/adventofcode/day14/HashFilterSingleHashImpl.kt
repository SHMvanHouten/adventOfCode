package com.github.shmvanhouten.adventofcode.day14

class HashFilterSingleHashImpl(private val salt: String, private val hashUtil: HashUtil = HashUtil): HashFilter(salt, hashUtil) {
    override fun hashSalt(index: Int): String = hashUtil.hashMd5(salt + index)
}