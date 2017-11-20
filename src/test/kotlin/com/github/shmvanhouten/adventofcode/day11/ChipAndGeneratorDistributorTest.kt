package com.github.shmvanhouten.adventofcode.day11

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ChipAndGeneratorDistributorTest {


    @Test
    fun `it should move the chips and generators in 15 steps`() {
        val floorPlan = mapOf(1 to Pair(listOf(Chip("hydrogen"), Chip("lithium")), listOf(Generator("hydrogen"), Generator("lithium"))),
                2 to Pair(emptyList(), emptyList()),
                3 to Pair(emptyList(), emptyList()),
                4 to Pair(emptyList(), emptyList()))
        val distributor = ChipAndGeneratorDistributor()
        val steps = distributor.findQuickestWayToTop(floorPlan)
        assertThat(steps, equalTo(3 * 5))
    }

    @Test
    fun `it should move the chips and generators in 11 steps`() {
        val floorPlan = mapOf(
                1 to Pair(emptyList<Chip>(), listOf(Generator("hydrogen"), Generator("lithium"))),
                2 to Pair(listOf(Chip("hydrogen"), Chip("lithium")), emptyList()),
                3 to Pair(emptyList(), emptyList()),
                4 to Pair(emptyList(), emptyList()))
        val distributor = ChipAndGeneratorDistributor()
        val steps = distributor.findQuickestWayToTop(floorPlan)
        assertThat(steps, equalTo(1 + 2 * 5))
    }

}