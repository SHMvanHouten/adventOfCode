package com.github.shmvanhouten.adventofcode.day8

import com.github.shmvanhouten.adventofcode.day8.PixelState.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ScreenTest {

    @Test
    fun `it should light up a 1 by 1 area`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(1,1)
        assertThat(screen.amountOfPixelsLit(), equalTo(1))
        assertThat(screen.getPixel(0,4), equalTo(OFF))
    }

    @Test
    fun `it should light up a 2 by 1 area`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(2,1)
        assertThat(screen.amountOfPixelsLit(), equalTo(2))
        assertThat(screen.getPixel(1,4), equalTo(OFF))
    }

    @Test
    fun `it should light up a 3 by 4 area`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(3,4)
        assertThat(screen.amountOfPixelsLit(), equalTo(12))
        assertThat(screen.getPixel(1,1), equalTo(ON))
    }

    @Test
    fun `it should move pixels to the right 1 in row 1`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(3,4)
        screen.rotateRowByAmount(1, 1)
        assertThat(screen.amountOfPixelsLit(), equalTo(12))
        assertThat(screen.getPixel(0,1), equalTo(OFF))
        assertThat(screen.getPixel(3,1), equalTo(ON))
    }

    @Test
    fun `it should move pixels down 3 in column 2`() {
        val screen = Screen(5, 5)
        screen.turnOnPixelsTopLeft(3,3)
        screen.rotateColumnByAmount(2, 3)
        assertThat(screen.amountOfPixelsLit(), equalTo(9))
        assertThat(screen.getPixel(2,4), equalTo(ON))
        assertThat(screen.getPixel(2,0), equalTo(ON))
        assertThat(screen.getPixel(2,3), equalTo(ON))
    }
}