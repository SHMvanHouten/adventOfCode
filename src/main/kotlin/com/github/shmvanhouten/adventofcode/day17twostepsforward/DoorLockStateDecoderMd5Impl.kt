package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.*
import java.security.MessageDigest

class DoorLockStateDecoderMd5Impl : DoorLockStateDecoder {
    override fun findLockStateForDoorsAdjacent(doorCode: String): DoorsToAdjacentRooms {
        val TYPE = "md5"
        val HEX_CHARS = "0123456789abcdef"
        val bytes = MessageDigest
                .getInstance(TYPE)
                .digest(doorCode.toByteArray())

        val firstByte = bytes[0].toInt()
        val doorUp = getLockStateFromHexadecimalValue(HEX_CHARS[firstByte shr 4 and 0x0f])
        val doorDown = getLockStateFromHexadecimalValue(HEX_CHARS[firstByte and 0x0f])

        val secondByte = bytes[1].toInt()
        val doorLeft = getLockStateFromHexadecimalValue(HEX_CHARS[secondByte shr 4 and 0x0f])
        val doorRight = getLockStateFromHexadecimalValue(HEX_CHARS[secondByte and 0x0f])

        return DoorsToAdjacentRooms(doorUp, doorDown, doorLeft, doorRight)
    }

    private fun getLockStateFromHexadecimalValue(hexadecimal: Char): DoorState {
        return when (hexadecimal) {
            'b', 'c', 'd', 'e', 'f' -> OPEN
            else -> CLOSED
        }
    }

}