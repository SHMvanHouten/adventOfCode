package com.github.shmvanhouten.adventofcode.day12

import com.github.shmvanhouten.adventofcode.day12.Register.a
import com.github.shmvanhouten.adventofcode.day12.Register.b
import com.github.shmvanhouten.adventofcode.day12.Register.c

class AssemBunnyCodeRunner {
    fun runInput(input: String): BunnyState {
        val instructionParts = input.split(' ')
        return when(instructionParts[2]){
            a.toString() -> BunnyState(a = instructionParts[1].toInt())
            b.toString() -> BunnyState(b = instructionParts[1].toInt())
            c.toString() -> BunnyState(c = instructionParts[1].toInt())
            else ->  BunnyState(d = instructionParts[1].toInt())
        }

    }
}

enum class Register{
    a,
    b,
    c
}