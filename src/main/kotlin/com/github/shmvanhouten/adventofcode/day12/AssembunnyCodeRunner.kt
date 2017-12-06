package com.github.shmvanhouten.adventofcode.day12

interface AssembunnyCodeRunner {

    fun runInput(input: String, initialState: BunnyState = BunnyState()): BunnyState
}