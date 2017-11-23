package com.github.shmvanhouten.adventofcode.day12

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class AssemBunnyCodeRunnerTest {

    @Test
    fun `it should store a value of 3 to the register a`() {
        val runner = AssemBunnyCodeRunner()
        val state = runner.runInput("cpy 3 a")
        assertThat(state.a, equalTo(3))
    }

@Test
    fun `it should store a value of 5 to the register a`() {
        val runner = AssemBunnyCodeRunner()
        val state = runner.runInput("cpy 5 a")
        assertThat(state.a, equalTo(5))
    }

@Test
    fun `it should store a value of 3 to the register b`() {
        val runner = AssemBunnyCodeRunner()
        val state = runner.runInput("cpy 3 b")
        assertThat(state.b, equalTo(3))
    }

@Test
    fun `it should store a value of 3 to the register c`() {
        val runner = AssemBunnyCodeRunner()
        val state = runner.runInput("cpy 3 c")
        assertThat(state.c, equalTo(3))
    }


}