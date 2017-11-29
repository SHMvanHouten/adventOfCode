package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.RelativePosition.*

class RoomMapBuilder {
    fun buildRoomMap(rawRoomMap: String): RoomMap {
        val rows = rawRoomMap.split("\n")
        val width = (rows[0].length - 1) / 2
        val height = (rows.size - 1) / 2

        val roomMap = mutableMapOf<Coordinate, Room>()
        for (y in 0.until(height)) {
            for (x in 0.until(width)) {
                val coordinateOfCurrentRoom = Coordinate(x, y)
                val mapOfAdjacentRooms = getAdjacentRooms(coordinateOfCurrentRoom, height, width)
                roomMap.put(coordinateOfCurrentRoom, Room(mapOfAdjacentRooms))
            }
        }
        return RoomMap(roomMap.toSortedMap())
    }

    private fun getAdjacentRooms(coordinateOfCurrentRoom: Coordinate, height: Int, width: Int): Map<RelativePosition, Coordinate> {
        val adjacentRooms = mutableMapOf<RelativePosition, Coordinate>()
        val x = coordinateOfCurrentRoom.x
        val y = coordinateOfCurrentRoom.y
        if(x > 0){
            adjacentRooms.put(LEFT, Coordinate(x - 1, y))
        }
        if(x < width - 1){
            adjacentRooms.put(RIGHT, Coordinate(x + 1, y))
        }
        if(y > 0){
            adjacentRooms.put(UP, Coordinate(x, y - 1))
        }
        if(y < height - 1){
            adjacentRooms.put(DOWN, Coordinate(x, y + 1))
        }
        if(x == height - 1 && y == width - 1){
            // vault room is always end of the line, so it doesn't need its adjoining rooms
            return emptyMap()
        }
        return adjacentRooms
    }
}