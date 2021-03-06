package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class LongestPathToVaultFinderTest {

    @Test
    fun `it should find the path DDRRRD for passcode ihgpwlah`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = LongestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.find("ihgpwlah").length, equalTo(370))
    }

    @Test
    fun `it should find the path DDUDRLRRUDRD for passcode kglvqrro`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = LongestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.find("kglvqrro").length, equalTo(492))
    }

    @Test
    fun `it should find the path DRURDRUDDLLDLUURRDULRLDUUDDDRR for passcode ulqzkmiv`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = LongestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.find("ulqzkmiv").length, equalTo(830))
    }

    @Test
    fun `it should find the path DDURRLRRDD for challenge input passcode bwnlcvfs`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = LongestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.find("bwnlcvfs").length, equalTo(436))
    }

}