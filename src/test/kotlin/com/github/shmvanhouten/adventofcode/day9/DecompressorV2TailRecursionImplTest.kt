package com.github.shmvanhouten.adventofcode.day9

import com.natpryce.hamkrest.equalTo
import org.junit.Test

class DecompressorV2TailRecursionImplTest {

    @Test
    fun `it should repeat A 241920 times for input "(27x12)(20x12)(13x14)(7x10)(1x12)A"`() {
        val decompressor = DecompressorV2TailRecursionImpl()
        com.natpryce.hamkrest.assertion.assertThat(decompressor.getDecompressionSize("(27x12)(20x12)(13x14)(7x10)(1x12)A"), equalTo(241920))
    }

    @Test
    fun `it should decompress a string 445 chars long for input "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"`() {
        val decompressor = DecompressorV2TailRecursionImpl()
        com.natpryce.hamkrest.assertion.assertThat(decompressor.getDecompressionSize("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"), equalTo(445))
    }
}