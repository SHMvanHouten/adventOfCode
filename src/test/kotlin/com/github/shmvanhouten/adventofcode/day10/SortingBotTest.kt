package com.github.shmvanhouten.adventofcode.day10

import com.github.shmvanhouten.adventofcode.day10.DestinationType.BOT
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class SortingBotTest {

    private val botDispatch = BotDispatch()

    @Test
    fun `it should give the instruction back '3 to bot3 and 5 to bot7'`() {
        val bot = SortingBot(Instruction(Destination(BOT, 3), Destination(BOT, 7)), botDispatch,1)
        bot.takeChip(5)
        bot.takeChip(3)
        assertThat(bot.pickupLog?.highChip, equalTo(5))
    }

    @Test
    fun `it should take the chip but not do it's task yet`() {
        val bot = SortingBot(Instruction(Destination(BOT, 3), Destination(BOT, 7)), botDispatch,1)
        bot.takeChip(5)
        val isNull = bot.pickupLog == null
        assertThat(isNull, equalTo(true))
    }
}