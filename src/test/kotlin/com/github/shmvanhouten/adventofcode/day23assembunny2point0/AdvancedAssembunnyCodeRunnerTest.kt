package com.github.shmvanhouten.adventofcode.day23assembunny2point0

import com.github.shmvanhouten.adventofcode.day12.BunnyState
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class AdvancedAssembunnyCodeRunnerTest {

    @Test
    fun `it should run and end with value of register a = 3`() {
        val codeRunner = AdvancedAssembunnyCodeRunner()
        val input = """cpy 2 a
tgl a
tgl a
tgl a
cpy 1 a
dec a
dec a"""
        assertThat(codeRunner.runInput(input).a, equalTo(3))
    }

    @Test
    fun `it should solve the challenge input`() {
        val codeRunner = AdvancedAssembunnyCodeRunner()
        assertThat(codeRunner.runInput(day23ChallengeInput, BunnyState(a = 7)).a, equalTo(11200))
    }
}

val day23ChallengeInput = """cpy a b
dec b
cpy a d
cpy 0 a
cpy b c
inc a
dec c
jnz c -2
dec d
jnz d -5
dec b
cpy b c
cpy c d
dec d
inc c
jnz d -2
tgl c
cpy -16 c
jnz 1 c
cpy 80 c
jnz 77 d
inc a
inc d
jnz d -2
inc c
jnz c -5"""