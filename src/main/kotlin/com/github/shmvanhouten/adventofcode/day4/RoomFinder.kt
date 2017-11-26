package com.github.shmvanhouten.adventofcode.day4

class RoomFinder(private val roomKeyDecoder: RoomKeyDecoder = RoomKeyDecoder()) {

    fun findRoomWithName(nameToSearch: String, encodedRoomNames: String): Int? {

        val validRooms: List<Room> = roomKeyDecoder.getListOfValidRooms(encodedRoomNames)

        return validRooms
                .find { buildDecodedName(it.words, it.sectorId) == nameToSearch }
                ?.sectorId
    }

    private fun buildDecodedName(words: List<String>, sectorId: Int): String {
        return words
                .joinToString(" ") { it.shiftLettersBy(sectorId) }
    }
}

private fun String.shiftLettersBy(sectorId: Int): String {
    val amountToShift = sectorId % 26
    return map { if (it + amountToShift > 'z') (it - 26 + amountToShift) else (it + amountToShift) }
            .joinToString("")
}