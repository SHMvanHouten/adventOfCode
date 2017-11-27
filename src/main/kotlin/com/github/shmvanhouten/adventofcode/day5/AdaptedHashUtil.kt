package com.github.shmvanhouten.adventofcode.day5

import java.security.MessageDigest

/**
 * Adapted by Sjoerd van Houten to help with http://adventofcode.com/2016/day/5
 * with thanks to Sam Clarke <www.samclarke.com>
 */

class AdaptedHashUtil {
    private val HEX_CHARS = "0123456789abcdef"
    private val MD5 = "MD5"



    fun hashStringIfItStartsWith00000(input: String): Char? {
        val bytes = MessageDigest
                .getInstance(MD5)
                .digest(input.toByteArray())

        run breaker@ {
            bytes.forEachIndexed { index, byte ->
                val i = byte.toInt()
                val firstHex = HEX_CHARS[i shr 4 and 0x0f]
                val secondHex = HEX_CHARS[i and 0x0f]

                when (index) {
                    0, 1 -> if (firstHex != '0' || secondHex != '0') return@breaker
                    2 -> if (firstHex == '0') return secondHex
                }
            }
        }
        return null
    }

    fun hashStringIfItStartsWith00000xWherexIs1to7inc(input: String): Pair<Char, Char>? {
        val bytes = MessageDigest
                .getInstance(MD5)
                .digest(input.toByteArray())
        var sixthHexInHash = '_'

        run breaker@ {
            bytes.forEachIndexed { index, byte ->
                val byteToInt = byte.toInt()
                val firstHexFromByte = HEX_CHARS[byteToInt shr 4 and 0x0f]
                val secondHex = HEX_CHARS[byteToInt and 0x0f]

                when (index) {
                    0, 1 -> if (firstHexFromByte != '0' || secondHex != '0') return@breaker
                    2 -> if (firstHexFromByte == '0' && secondHex <= '7') sixthHexInHash = secondHex else return@breaker
                    3 -> return Pair(sixthHexInHash, firstHexFromByte)
                }
            }
        }
        return null
    }
}