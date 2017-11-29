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

        var doorUp = CLOSED
        var doorDown = CLOSED
        var doorLeft = CLOSED
        var doorRight = CLOSED

        for(index in 0.until(1)){
            val i = bytes[index].toInt()
            doorUp = getLockStateFromHexadecimalValue(HEX_CHARS[i shr 4 and 0x0f])
            doorDown = getLockStateFromHexadecimalValue(HEX_CHARS[i and 0x0f])
        }
        for(index in 1.until(2)){
            val i = bytes[index].toInt()
            doorLeft = getLockStateFromHexadecimalValue(HEX_CHARS[i shr 4 and 0x0f])
            doorRight = getLockStateFromHexadecimalValue(HEX_CHARS[i and 0x0f])
        }

        return DoorsToAdjacentRooms(doorUp, doorDown, doorLeft, doorRight)
    }

    private fun getLockStateFromHexadecimalValue(hexadecimal: Char): DoorState {
        return when(hexadecimal){
            'b','c','d','e','f' -> OPEN
            else -> CLOSED
        }
    }

}