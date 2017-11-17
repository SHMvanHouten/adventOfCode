package com.github.shmvanhouten.adventofcode.day9

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class DecompressorV2TailRecursionImplTest {

    @Test
    fun `it should give a length of 8 for "ABCDEFGH"`() {
        val decompressor = DecompressorV2TailRecursionImpl()
        assertThat(decompressor.getDecompressionSize("ABCDEFGH"), equalTo(8L))
    }

    @Test
    fun `it should repeat A 241920 times for input "(27x12)(20x12)(13x14)(7x10)(1x12)A"`() {
        val decompressor = DecompressorV2TailRecursionImpl()
        assertThat(decompressor.getDecompressionSize("(27x12)(20x12)(13x14)(7x10)(1x12)A"), equalTo(241920L))
    }

    @Test
    fun `it should decompress a string 445 chars long for input "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"`() {
        val decompressor = DecompressorV2TailRecursionImpl()
        assertThat(decompressor.getDecompressionSize("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"), equalTo(445L))
    }

    @Test
    fun `it should decompress the first part of the challenge input`() {
        val decompressor = DecompressorV2TailRecursionImpl()
        assertThat(decompressor.getDecompressionSize(day9ChallengeSmallerPart), equalTo(167916441L))
    }

    @Test
    fun `it should decompress the challenge input`() {
        val decompressor = DecompressorV2TailRecursionImpl()
        assertThat(decompressor.getDecompressionSize(day9ChallengeInput), equalTo(11451628995L))
    }
}