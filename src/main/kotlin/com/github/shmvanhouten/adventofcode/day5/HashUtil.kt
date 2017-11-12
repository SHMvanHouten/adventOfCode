package com.github.shmvanhouten.adventofcode.day5

import java.security.MessageDigest

/**
 * Hashing Utils
 * @author Sam Clarke <www.samclarke.com>
 * @license MIT
 * Adapted by Sjoerd van Houten to help with http://adventofcode.com/2016/day/5
 */

class HashUtil {

    fun get00000xHashMd5(input: String) = hashStringIfItStartsWith00000("MD5", input)

    private fun hashStringIfItStartsWith00000(type: String, input: String): Char? {
        val HEX_CHARS = "0123456789abcdef"
        val bytes = MessageDigest
                .getInstance(type)
                .digest(input.toByteArray())

        run breaker@ {
            bytes.forEachIndexed { index, byte ->
                val i = byte.toInt()
                val firstHex = HEX_CHARS[i shr 4 and 0x0f]
                val secondHex = HEX_CHARS[i and 0x0f]

                when (index) {
                    0, 1 -> if (firstHex != '0' || secondHex != '0') return@breaker
                    2    -> if( firstHex == '0') return secondHex
                }
            }
        }
        return null
    }
}