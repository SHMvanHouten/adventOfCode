package com.github.shmvanhouten.adventofcode.day18likearogue

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class SafeTileCounterTest {

    @Test
    fun `it should count 38 safe tiles in the TileFloor drawn from the input`() {
        val safeTileCounter = SafeTileCounter()
        val firstRow = ".^^.^.^^^^"
        assertThat(safeTileCounter.countForRawInput(firstRow, 10), equalTo(38))
    }

    @Test
    fun `it should count the safe tiles in the TileFloor drawn from the challenge input`() {
        val safeTileCounter = SafeTileCounter()
        val firstRow = ".^^^.^.^^^.^.......^^.^^^^.^^^^..^^^^^.^.^^^..^^.^.^^..^.^..^^...^.^^.^^^...^^.^.^^^..^^^^.....^...."
        assertThat(safeTileCounter.countForRawInput(firstRow, 40), equalTo(2013))
    }

}