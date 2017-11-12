package com.github.shmvanhouten.adventofcode.day5

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class PasswordFinderTest {

    @Test
    fun `it should find the password for room abc`() {
        val passwordFinder = PasswordFinder()
        val expectedPassword = "18f47a30"
        val retrievedPassword = passwordFinder.calculatePassword("abc")

        assertThat(retrievedPassword, equalTo(expectedPassword))

    }

    @Test
    fun `it should solve the input for the challenge, roomId ugkcyxxp`() {
        val passwordFinder = PasswordFinder()
        val expectedPassword = "d4cd2ee1"
        val retrievedPassword = passwordFinder.calculatePassword("ugkcyxxp")

        assertThat(retrievedPassword, equalTo(expectedPassword))

    }
}