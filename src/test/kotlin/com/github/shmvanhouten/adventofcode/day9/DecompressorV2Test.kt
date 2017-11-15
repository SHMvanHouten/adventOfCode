package com.github.shmvanhouten.adventofcode.day9

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class DecompressorV2Test {

    @Test
    fun `it should decompress "(3x3)XYZ" to "XYZXYZXYZ"`() {
        val decompressor = DecompressorV2()
        assertThat(decompressor.decompress("(3x3)XYZ"), equalTo("XYZXYZXYZ"))
    }

    @Test
    fun `it should decompress "X(8x2)(3x3)ABCY" to "XABCABCABCABCABCABCY"`() {
        val decompressor = DecompressorV2()
        assertThat(decompressor.decompress("X(8x2)(3x3)ABCY"), equalTo("XABCABCABCABCABCABCY"))
    }

    @Test
    fun `it should decompress "(25x3)(3x3)ABC(2x3)XY" to "ABCABCABCABCABCABCABCABCABCXYXYXYXYXYXYXYXYXY"`() {
        val decompressor = DecompressorV2()
        println(decompressor.decompress("(15x3)(3x3)ABC(2x3)XY"))
        assertThat(decompressor.decompress("(15x2)(3x2)ABC(2x2)XY"), equalTo("ABCABCABCABCXYXYXYXY"))
    }

    @Test
    fun `it should repeat A 241920 times for input "(27x12)(20x12)(13x14)(7x10)(1x12)A"`() {
        val decompressor = DecompressorV2()
        assertThat(decompressor.getSizeOfDecompressedString("(27x12)(20x12)(13x14)(7x10)(1x12)A"), equalTo(241920))
    }

    @Test
    fun `it should decompress a string 445 chars long for input "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"`() {
        val decompressor = DecompressorV2()
        assertThat(decompressor.getSizeOfDecompressedString("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"), equalTo(445))
    }

    @Test
    fun `it should decompress the challenge input`() {
        val decompressor = DecompressorV2()
        assertThat(decompressor.getSizeOfDecompressedString(day9ChallengeInput), equalTo(107035))
    }


}