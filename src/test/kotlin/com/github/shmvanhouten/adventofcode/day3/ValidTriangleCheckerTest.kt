package com.github.shmvanhouten.adventofcode.day3

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class ValidTriangleCheckerTest{

    @Test
    fun `it should assert the triangle with sides 3, 3, 3 is a valid triangle`() {
        val triangleChecker = ValidTriangleChecker()
        assertThat(triangleChecker.isTriangleValid("3  3  3"), `is`(true))
    }

    @Test
    fun `it should say the triangle with sides 1,8,3 is not a valid triangle`() {
        val triangleChecker = ValidTriangleChecker()
        assertThat(triangleChecker.isTriangleValid("1  8  3"), `is`(false))
    }
}