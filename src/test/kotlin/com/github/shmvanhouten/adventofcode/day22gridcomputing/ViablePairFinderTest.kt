package com.github.shmvanhouten.adventofcode.day22gridcomputing

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ViablePairFinderTest {
    @Test
    fun `it should find the two nodes to be a viable pair`() {
        val pairFinder = ViablePairFinder()
        val rawInput = """root@ebhq-gridcenter# df -h
Filesystem              Size  Used  Avail  Use%
/dev/grid/node-x0-y0     92T   73T    19T   79%
/dev/grid/node-x0-y1     140T   66T    74T   47%"""
        assertThat(pairFinder.countViablePairsFromRawInput(rawInput), equalTo(1))
    }
}