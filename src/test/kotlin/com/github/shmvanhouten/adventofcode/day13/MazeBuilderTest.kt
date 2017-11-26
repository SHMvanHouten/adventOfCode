package com.github.shmvanhouten.adventofcode.day13

import com.github.shmvanhouten.adventofcode.day13.MazeComponent.WALL
import org.junit.Test


class MazeBuilderTest{

    @Test
    fun `it should create a maze`() {
        val mazeBuilder = MazeBuilder()
        val maze = mazeBuilder.build(1352)
        maze.draw()
    }
}

fun Maze.draw() {
    for(y in 0.until(this.height)){
        val rowRepBuilder = StringBuilder()
        for(x in 0.until(this.width)){
            val mazeComponentChar = if(this.getComponent(x,y) == WALL) '#' else '.'
            rowRepBuilder.append(mazeComponentChar)
        }
        println(rowRepBuilder.toString())
    }
}
