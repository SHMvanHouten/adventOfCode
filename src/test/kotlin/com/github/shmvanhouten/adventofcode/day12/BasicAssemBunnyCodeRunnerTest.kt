package com.github.shmvanhouten.adventofcode.day12

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class BasicAssemBunnyCodeRunnerTest {

    @Test
    fun `it should store a value of 3 to the register a`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("cpy 3 a")
        assertThat(state.a, equalTo(3))
    }

@Test
    fun `it should store a value of 5 to the register a`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("cpy 5 a")
        assertThat(state.a, equalTo(5))
    }

@Test
    fun `it should store a value of 3 to the register b`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("cpy 3 b")
        assertThat(state.b, equalTo(3))
    }

@Test
    fun `it should store a value of 3 to the register c`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("cpy 3 c")
        assertThat(state.c, equalTo(3))
    }


@Test
    fun `it should store a value of 3 to register a and 5 to the register c`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("""cpy 5 c
cpy 3 a""")
        assertThat(state, equalTo(BunnyState(a = 3, c = 5)))
    }

    @Test
    fun `it should increase the value of a by 1 to 42`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("""cpy 41 a
inc a""")
        assertThat(state, equalTo(BunnyState(a = 42)))
    }

    @Test
    fun `it should decrease the value of a by 1 to 40`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("""cpy 41 a
dec a""")
        assertThat(state, equalTo(BunnyState(a = 40)))
    }

    @Test
    fun `it should jump forwards to skip the last instruction`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("""cpy 41 a
inc a
inc a
dec a
jnz a 2
dec a""")
        assertThat(state, equalTo(BunnyState(a = 42)))
    }
    @Test
    fun `it should jump backwards to dec a and finally add 1`() {
        val runner = BasicAssemBunnyCodeRunner()
        val state = runner.runInput("""cpy 41 a
inc a
inc a
dec a
jnz a -1
inc a""")
        assertThat(state, equalTo(BunnyState(a = 1)))
    }

    @Test
    fun `it should run the challenge input`() {
        val runner = BasicAssemBunnyCodeRunner()
        assertThat(runner.runInput(challengeInput), equalTo(BunnyState(a = 318083, b = 196418)))
    }

    @Test
    fun `it should run the challenge input with a different initial state c = 1`() {
        val runner = BasicAssemBunnyCodeRunner()
        assertThat(runner.runInput(challengeInput, BunnyState(c = 1)), equalTo(BunnyState(a = 9227737, b = 5702887)))
    }
}
val challengeInput = """cpy 1 a
cpy 1 b
cpy 26 d
jnz c 2
jnz 1 5
cpy 7 c
inc d
dec c
jnz c -2
cpy a c
inc a
dec b
jnz b -2
cpy c b
dec d
jnz d -6
cpy 16 c
cpy 17 d
inc a
dec d
jnz d -2
dec c
jnz c -5"""