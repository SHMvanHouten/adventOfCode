package com.github.shmvanhouten.adventofcode.day13

import org.junit.Test


class MazeBuilderTest{

    @Test
    fun `it should create a maze`() {
        val mazeBuilder = MazeBuilder()
        val maze = mazeBuilder.build(1352)
        for (line in maze) {
            val lineToChar = line.map { if(it == 0) '#' else '.' }
            println(lineToChar.joinToString(""))
        }
    }
}