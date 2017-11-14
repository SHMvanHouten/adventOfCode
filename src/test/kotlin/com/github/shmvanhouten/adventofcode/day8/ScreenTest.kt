package com.github.shmvanhouten.adventofcode.day8

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ScreenTest {

    @Test
    fun `it should light up a 1 by 1 area`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(1,1)
        assertThat(screen.amountOfPixelsLit(), equalTo(1))
        assertThat(screen.getPixel(0,0), equalTo(true))
    }

    @Test
    fun `it should light up a 2 by 1 area`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(2,1)
        assertThat(screen.amountOfPixelsLit(), equalTo(2))
        assertThat(screen.getPixel(1,0), equalTo(true))
    }

    @Test
    fun `it should light up a 3 by 4 area`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(3,4)
        assertThat(screen.amountOfPixelsLit(), equalTo(12))
        assertThat(screen.getPixel(1,0), equalTo(true))
    }

    @Test
    fun `it should move pixels to the right 1 in column 1`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(3,4)
        screen.rotateRowByAmount(1, 1)
        assertThat(screen.amountOfPixelsLit(), equalTo(12))
        assertThat(screen.getPixel(0,1), equalTo(false))
        assertThat(screen.getPixel(3,1), equalTo(true))
    }
}