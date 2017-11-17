package com.github.shmvanhouten.adventofcode.day10

import com.github.shmvanhouten.adventofcode.day10.DestinationType.BOT
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class SortingBotTest {

    @Test
    fun `it should give the instruction back '3 to bot3 and 5 to bot7'`() {
        val bot = SortingBot(Instruction(Destination(BOT, 3), Destination(BOT, 7)))
        bot.takeChip(5)
        assertThat(bot.takeChip(3)?.second, equalTo(Task(Destination(BOT, 7), 5)))
    }
}