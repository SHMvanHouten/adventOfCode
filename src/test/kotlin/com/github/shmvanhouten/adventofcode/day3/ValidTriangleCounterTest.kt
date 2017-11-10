package com.github.shmvanhouten.adventofcode.day3

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class ValidTriangleCounterTest {

    @Test
    fun `it should count 1 valid triangle from the input`() {
        val validTriangleCounter = ValidTriangleCounter()
        val validTriangleCount = validTriangleCounter.countValidTriangles("  1  8  1\n" +
                                                                                   "  3  3  3\n" +
                                                                                   "  3  15  4")
        assertThat(validTriangleCount, `is`(1))
    }

    @Test
    fun `it should count 3 valid triangles from the input`() {
        val validTriangleCounter = ValidTriangleCounter()
        val validTriangleCount = validTriangleCounter.countValidTriangles("  1  8  1\n" +
                                                                                   "  3  3  3\n" +
                                                                                   "  3  15  4\n" +
                                                                                   "  9  18  12\n" +
                                                                                   "  15  24  26")
        assertThat(validTriangleCount, `is`(3))
    }
}