package com.github.shmvanhouten.adventofcode.day13

import org.junit.Test


class MazeBuilderTest{

    @Test
    fun `it should create a maze`() {
        val mazeBuilder = MazeBuilder()
        val maze = mazeBuilder.build(1352)
        maze
                .map { line -> line.map { if(it == 0) '#' else '.' } }
                .forEach { println(it.joinToString("")) }
    }
}