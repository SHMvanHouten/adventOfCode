package com.github.shmvanhouten.adventofcode.day4

class RoomFinder (private val roomKeyDecoder: RoomKeyDecoder = RoomKeyDecoder()){

    fun findRoomWithName(nameToSearch: String, encodedRoomNames: String): Int? {

        val validRooms: List<Pair<List<String>, Int>> = roomKeyDecoder.getListOfValidRooms(encodedRoomNames)

        val sectorId = validRooms.find { buildDecodedName(it.first, it.second)== nameToSearch }?.second
        return sectorId
    }

    private fun buildDecodedName(words: List<String>, sectorId: Int): String {
        return words.joinToString(" ") { it.shiftLettersBy(sectorId) }
    }
}

private fun String.shiftLettersBy(sectorId: Int): String {
    val amountToShift = sectorId % 26
    val shifted = this.map { if(it + amountToShift > 'z') (it - 26 + amountToShift) else (it + amountToShift) }.joinToString("")
    return shifted
}