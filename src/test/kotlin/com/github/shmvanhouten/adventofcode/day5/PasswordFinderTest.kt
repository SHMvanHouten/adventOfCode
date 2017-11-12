package com.github.shmvanhouten.adventofcode.day5

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Ignore
import org.junit.Test

class PasswordFinderTest {

    @Test
    fun `it should find the password for room abc first door`() {
        val passwordFinder = PasswordFinder()
        val expectedPassword = "18f47a30"
        val retrievedPassword = passwordFinder.calculatePasswordForFirstDoor("abc")

        assertThat(retrievedPassword, equalTo(expectedPassword))

    }

    @Test
    fun `it should solve the input for the challenge, roomId ugkcyxxp first door`() {
        val passwordFinder = PasswordFinder()
        val expectedPassword = "d4cd2ee1"
        val retrievedPassword = passwordFinder.calculatePasswordForFirstDoor("ugkcyxxp")

        assertThat(retrievedPassword, equalTo(expectedPassword))

    }

    @Test
    fun `it should find the password for room abc second door`() {
        val passwordFinder = PasswordFinder()
        val expectedPassword = "05ace8e3"
        val retrievedPassword = passwordFinder.calculatePasswordForSecondDoor("abc")

        assertThat(retrievedPassword, equalTo(expectedPassword))

    }


    @Test
    fun `it should solve the input for the challenge, roomId ugkcyxxp second door`() {
        val passwordFinder = PasswordFinder()
        val expectedPassword = "d4cd2ee1"
        val retrievedPassword = passwordFinder.calculatePasswordForSecondDoor("ugkcyxxp")

        assertThat(retrievedPassword, equalTo(expectedPassword))

    }

}