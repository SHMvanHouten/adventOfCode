package com.github.shmvanhouten.adventofcode.day10

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class InstructionCentralTest {

    @Test
    fun `it should assert that bot 2 is responsible for comparing 2 and 5 chips`() {
        val instructor = InstructionCentral()
        val instructions = """value 5 goes to bot 2
bot 2 gives low to bot 1 and high to bot 0
value 3 goes to bot 1
bot 1 gives low to output 1 and high to bot 0
bot 0 gives low to output 2 and high to output 0
value 2 goes to bot 2"""
        val botNumber = instructor.findBotThatComparesValues(instructions, 2, 5)
        assertThat(botNumber, equalTo(2))
    }
}